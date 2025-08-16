:orphan:

Reading a file into an array
==============================

One way to read data from a file into the array, is to expect that the file contains information about the number of records to read. The text file below begins with the number of records it contains. We can instruct our program to read that number first. And then use the number to initialize an array with as many elements and run a loop -- in this example, three times -- to read every name into the array.

.. code-block:: text

   3
   Frodo
   Sam
   Gandalf

Assuming that we already have a ``File`` pointer ``f`` to the file above, we can instantiate a scanner and perform the following operations.

.. code-block:: java

   Scanner s = new Scanner(f);
   String[] names = new String[s.nextInt()];   
   for (int i = 0; i < names.length; i++)
     names[i] = s.next();
   s.close()

I am not fond of this technique because it requires extra work: every time we add or remove a name from the file, we have to update the first line with the count of records. The great thing about programming is that it can take on mundane and repetitive tasks for us. Here's how.

Let's consider an input file with just names:

.. code-block:: text

   Rosalind
   Marie
   Ada
   Grace
   Maryam

The code below goes into the file twice: first it counts its lines. It uses this information to setup an array. And then it goes through the file a second time to read its contents and place them into the array. Here, again, we assume that we already have a ``File`` pointer ``f`` to the data file.

.. code-block:: java
   :linenos:

   Scanner s = new Scanner(f);
   // Count how may records are in the file
   int numberOfRecords = 0;
   while (s.hasNext()) {
     numberOfRecords++;
     s.nextLine();
   }
   s.close();
   // Create an array for that number of records
   String[] names = new String[numberOfRecords];
   // Scan file again to copy records to the array
   s = new Scanner(f);
   for (int i = 0; i < numberOfRecords; i++)
     names[i] = s.next();
   s.close();


A complete method is shown below. This method returns an empty array when it cannot complete its task, instead of throwing an exception.

To wrap up this note, let me mention two things. **First,** it is absolutely ok to ask the computer to do repetitive tasks, especially when that takes them away from people! In this example, the computer goes through the data file twice: one time to count and a second time to copy data to the array. That's better than having an individual count the records in a file manually and update the first line of that file with the proper number.  **Second,** we are forced to go through the file twice because we need to size  the array before we add data to it. But, as we'll find out eventually, there are data structures more flexible that humble arrays. One of them is Java's ``Arraylist``: it can accept data and adjust its size on the fly. Exploring how arraylists work, will have to wait for a bit longer, however.

.. code-block:: java

    public static String[] getRecordsByCounting(File f) {
        // This is the array that we'll return
        String[] records;
        try {
            // To establish a scanner connection to the passed File f.
            Scanner s = new Scanner(f);
            // Counter for number of records in the file.
            int numberOfRecords = 0;
            // Go through the file counting the number of lines.
            while (s.hasNextLine()) {
                numberOfRecords++;
                s.nextLine();
            }
            s.close();
            // Initialize return array with number of records found
            records = new String[numberOfRecords];
            // Re-establish scanner
            s = new Scanner(f);
            // Read records into array
            for (int i = 0; i < numberOfRecords; i++) {
                records[i] = s.nextLine();
            }
            s.close();
        } catch (Exception e){
            // In case something goes wrong, prepare to return an empty array
            records = new String[0];
        }
        return records;
    }  // method getRecordsByCounting
