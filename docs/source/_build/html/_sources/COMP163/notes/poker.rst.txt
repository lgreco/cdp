:orphan:

Probabilities of poker
======================

In five-card draw poken, players are trying to obtain the best possible combination to win. There are :math:`{52}\choose{5}` possible hands:


.. math::

   {{52}\choose{5}} & = \frac{52!}{(52-5)!5!} \\ \\
                    & = \frac{1\cdot 2\ldots\cdot 52}{(1\cdot 2\ldots\cdot 47)(1\cdot 2\cdot 3\cdot 4\cdot 5)} \\ \\
                    & = \frac{48\cdot 49\cdot 50\cdot 51\cdot 52}{120} \\ \\
                    & = \frac{311,874,200}{120} \\ \\
                    & = 2,598,960

One fine hand to end with, is *four-of-a-kind,* e.g., four aces, or four sevens, etc. How many ways are there to get such a hand? The hand is build in successive steps, so we can use the multiplication principle in our calculations.

First there is the rank choice. There are 13 ranks in a playing card deck and we chose one. Formally, we can write :math:`{{13}\choose{1}}` but this evaluates to :math:`13!/(12!1!)=13`. The second step involves the suit. There are four suits and our choices are :math:`{{4}\choose{1}}=4`. And finally, we have the last step: the fifth card that can be anything else (except for the rank that we use for the four-of-a-kind). There are :math:`12` such choices. All together, we have :math:`13\cdot 12\cdot 4=624` ways to pull a four-of-a-kind hand.

And so we can write:

.. math::

 \text{Probability of four-of-a-kind} & = \frac{\text{number of ways to pull a four-of-a-kind}}{\text{number of all possible 5-card hands}} \\ \\
   & = \frac{624}{2,598,960} \\ \\
   & \approx 0.024\%
 
 
Let's look at another hand, the single pair: two of the five cards are of the same rank. The successive steps, and their corresponding factors in the multiplication principle, are:


.. math::

   \underbrace{{{13}\choose{1}}}_{\substack{\text{same}\\\text{rank}}}\ 
   \underbrace{{{4}\choose{2}}}_{\substack{\text{two}\\\text{suits}}}\ 
   \underbrace{{{12}\choose{3}}}_{\substack{\text{any}\\\text{three}\\\text{other}\\\text{cards}}}\ 
   \underbrace{{{4}\choose{1}}{{4}\choose{1}}{{4}\choose{1}}}_{\substack{\text{of any suit}\\\text{for each of}\\\text{3 cards}}} &= 
   13\cdot 6\cdot 220\cdot 4^3 \\ &=1,098,240	
   
There are, in other words, 1,098,240 different ways to end with a single pair. And the probability is 

.. math::

 \text{Probability of single pair} & = \frac{\text{number of ways to pull single pair}}{\text{number of all possible 5-card hands}} \\ \\
   & = \frac{1,098,240}{2,598,960} \\ \\
   & \approx 42.26\%
 
 