package org.example;

public class BinaryTreeNode<E>{
    private E element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(E element)
    {
        this.element=element;
    }

    public void setElement(E element)
    {
        this.element=element;
    }
    public E getElement()
    {
        return element;
    }

    public void addLeftChild(BinaryTreeNode node)
    {
        this.leftChild=node;
    }
    public void addRightChild(BinaryTreeNode node)
    {
        this.rightChild=node;
    }
    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }
}
