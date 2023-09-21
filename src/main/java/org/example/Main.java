package org.example;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode node1=new BinaryTreeNode(15);
        BinaryTreeNode node2=new BinaryTreeNode(10);
        BinaryTreeNode node3=new BinaryTreeNode(25);
        BinaryTreeNode node4=new BinaryTreeNode(12);
        BinaryTreeNode node5=new BinaryTreeNode(20);
        BinaryTreeNode node6=new BinaryTreeNode(27);
        BinaryTreeNode node7=new BinaryTreeNode(11);
        BinaryTreeNode node9=new BinaryTreeNode(19);
        BinaryTreeNode node10=new BinaryTreeNode(22);

        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addRightChild(node4);
        node3.addLeftChild(node5);
        node3.addRightChild(node6);
        node4.addLeftChild(node7);
        node5.addLeftChild(node9);
        node5.addRightChild(node10);

        BinarySearchTree tree=new BinarySearchTree(node1);
        System.out.println("In-order traversal: "+tree.inOrder());
        System.out.println("Pre-order traversal: "+tree.preOrder());
        System.out.println("Post-order traversal: "+tree.postOrder());
        System.out.println("Level-order traversal: "+tree.levelOrder());
        System.out.println("Contains 11? - "+tree.contains(11));
        System.out.println("Size: "+tree.size());
        System.out.println("Height: "+tree.height(tree.getRoot()));

        BinaryTreePrint print=new BinaryTreePrint();
        print.printTree(node1);
    }
}