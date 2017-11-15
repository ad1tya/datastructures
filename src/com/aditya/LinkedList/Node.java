/**
 * 
 */
package com.aditya.LinkedList;

/**
 * @author akulkarni4
 *
 */
public class Node<T> {
	private Node<T> nextNode;
	private Node<T> previousNode;
	private T element;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	

	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}
}
