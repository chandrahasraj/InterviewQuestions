package com.viewlift.interview.tree;

import java.util.ArrayList;

/**
 * Implement Generic n-ary tree. Basic Methods are provided, implement which are not provided.
 *
 * @param <T> Any class type
 */
public class Tree<T> {

    private Node<T> root;

    /**
     * Initialize a tree with the specified root node.
     *
     * @param root The root node of the tree
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * Checks if the tree is empty (root node is null)
     *
     * @return <code>true</code> if the tree is empty,
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Get the root node of the tree
     *
     * @return the root node.
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Set the root node of the tree. Replaces existing root node.
     *
     * @param root The root node to replace the existing root node with.
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     *
     * Check if given data is present in the tree.
     *
     * @param key The data to search for
     * @return <code>true</code> if the given key was found in the tree,
     * <code>false</code> otherwise.
     */
    public boolean exists(T key) {
        return find(root, key);
    }

    /**
     * Get the number of nodes (size) in the tree.
     *
     * @return The number of nodes in the tree
     */
    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    /**
     *
     * Get the number of descendants a given node has.
     *
     * @param node The node whose number of descendants is needed.
     * @return the number of descendants
     */
    public int getNumberOfDescendants(Node<T> node) {

    	return 0;
    }

    /**
     * find if the node has the keyNode and return true if it has
     * @param node
     * @param keyNode
     * @return
     */
    private boolean find(Node<T> node, T keyNode) {
        boolean res = false;

        return res;
    }

    /**
     * return the found node with key=keyNode else null
     * @param node
     * @param keyNode
     * @return
     */
    private Node<T> findNode(Node<T> node, T keyNode) {

        return null;
    }

    /**
     *
     * Get the list of nodes arranged by the pre-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the pre-order
     */
    public ArrayList<Node<T>> getPreOrderTraversal() {
        ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
        buildPreOrder(root, preOrder);
        return preOrder;
    }

    /**
     *
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<Node<T>> getPostOrderTraversal() {
        ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
        buildPostOrder(root, postOrder);
        return postOrder;
    }

    private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {

    }

    private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {

    }

    /**
     *
     * Get the list of nodes in the longest path from root to any leaf in the tree.
     *
     * For example, for the below tree
     * <pre>
     *          A
     *         / \
     *        B   C
     *           / \
     *          D  E
     *              \
     *              F
     * </pre>
     *
     * The result would be [A, C, E, F]
     *
     * @return The list of nodes in the longest path.
     */
    public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
        ArrayList<Node<T>> longestPath = null;
    
        return longestPath;
    }


    /**
     *
     * Get the height of the tree (the number of nodes in the longest path from root to a leaf)
     *
     * @return The height of the tree.
     */
    public int getHeight() {
        return getLongestPathFromRootToAnyLeaf().size();
    }

    /**
     *
     * Get a list of all the paths (which is again a list of nodes along a path) from the root node to every leaf.
     *
     * @return List of paths.
     */
    public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
        ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
        ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
        getPath(root, currentPath, paths);

        return paths;
    }

    /**
     * get the path from node to leaf of all the nodes and add it to paths. 
     * @param node
     * @param currentPath
     * @param paths
     */
    private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
                         ArrayList<ArrayList<Node<T>>> paths) {
        
    }

    private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
        ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
        for (Node<T> node : list)
            newList.add(new Node<T>(node));

        return newList;
    }
}