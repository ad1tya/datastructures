/**
 * 
 */
package com.aditya.queue;

import com.aditya.LinkedList.LinkedList;
import com.aditya.exceptions.QueueUnderFlowException;

/**
 * @author Aditya Kulkarni
 *
 */
public class LinkedListQueue<T> {
	private LinkedList<T> list;
	public LinkedListQueue() {
		// TODO Auto-generated constructor stub
		list = new LinkedList<>();
	}
	
	public long getSize() {
		return list.getSize();
	}
	
	public boolean enqueue(T element) {
		list.add(element);
		return true;
	}
	
	public T dequeue() throws QueueUnderFlowException {
		if(isEmpty()) throw new QueueUnderFlowException("Dequeue attempted on empty queue");
		return list.getLast();
	}
	
	public T peek() {
		return list.getPointer().getElement();
	}
	public boolean isFull() { return false;}
	public boolean isEmpty() {return list.isEmpty();}
}
