package com.maa.app.pilha;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.maa.app.pilha.exception.EmptyStackException;

class StackTest {
	
	private Stack stack;
	
	@BeforeEach
	void initializeStack() {
		stack = new Stack(10);
	}

	@Test
	void emptyStack() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	
	@Test
	void stackElement() {
		stack.stackUp("First");
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("First", stack.top());
	}
	
	@Test
	void stackUnstackElement() {
		stack.stackUp("First");
		stack.stackUp("Second");
		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
		assertEquals("Second", stack.top());
		Object unstack = stack.unstack();
		assertEquals(1, stack.size());
		assertEquals("First", stack.top());
		assertEquals("Second", unstack);
	}
	
	@Test
	void removeFromStack() {
		Assertions.assertThrows(EmptyStackException.class, () -> {
			stack.unstack();
	    });
	}
	
	
	@Test
	void addToFullStack() {
		Assertions.assertThrows(FullStackException.class, () -> {
			stack.unstack();
	    });
	}
	

}
