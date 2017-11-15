/**
 * 
 */
package com.aditya.LinkedList;

import java.util.Iterator;

/**
 * @author akulkarni4
 * 
 *
 */
public class LinkedList<T> implements Iterator<T> {

	private Node<T> pointer;
	private long size;

	public LinkedList() {
		// TODO Auto-generated constructor stub
		size = 0;
	}

	public void add(T t) {
		if (pointer == null) {
			pointer = new Node<T>();
			pointer.setElement(t);
			++size;
		} else {
			Node<T> n = new Node<T>();
			n.setElement(t);
			n.setNextNode(pointer);
			pointer.setPreviousNode(n);
			pointer = n;
			++size;
		}
	}

	public T getFirst() {
		if(pointer != null) {
			T element = pointer.getElement();
			pointer = pointer.getNextNode();
			return element;
		}
		return null;
	}
	
	/**
	 * Complexity O(N)
	 * @return
	 */
	public T getLast(){
		Node<T> last = pointer;
		while (last.getNextNode() != null) {
			last = last.getNextNode();
		}
		if(last.getPreviousNode() == null) {
			pointer = null;
			return last.getElement();
		}
		T element = last.getElement();
		last.getPreviousNode().setNextNode(null);
		return element;
	}

	public T remove(long index) {
		Node<T> n = pointer;
		if (n == null) {
			return null;
		}
		for (int i = 1; i <= index; i++) {
			if (n == null) {
				return null;
			}
			n = n.getNextNode();
		}
		T t = n.getElement();
		if (n != pointer) {
			n.getPreviousNode().setNextNode(null);
		} else {
			if(pointer.getNextNode() != null){
				pointer = pointer.getNextNode();
			} else {
				pointer = null;
			}
		}
		--size;
		return t;
	}

	public T get(long index) {
		Node<T> n = pointer;
		for (int i = 1; i <= index; i++) {
			if (n == null) {
				return null;
			}
			n = n.getNextNode();
		}
		return n.getElement();
	}

	public T removeLastAdded() throws NullPointerException {
		T t = pointer.getElement();
		if (pointer.getNextNode() != null) {
			pointer = pointer.getNextNode();
		} else {
			pointer = null;
		}
		return t;
	}
	
	public boolean removeAll(){
		pointer = null;
		size = 0;
		return true;
	}
	
	public boolean isEmpty(){
		if(pointer != null){
			return false;
		} else {
			return true;
		}
	}

	public Node<T> getPointer() {
		return pointer;
	}

	public void setPointer(Node<T> pointer) {
		this.pointer = pointer;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(size > 0){
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
