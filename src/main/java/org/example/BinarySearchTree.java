package org.example;

import java.util.ArrayList;

public class BinarySearchTree <E extends Comparable<E>> extends BinaryTree<E>{
    public BinarySearchTree(BinaryTreeNode<E> root) {
        super(root);
    }
    public E findMin()
    {
        ArrayList<E> list=inOrder();
        return list.get(0);
    }
    public E findMax()
    {
        ArrayList<E> list=inOrder();
        return list.get(list.size()-1);
    }
    public boolean contains(E element)
    {
        return super.contains(element);
    }
    public boolean insert(E element)
    {
        BinaryTreeNode<E> toInsert=new BinaryTreeNode<>(element);
        BinaryTreeNode<E> current=getRoot();
        while(true)
        {
            if(toInsert.getElement().compareTo(current.getElement())>0 && current.getRightChild()==null)
            {
                current.addRightChild(toInsert);
                return true;
            }
            else if(toInsert.getElement().compareTo(current.getElement())>0 && current.getRightChild()!=null)
            {
                current=current.getRightChild();
            }
            else if(toInsert.getElement().compareTo(current.getElement())<0 && current.getLeftChild()==null)
            {
                current.addLeftChild(toInsert);
                return true;
            }
            else if(toInsert.getElement().compareTo(current.getElement())<0 && current.getLeftChild()!=null)
            {
                current=current.getLeftChild();
            }
            else
                return false;
        }
    }
    public boolean remove(E toRemove)
    {
        BinaryTreeNode<E> current=getRoot();
        BinaryTreeNode<E> parent=null;
        String whichChild = null;   //for checking what type child the deleting node is
        while(current.getElement().compareTo(toRemove)!=0)
        {
            if(current.getElement().compareTo(toRemove)<0)
            {
                parent=current;
                current=current.getRightChild();
                whichChild="Right";
            }
            else if(current.getElement().compareTo(toRemove)>0)
            {
                parent=current;
                current=current.getLeftChild();
                whichChild="Left";
            }
            else
                break;
        }
        if(current.getLeftChild()==null && current.getRightChild()==null)
        {
            switch(whichChild)
            {
                case "Left":
                    parent.addLeftChild(null);
                    return true;
                case "Right":
                    parent.addRightChild(null);
                    return true;
                default:
                    return false;
            }
        }
        else if(current.getLeftChild()!=null && current.getRightChild()==null)
        {
            switch(whichChild)
            {
                case "Left":
                    parent.addLeftChild(current.getLeftChild());
                    return true;
                case "Right":
                    parent.addRightChild(current.getLeftChild());
                    return true;
                default:
                    return false;
            }
        }
        else if(current.getLeftChild()==null && current.getRightChild()!=null)
        {
            switch(whichChild)
            {
                case "Left":
                    parent.addLeftChild(current.getRightChild());
                    return true;
                case "Right":
                    parent.addRightChild(current.getRightChild());
                    return true;
                default:
                    return false;
            }
        }
        else if(current.getLeftChild()!=null && current.getRightChild()!=null)
        {
            switch(whichChild)
            {
                case "Left":
                    parent.addLeftChild(current.getRightChild());
                    findMinValue(current.getRightChild()).addLeftChild(current.getLeftChild());
                    return true;
                case "Right":
                    parent.addRightChild(current.getLeftChild());
                    findMaxValue(current.getLeftChild()).addRightChild(current.getRightChild());
                    return true;
                default:
                    return false;
            }
        }
        else
            return false;
    }
    public BinaryTreeNode<E> findMinValue(BinaryTreeNode<E> deletingNodeRoot)
    {
        BinaryTreeNode<E> current=deletingNodeRoot;
        while(current.getLeftChild()!=null)
        {
            current=current.getLeftChild();
        }
        return current;
    }
    public BinaryTreeNode<E> findMaxValue(BinaryTreeNode<E> deletingNodeRoot)
    {
        BinaryTreeNode<E> current=deletingNodeRoot;
        while(current.getRightChild()!=null)
        {
            current=current.getRightChild();
        }
        return current;
    }
    public void rebalance()
    {
        if(getRoot()==null || size()<2)
            return;
        ArrayList<E> list=inOrder();
        int middleID=list.size()/2;
        setRoot(new BinaryTreeNode<>(list.get(middleID)));
        rebalanceHelper(list, 0, middleID-1, getRoot());
        rebalanceHelper(list, middleID+1, list.size()-1, getRoot());
    }
    public void rebalanceHelper(ArrayList<E> elements, int start, int end, BinaryTreeNode<E> parent)
    {
        if(start>end)
            return;
        int middle=(start+end)/2;
        BinaryTreeNode<E> child=new BinaryTreeNode<>(elements.get(middle));
        if(parent.getElement().compareTo(child.getElement())>0)
        {
            parent.addLeftChild(child);
        }
        else
        {
            parent.addRightChild(child);
        }
        rebalanceHelper(elements, start, middle-1, child);
        rebalanceHelper(elements, middle+1, end, child);
    }
}
