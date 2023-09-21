package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <E extends Comparable<E>> {
    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree(BinaryTreeNode<E> root){
        this.root=root;
        size++;
    }

    public void setRoot(BinaryTreeNode<E> root)
    {
        this.root=root;
    }
    public BinaryTreeNode<E> getRoot()
    {
        return root;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public int size(){
        return preOrder().size();
    }
    public boolean contains(E element){
        return preOrder().contains(element);
    }
    public  ArrayList<E> inOrder(){
        LinkedList<BinaryTreeNode<E>> stack=new LinkedList<>();
        ArrayList<E> list=new ArrayList<>();
        BinaryTreeNode<E> current=root;
        while(true)
        {
            if(current.getLeftChild()!=null && !(list.contains(current.getLeftChild().getElement())))
            {
                stack.push(current);
                current=current.getLeftChild();
            }
            else
            {
                list.add(current.getElement());
                if(current.getRightChild()!=null)
                {
                    current=current.getRightChild();
                }
                else if(!(stack.isEmpty()))
                {
                    current=stack.pop();
                }
                else
                {
                    break;
                }
            }
        }
        if(list.isEmpty())
        {
            return null;
        }
        return list;
    }
    public ArrayList<E> preOrder(){
        LinkedList<BinaryTreeNode<E>> stack=new LinkedList<>();
        ArrayList<E> list=new ArrayList<>();
        BinaryTreeNode<E> current=root;
        while(true)
        {
            list.add(current.getElement());
            if(current.getLeftChild()!=null)
            {
                if(current.getRightChild()!=null)
                {
                    stack.push(current.getRightChild());
                }
                current=current.getLeftChild();
            }
            else if(current.getLeftChild()==null && current.getRightChild()!=null)
            {
                current=current.getRightChild();
            }
            else if(current.getLeftChild()==null && current.getRightChild()==null && !(stack.isEmpty()))
            {
                current=stack.pop();
            }
            else
            {
                break;
            }
        }
        if(list.isEmpty())
        {
            return null;
        }
        return list;
    }
    public ArrayList<E> postOrder(){
        LinkedList<BinaryTreeNode<E>> stack=new LinkedList<>();
        ArrayList<E> list=new ArrayList<>();
        BinaryTreeNode<E> current=root;
        while(true)
        {
            if(current.getLeftChild()!=null && !(list.contains(current.getLeftChild().getElement())))
            {
                stack.push(current);
                current=current.getLeftChild();
            }
            else if(current.getRightChild()!=null && !(list.contains(current.getRightChild().getElement())))
            {
                stack.push(current);
                current=current.getRightChild();
            }
            else
            {
                list.add(current.getElement());
                if(!(stack.isEmpty()))
                {
                    current=stack.pop();
                }
                else
                {
                    break;
                }
            }
        }
        if(list.isEmpty())
        {
            return null;
        }
        return list;
    }
    public ArrayList<E> levelOrder()
    {
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        ArrayList<E> list=new ArrayList<>();
        BinaryTreeNode<E> current;
        queue.add(root);
        while(!(queue.isEmpty()))
        {
            current=queue.poll();
            list.add(current.getElement());
            if(current.getLeftChild()!=null)
            {
                queue.add(current.getLeftChild());
            }
            if(current.getRightChild()!=null)
            {
                queue.add(current.getRightChild());
            }
        }
        if(list.isEmpty())
        {
            return null;
        }
        return list;
    }
    public int height(BinaryTreeNode<E> root)
    {
        int leftHeigh=0;
        int rightHeight=0;
        BinaryTreeNode<E> current=root;
        if(current==null)
        {
            return -1;
        }
        if(current.getLeftChild()!=null)
        {
            leftHeigh=height(current.getLeftChild());
        }
        if(current.getRightChild()!=null)
        {
            rightHeight=height(current.getRightChild());
        }
        int max=(leftHeigh>rightHeight) ? leftHeigh : rightHeight;
        return (max+1);
    }
}
