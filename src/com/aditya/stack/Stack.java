/**
 * 
 */
package com.aditya.stack;

import java.util.ArrayList;

/**
 * @author Aditya Kulkarni
 * This is Stack implemented with ArrayList.
 */
public class Stack <T>{
	private ArrayList<T> arr;

	/**
	 * Constructor of the Stack class.
	 */
	public Stack() {
		super();
		arr = new ArrayList<>();
	}
	
	/**
	 * Push operation of the  Stack.
	 * @param Object of class T to be pushed in T.
	 */
	public void push(T a){
		arr.add(a);
	}
	
	/**
	 * Pop the top most element in Stack.
	 * @return
	 */
	public T pop(){
		int size = arr.size();
		return arr.remove(size-1);
	}
	
	/**
	 * Returns without removing the top element.
	 * @return
	 */
	public T peek(){
		return arr.get(arr.size()-1);
	}
	
	public long size(){
		return arr.size();
	}
	
	
}
