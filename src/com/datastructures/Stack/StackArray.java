package com.datastructures.Stack;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/11/23
 */
public class StackArray {
	int[] arr;
	int topOfStack;

	public StackArray(int size){
		this.arr =  new int[size];
		this.topOfStack = -1;
		System.out.println("This Stack is created with SIZE " + size);
	}

	public static void main(String[] args) {
		StackArray stackArray = new StackArray(3);

		stackArray.push(1);
		stackArray.push(3);
		stackArray.push(4);

		System.out.println(stackArray.pop());
		System.out.println(stackArray.pop());
		System.out.println(Arrays.toString(stackArray.arr));

		//
//		System.out.println(stackArray.peek());
//
//		stackArray.deleteStack();
//
//		System.out.println(stackArray.isEmpty());
//		System.out.println(stackArray.isFull());

		System.out.println(Arrays.toString(stackArray.arr));
	}

	public boolean isEmpty(){
		return topOfStack == -1;
	}

	public boolean isFull(){
		if(topOfStack == arr.length-1){
			System.out.println("This Stack is full");
			return true;
		}
		return false;
	}

	public void push(int val){
		if(isFull()){
			System.out.println("This stack is full");
		}else {
			arr[topOfStack + 1] = val;
			topOfStack++;
			System.out.println("Value is successfully inserted");
		}
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("This stack is empty");
			return -1;
		}else {
			int topStack = arr[topOfStack];
			topOfStack--;
			return topStack;
		}
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("This stack is empty");
			return -1;
		}
		return arr[topOfStack];
	}

	public void deleteStack(){
		arr = null;
		System.out.println("Stack is sucessfully deleted");
	}
}
