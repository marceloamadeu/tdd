package com.maa.app.pilha;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	@Test(expected=EmptyStackException.class )
	void removeFromStack() {
		stack.unstack();
	}
	

}
