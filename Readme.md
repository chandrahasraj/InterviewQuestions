------------Interview----------

Write code for unimplemented methods. Run the test cases in com.viewlift package of src/test/java folder.

--------ReadWriteLock-------
This program should perform a basic read write lock mechanism. 
Consider there is a resource which can be read by any thread any number of times.
But if the resource is blocked for writing all the threads which want to read or write have to wait.
Every time a lockread is granted increase the count of readers and every time a lockwrite is granted increase writers count.
Reduce the reader and writers count on unlock. Increase the writerequests count if the resource is blocked for writing.


-------Tree--------
Implement Generic n-ary tree. Basic Methods are provided, implement which are not provided.
The tree structure should be as follows.

                    root
                   / / \ \
                  A B  C  D
                //\
               E F G ...
               
 Each node can have any number of children. The basic node structure is provided. Implement functionalities like finding a node in the tree, checking if the node exists in tree, getting pre-order and post-order traversal, getting path from root to child, getting all the paths from root to child.