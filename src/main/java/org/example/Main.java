package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        BinaryTreePrint print = new BinaryTreePrint();
        while(true)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Create a binary tree");
            System.out.println("2. Exit");
            int choice=keyboard.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the root node");
                    int root=keyboard.nextInt();
                    BinaryTreeNode<Integer> rootNode=new BinaryTreeNode<>(root);
                    BinarySearchTree<Integer> tree=new BinarySearchTree<>(rootNode);
                    while(true)
                    {
                        System.out.println("");
                        print.printTree(rootNode);
                        System.out.println("");
                        System.out.println("Choose an option:");
                        System.out.println("1. Add a node");
                        System.out.println("2. Remove a node");
                        System.out.println("3. Search for a node");
                        System.out.println("4. Height of the tree");
                        System.out.println("5. Size of the tree");
                        System.out.println("6. Traversal");
                        System.out.println("7. Rebalance");
                        System.out.println("8. Exit");
                        int choice2=keyboard.nextInt();
                        switch (choice2)
                        {
                            case 1:
                                System.out.println("Enter the value of the node");
                                int value=keyboard.nextInt();
                                Boolean status=tree.insert(value);
                                break;
                            case 2:
                                System.out.println("Enter the value of the node");
                                int value2=keyboard.nextInt();
                                tree.remove(value2);
                                break;
                            case 3:
                                System.out.println("Enter the value of the node");
                                int value3=keyboard.nextInt();
                                if(tree.contains(value3))
                                    System.out.println("Node found");
                                else
                                    System.out.println("Node not found");
                                break;
                            case 4:
                                System.out.println("Height of the tree is "+tree.height(rootNode));
                                break;
                            case 5:
                                System.out.println("Size of the tree is "+tree.size());
                                break;
                            case 6:
                                System.out.println("Choose an option:");
                                System.out.println("1. Preorder");
                                System.out.println("2. Inorder");
                                System.out.println("3. Postorder");
                                System.out.println("4. Levelorder");
                                int choice3=keyboard.nextInt();
                                switch(choice3)
                                {
                                    case 1:
                                        System.out.println(tree.preOrder());
                                        break;
                                    case 2:
                                        System.out.println(tree.inOrder());
                                        break;
                                    case 3:
                                        System.out.println(tree.postOrder());
                                        break;
                                    case 4:
                                        System.out.println(tree.levelOrder());
                                        break;
                                }
                                break;
                            case 7:
                                tree.rebalance();
                                break;
                            case 8:
                                System.exit(0);
                        }
                    }
                case 2:
                    System.exit(0);
            }
        }
    }
}
