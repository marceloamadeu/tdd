package com.maa.app.pilha;

import java.util.EmptyStackException;

public class Stack {
	
	private Object[] elements;
	private int amount = 0;

	public Stack(int max) {
		elements = new Object[max];
	}

	public boolean isEmpty() {
		return amount == 0;
	}

	public int size() {
		return amount;
	}

	public void stackUp(Object element) {
		this.elements[amount] = element;
		amount++;
	}

	public Object top() {
		return elements[amount - 1];
	}

	public Object unstack() {
		if (isEmpty())
			throw new EmptyStackException("Unable to unstack");
			
		Object top = top();
		amount--;		
		return top;
	}

}
