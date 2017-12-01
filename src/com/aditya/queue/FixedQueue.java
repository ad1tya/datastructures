/**
 * 
 */
package com.aditya.queue;

import java.util.Arrays;

import com.aditya.exceptions.QueueOverFlowException;
import com.aditya.exceptions.QueueUnderFlowException;

/**
 * @author Aditya Kulkarni
 *
 */
public class FixedQueue<T> {
	Object elements[];
	private final int DEF_SIZE = 3;
	private int index = -1;
	private int size = 0;

	public FixedQueue() {
		// TODO Auto-generated constructor stub
		elements = new Object[DEF_SIZE];
	}

	public FixedQueue(int size) {
		elements = new Object[size];
	}

	public int getSize() {
		return size;
	}

	public boolean enqueue(T element) throws QueueOverFlowException {
		if (isFull()) {
			throw new QueueOverFlowException("Queue index overflow.");
		} else {
			elements[++index] = element;
			++size;
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public T dequeue() throws QueueUnderFlowException {
		if (isEmpty()) {
			throw new QueueUnderFlowException("Queue us empty");
		} else {
			--size;
			T element = (T) elements[0];
			for (int i = 0; i < index; i++) {
				elements[i] = elements[i + 1];
			}
			--index;
			return element;
		}
	}
	
	public boolean isEmpty() {return (size <= 0) ? true : false;}
	
	public boolean isFull() {return (size >= elements.length) ? true : false;}

	@Override
	public String toString() {
		return "FloatingQueue [elements=" + Arrays.toString(elements) + "]";
	}
}
