package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest <E extends Comparable<E>>{
    private BinaryTreeNode node1=new BinaryTreeNode(15);
    private BinaryTreeNode node2=new BinaryTreeNode(10);
    private BinaryTreeNode node3=new BinaryTreeNode(25);
    private BinaryTreeNode node4=new BinaryTreeNode(12);
    private BinaryTreeNode node5=new BinaryTreeNode(20);
    private BinaryTreeNode node6=new BinaryTreeNode(27);
    private BinaryTreeNode node7=new BinaryTreeNode(11);
    private BinaryTreeNode node9=new BinaryTreeNode(19);
    private BinaryTreeNode node10=new BinaryTreeNode(22);
    private BinarySearchTree tree=new BinarySearchTree(node1);
    private BinaryTreePrint print=new BinaryTreePrint();

    @Test
    public void sizeTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        assertEquals(9, tree.size());
    }
    @Test
    public void containsTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        assertTrue(tree.contains(25));
    }
    @Test
    public void traversalTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        System.out.println(tree.inOrder());
        System.out.println(tree.preOrder());
        System.out.println(tree.postOrder());
        System.out.println(tree.levelOrder());

        //sry this was 5min before deadline xd
        print.printTree(tree.getRoot());
    }
    @Test
    public void heightTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);

        assertEquals(4, tree.height(tree.getRoot()));
    }
}