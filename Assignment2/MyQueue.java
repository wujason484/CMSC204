/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Generic queue class
 * Due: 10/6/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private int queueSize;
	private ArrayList<T> queueList;
	
	public MyQueue(int queueSize) {
		this.queueSize=queueSize;
		queueList=new ArrayList<T>(queueSize);
	}
	
	public MyQueue() {
		queueSize=0;
		queueList=new ArrayList<T>();
	}
	
	/**
	 * Checks if queue is empty
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		if(queueList.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if the Queue is full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		if(queueList.size()==queueSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException{
		T first;
		
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
			first=queueList.get(0);
			queueList.remove(0);
			return first;
		}
	}
	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return queueList.size();
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			queueList.add(e);
			return true;
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String s="";
		
		for(T i:queueList) {
			s+=i;
		}
		
		return s;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String s="";
		
		for(T i:queueList) {
			s+=i+delimiter;
		}
		
		return s;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy=new ArrayList<T>(list.size());
		
		for(T i:list) {
			listCopy.add(i);
		}
		
		queueList.clear();
		
		for(T i:listCopy) {
			queueList.add(i);
		}
	}

}
