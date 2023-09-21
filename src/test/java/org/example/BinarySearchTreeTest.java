package org.example;

import org.example.BinarySearchTree;
import org.example.BinaryTreeNode;
import org.example.BinaryTreePrint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.E;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest <E extends Comparable<E>>{

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
    public void findMinTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        print.printTree(tree.getRoot());
        assertEquals(10, tree.findMin());
    }
    @Test
    public void findMaxTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        print.printTree(tree.getRoot());
        assertEquals(27, tree.findMax());
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


        assertTrue(tree.contains(11));
    }
    @Test
    public void insertTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        print.printTree(tree.getRoot());
        assertTrue(tree.insert(5));
        System.out.println();
        print.printTree(tree.getRoot());
    }
    @Test
    public void removeTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        print.printTree(tree.getRoot());
        assertTrue(tree.remove(25));
        System.out.println();
        print.printTree(tree.getRoot());
    }
    @Test
    public void rebalanceTest()
    {
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);


        print.printTree(tree.getRoot());
        System.out.println();
        tree.rebalance();
        print.printTree(tree.getRoot());
    }
}