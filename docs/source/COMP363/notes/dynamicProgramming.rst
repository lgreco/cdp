:orphan:

Dynamic Programming
------------------------------------------------------------

Dynamic Programming is often presented as a challenging mathematical formulation. Because of its mathematical abstraction, it can be off putting. And yet it's an awesome and very useful algorithmic strategy, worth exploring and appreciating.

Consider a collection (a set, if you like) of  𝑛  items. Each item has a value  𝑣𝑖  and a weight  𝑤𝑖 . Here,  1≤𝑖≤𝑛 . The contrived example used in most textbooks, is the collection of artifacts in a museum. Is there a combination of some museum items whose total weight does not exceed a limit and their total value is the most of any such combination we could think of?

Of course, no one writes algorithms because they want to plan a museum heist. The problem exemplified above, in terms of questionable morality, belongs to a broader group of optimization problems under constraints. In the case of the museum heist, we try to optimize the value of what we can take within the weight limit of what we can carry.

Without a weight limit, we can take everything. But when we impose a weight limit,  𝐿 , we must consider only the combination of items that maximize value while complying with the limit condition.