package com.datastructures.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 22/11/23
 */
public class ThreeInOne {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public ThreeInOne(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize + numberOfStacks];
		sizes =  new int[numberOfStacks];
	}

	// isFull
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	// isEmpty
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	// indexOfTop - this is helper method for push, pop and peek methods

	private int indexOfTop(int stackNum) {
		int offSet = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return -1;
	}

	// push
	public void push(int stackNum, int value) {
		// TODO

	}

	// pop
	public int pop(int stackNum) {
		// TODO
		return -1;
	}

	// peek

	public int peek(int stackNum) {
		// TODO
		return -1;
	}

}

