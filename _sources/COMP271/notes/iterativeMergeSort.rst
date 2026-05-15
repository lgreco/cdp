:orphan:

Iterative merge sort
---------------------------------------------------


For this problem, we have a method ``merge`` that takes two *sorted* arrays and merges them into an also sorted array. The strategy is to start with the smallest possible arrays as inputs to this method. These are arrays with one element only. Single-element arrays are, by definition, sorted. Merged pairs of single-element arrays are sorted arrays with two elements. Now we can take these 2-element arrays and merge them into 4-element arrays, and so on.

Let's work out this with an example, using an array with 8 elements:

.. code-block:: java

   int[] arr = {44, 11, 34, 21, 13, 12, 10, 38};
   

And for simplicity of notation, let's assume that ``arr[p:q]`` is a subarray of ``arr`` from position ``p`` up to (but not including) position ``q``. For example, ``arr[7:8]`` will be ``[38]``. (This is just a notation; in Java we must use a method to do that, for example ``slice(arr,p,q)`` as we did in the classroom; or use ``Arrays.copyOfRange``.)

Our first task is to partition ``arr`` into the following single element arrays:

.. code-block:: java
   
   arr[0:1], arr[1:2], arr[2:3], arr[3:4], arr[4:5], arr[5:6], arr[6,7], arr[7:8]
   //  [44]      [11]      [34]      [21]      [13]      [12]      [10]      [38]
   
Now we can merge these arrays in pairs:

.. code-block:: java

   merge(arr[0:1], arr[1:2]);  // merged result [11,44]
   merge(arr[2:3], arr[3:4]);  // merged result [21,34]
   merge(arr[4:5], arr[5:6]);  // merged result [12,13]
   merge(arr[6,7], arr[7:8]);  // merged result [10,38]

The next step is to put these results back into array ``arr``, which becomes:

.. code-block:: java

   [11, 44, 21, 34, 12, 13, 10, 38] // arr after putting merged results back in

At this point ``arr`` is far from sorted, but now we can partition it into sorted subarrays of size 2:


.. code-block:: java
   
      arr[0:2],    arr[2:4],    arr[4:6],    arr[6,8]
   //  [11,44]      [21,34]      [12,13]      [10,38]

And we can pass these pairs of 2-element subarrays to our ``merge`` method:

.. code-block:: java

   merge(arr[0:2], arr[2:4]);  // merged result [11,21,34,44]
   merge(arr[4:6], arr[6,8]);  // merged result [10,12,13,38]

These results will go back into ``arr``:

.. code-block:: java

   [11, 21, 34, 44, 10, 12, 13, 38] // arr after putting merged results back in

The array is not quite sorted yet, but we are getting there. Because now it can be partitioned into two subarrays of size 4 that they are already sorted. This pair of 4-element arrays will go into the ``merge`` method:

.. code-block:: java

   merge(arr[0:4], arr[4:8]);  // merged result [10,11,12,13,21,34,38,44]

The last step is to copy the results of the merge back to the array. And now ``arr`` is finally sorted.

To summarize our partition and merge strategy:

.. code-block:: java

   // merge calls for subarray size = 1

   merge(arr[0:1], arr[1:2]);  //
   merge(arr[2:3], arr[3:4]);  // Merging 
   merge(arr[4:5], arr[5:6]);  // 4 pairs
   merge(arr[6,7], arr[7:8]);  // 

   // merge calls for subarray size = 2

   merge(arr[0:2], arr[2:4]);  // Merging 
   merge(arr[4:6], arr[6,8]);  // 2 pairs

   // merge calls for subarray size = 4
   
   merge(arr[0:4], arr[4:8]);  // Merging 1 pair


Is there a way to relate the subarray size to the number of pairs we must merge? Yes; first by recognizing that the largest subarray we can have in a pair is half the size of the array we attempt to sort. If the array has :math:`n` elements -- and we can assume that :math:`n` is a power of 2 -- then the subarray sizes will progress from 1 to :math:`n/2`, doubling at each step, This can be accomplished with a for-loop:

.. code-block:: java
   
   for (int size = 1; size <= arr.length/2; size = size*2) {
   }

The loop above will give the subarray sizes but we also need a way to determine where each subarray of a given size begins and ends. It helps to see how the size of subarrays determines the number of pairs we get, and where the subarrays in these pairs begin and end. 

.. code-block:: text

    size = 1      size = 2      size = 4
    4 pairs       2 pairs       1 pair
   
   begin:end     begin:end     begin:end
   
       0:1           0:2           0:4
       1:2           2:4           4:8
       
       2:3           4:6
       3:4           6:8
       
       4:5
       5:6
       
       6:7
       7:8
       
Looking at the column for ``size=1`` above, we see a pattern for the pairs: the first pair begins at position 0, the second pair begins at position 2, the third at position 4, and the last pair at position 6. This seems like a loop along ``arr`` with step 2. 

Next, look at the column for ``size=2``. The first pair begins at 0 and the second pair at 4. This seems like a loop along ``arr`` with step 4.

And the last column, for ``size=4`` has only one pair that begins at 0. This seems like a loop along ``arr`` with step 8.

In each case above, we need a loop along ``arr``. The step of the loop changes as the size of subarrays changes. Specifically, the loop step is ``2*size``. This implies that the loop along ``arr`` depends on the loop for ``size`` we wrote above, leading to the following nested loop snippet:

.. code-block:: java
   
   for (int size = 1; size <= arr.length/2; size = size*2) {
       for (int i = 0; i < arr.length; i = i+2*size) {
       }
   }

Are we there yet? Yes we are! We have a loop that tells us where each pair of a given size begins. Each part of the pair is an array with ``size`` number of elements. If the first part of the pair begins at position ``i``, it corresponds to the array slice ``arr[i:i+size]``. Its second part will begin at ``i+size`` and because it also have ``size`` elements it will end at ``i+size+size``. The two subarrays in this pair, let's call them ``foo`` and ``bar`` can be added to the code:

.. code-block:: java

   for (int size = 1; size <= arr.length/2; size = size*2) {
       for (int i = 0; i < arr.length; i = i+2*size) {
           int[] foo = arr[i:i+size];
           int[] bar = arr[i+size:i+2*size];
       }
   }

Finally, we need to merge the pair ``foo`` and ``bar`` and place their merged result back to the array, at the positions where that pair came from.

.. code-block:: java

   for (int size = 1; size <= arr.length/2; size = size*2) {
       for (int i = 0; i < arr.length; i = i+2*size) {
           int[] foo = arr[i:i+size];
           int[] bar = arr[i+size:i+2*size];
           int[] temp = merge(foo,bar);  // merge the pair
           for (int j = 0; j < temp.length; j++) {
               arr[i+j] = temp[j];  // copy the result of the merge back to input arr
           }
       }
   }

In the code snippets above we use the notation ``arr[p:q]`` to indicate a subarray of ``arr`` from position ``p`` up to but not including ``q``. This notation does not work in Java, so we'll need to replace it either with a our own method (e.g., ``slice``) or use ``Arrays.copyOfRange``. The final method is shown below.



.. code-block:: java

    static void iterativeMergeSort(int[] arr) {
        for (int size = 1; size <= arr.length/2; size = size*2) {
            for (int i = 0; i < arr.length; i = i+2*size) {
                int[] foo = slice(arr, i, i+size);
                int[] bar = slice(arr, i+size, i+2*size);
                int[] temp = merge(foo,bar);  // merge the pair
                for (int j = 0; j < temp.length; j++) {
                    arr[i+j] = temp[j];  // copy the result of the merge back to input arr
                }
            }
        }
    }

The code above can be shortened a bit by omitting ``foo`` and ``bar`` and writing the slices directly into the merge method:

.. code-block:: java

    static void iterativeMergeSort(int[] arr) {
        for (int size = 1; size <= arr.length/2; size = size*2) {
            for (int i = 0; i < arr.length; i = i+2*size) {
                int[] temp = merge(slice(arr, i, i+size), slice(arr, i+size, i+2*size));  // merge the pair
                for (int j = 0; j < temp.length; j++) {
                    arr[i+j] = temp[j];  // copy the result of the merge back to input arr
                }
            }
        }
    }



