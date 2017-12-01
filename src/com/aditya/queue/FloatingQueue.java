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
public class FloatingQueue<T> {
	private int indexLast;
	private int indexFirst;
	private Object elements[];
	private static final int DEF_SIZE = 3;
	private int size;

	public FloatingQueue() {
		// TODO Auto-generated constructor stub
		indexLast = indexFirst = -1;
		size = 0;
		elements = new Object[DEF_SIZE];
	}

	public FloatingQueue(int size) {
		indexLast = indexFirst = -1;
		size = 0;
		elements = new Object[size];
	}

	public void enqueue(T t) throws QueueOverFlowException {
		if (indexLast == -1) {
			elements[0] = t;
			indexFirst = indexLast = 0;
			++size;
		} else if (isFull()) {
			throw new QueueOverFlowException("Queue index out of bound exception");
		} else {
			++size;
			indexLast = (indexLast + 1) % elements.length;
			elements[indexLast] = t;
		}
	}

	@SuppressWarnings("unchecked")
	public T dequeue() throws QueueUnderFlowException {
		if (isEmpty()) {
			throw new QueueUnderFlowException("Dequeue attempted on empty Queue");
		} else {
			--size;
			T element = (T) elements[indexFirst];
			indexFirst = (indexFirst+1) % elements.length;
			return element;
		}
	}

	public boolean isEmpty() {return (size <= 0) ? true : false;}
	
	public boolean isFull() {return (size >= elements.length) ? true : false;}

	@Override
	public String toString() {
		return "FixedQueue [indexLast=" + indexLast + ", indexFirst=" + indexFirst + ", elements="
				+ Arrays.toString(elements) + ", size=" + size + "]";
	}
}
