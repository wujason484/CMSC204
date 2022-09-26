/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Generic stack class
 * Due: 10/6/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	
	private int stackSize;
	private ArrayList<T> stackList;
	
	public MyStack(int stackSize) {
		this.stackSize=stackSize;
		stackList=new ArrayList<T>(stackSize);
	}
	
	public MyStack() {
		stackSize=0;
		stackList=new ArrayList<T>();
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if(stackList.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if(stackList.size()==stackSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException{
		T top;
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			top=stackList.get(stackList.size()-1);
			stackList.remove(stackList.size()-1);
			return top;
		}
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException{
		T top;
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			top=stackList.get(stackList.size()-1);
			return top;
		}
	}
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stackList.size();
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException{
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
			stackList.add(e);
			return true;
		}
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String s="";
		
		for(T i:stackList) {
			s+=i;
		}
		
		return s;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String s="";
		
		for(T i:stackList) {
			s+=i+delimiter;
		}
		
		return s;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy=new ArrayList<T>(list.size());
		
		for(T i:list) {
			listCopy.add(i);
		}
		
		stackList.clear();
		
		for(T i:listCopy) {
			stackList.add(i);
		}
	}

}
