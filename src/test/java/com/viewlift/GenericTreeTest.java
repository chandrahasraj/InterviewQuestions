package com.viewlift;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.viewlift.interview.tree.Node;
import com.viewlift.interview.tree.Tree;

public class GenericTreeTest {

	Node<Integer> root;
	Tree<Integer> tree;
	ArrayList<Node<Integer>> list, list2, list3, list4, list5, postorder,
			preorder;

	@Test
	public void testNodeAndTree() {
		Assert.assertNull(tree);
		Assert.assertNull(root);
	}

	@Test
	public void testNumberOfDescendants() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		tree = new Tree<>(root);
		Assert.assertEquals(tree.getNumberOfDescendants(root), 8);
		Assert.assertEquals(tree.getNumberOfDescendants(root.getChildAt(0)), 2);
		Assert.assertNotEquals(
				tree.getNumberOfDescendants(root.getChildAt(0).getParent()), 2);
	}

	@Test
	public void testLongestPath() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		tree = new Tree<>(root);

		list = new ArrayList<Node<Integer>>();
		list.add(new Node<Integer>(1));
		list.add(new Node<Integer>(2));
		list.add(new Node<Integer>(6));

		Assert.assertEquals(tree.getLongestPathFromRootToAnyLeaf(), list);
	}

	@Test
	public void testPaths() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		list = new ArrayList<Node<Integer>>();
		list.add(new Node<Integer>(1));
		list.add(new Node<Integer>(2));
		list.add(new Node<Integer>(6));

		list2 = new ArrayList<Node<Integer>>();
		list2.add(new Node<Integer>(1));
		list2.add(new Node<Integer>(2));
		list2.add(new Node<Integer>(10));

		list3 = new ArrayList<Node<Integer>>();
		list3.add(new Node<Integer>(1));
		list3.add(new Node<Integer>(3));
		list3.add(new Node<Integer>(9));

		list4 = new ArrayList<Node<Integer>>();
		list4.add(new Node<Integer>(1));
		list4.add(new Node<Integer>(4));
		list4.add(new Node<Integer>(8));

		list5 = new ArrayList<Node<Integer>>();
		list5.add(new Node<Integer>(1));
		list5.add(new Node<Integer>(5));

		tree = new Tree<>(root);
		ArrayList<ArrayList<Node<Integer>>> li = new ArrayList<>();
		li.add(list);
		li.add(list2);
		li.add(list3);
		li.add(list4);
		li.add(list5);
		Assert.assertEquals(tree.getPathsFromRootToAnyLeaf(), li);
	}

	@Test
	public void testOrder() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		tree = new Tree<>(root);
		postorder = new ArrayList<Node<Integer>>();
		postorder.add(new Node<Integer>(6));
		postorder.add(new Node<Integer>(10));
		postorder.add(new Node<Integer>(2));
		postorder.add(new Node<Integer>(9));
		postorder.add(new Node<Integer>(3));
		postorder.add(new Node<Integer>(8));
		postorder.add(new Node<Integer>(4));
		postorder.add(new Node<Integer>(5));
		postorder.add(new Node<Integer>(1));

		preorder = new ArrayList<Node<Integer>>();
		preorder.add(new Node<Integer>(1));
		preorder.add(new Node<Integer>(2));
		preorder.add(new Node<Integer>(6));
		preorder.add(new Node<Integer>(10));
		preorder.add(new Node<Integer>(3));
		preorder.add(new Node<Integer>(9));
		preorder.add(new Node<Integer>(4));
		preorder.add(new Node<Integer>(8));
		preorder.add(new Node<Integer>(5));
		Assert.assertEquals(tree.getPostOrderTraversal(), postorder);
		Assert.assertEquals(tree.getPreOrderTraversal(), preorder);
	}

	@Test
	public void testOrderAfterAddition() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		tree = new Tree<>(root);
		postorder = new ArrayList<Node<Integer>>();
		postorder.add(new Node<Integer>(6));
		postorder.add(new Node<Integer>(10));
		postorder.add(new Node<Integer>(2));
		postorder.add(new Node<Integer>(9));
		postorder.add(new Node<Integer>(3));
		postorder.add(new Node<Integer>(8));
		postorder.add(new Node<Integer>(4));
		postorder.add(new Node<Integer>(5));
		postorder.add(new Node<Integer>(1));

		preorder = new ArrayList<Node<Integer>>();
		preorder.add(new Node<Integer>(1));
		preorder.add(new Node<Integer>(2));
		preorder.add(new Node<Integer>(6));
		preorder.add(new Node<Integer>(10));
		preorder.add(new Node<Integer>(3));
		preorder.add(new Node<Integer>(9));
		preorder.add(new Node<Integer>(4));
		preorder.add(new Node<Integer>(8));
		preorder.add(new Node<Integer>(5));
		root.addChildAt(0, new Node<Integer>(root.getChildAt(2).getParent()
				.getData()));
		root.getChildAt(0).addChild(
				new Node<Integer>(root.getChildAt(2).getParent().getChildAt(3)
						.getData()));
		tree = new Tree<Integer>(root);

		postorder.add(0, new Node<Integer>(4));
		postorder.add(1, new Node<Integer>(1));

		Assert.assertEquals(tree.getPostOrderTraversal(), postorder);

		preorder.add(1, new Node<Integer>(1));
		preorder.add(2, new Node<Integer>(4));
		Assert.assertEquals(tree.getPreOrderTraversal(), preorder);
	}

	@Test
	public void testOrderAfterDeletion() {
		root = new Node<Integer>(1);
		root.addChild(new Node<Integer>(2));
		root.addChild(new Node<Integer>(3));
		root.addChild(new Node<Integer>(4));
		root.addChild(new Node<Integer>(5));

		root.getChildAt(0).addChild(new Node<Integer>(6));
		root.getChildAt(1).addChild(new Node<Integer>(9));
		root.getChildAt(2).addChild(new Node<Integer>(8));
		root.getChildAt(0).addChild(new Node<Integer>(10));

		tree = new Tree<>(root);
		postorder = new ArrayList<Node<Integer>>();
		postorder.add(new Node<Integer>(6));
		postorder.add(new Node<Integer>(10));
		postorder.add(new Node<Integer>(2));
		postorder.add(new Node<Integer>(9));
		postorder.add(new Node<Integer>(3));
		postorder.add(new Node<Integer>(8));
		postorder.add(new Node<Integer>(4));
		postorder.add(new Node<Integer>(5));
		postorder.add(new Node<Integer>(1));

		preorder = new ArrayList<Node<Integer>>();
		preorder.add(new Node<Integer>(1));
		preorder.add(new Node<Integer>(2));
		preorder.add(new Node<Integer>(6));
		preorder.add(new Node<Integer>(10));
		preorder.add(new Node<Integer>(3));
		preorder.add(new Node<Integer>(9));
		preorder.add(new Node<Integer>(4));
		preorder.add(new Node<Integer>(8));
		preorder.add(new Node<Integer>(5));
		root.removeChildAt(0);
		root.getChildAt(0).removeChild(
				new Node<Integer>(root.getChildAt(2).getParent().getChildAt(0)
						.getData()));
		tree = new Tree<Integer>(root);

		postorder.remove(2);
		postorder.remove(1);
		postorder.remove(0);

		Assert.assertEquals(tree.getPostOrderTraversal(), postorder);

		preorder.remove(3);
		preorder.remove(2);
		preorder.remove(1);
		Assert.assertEquals(tree.getPreOrderTraversal(), preorder);
	}
}
