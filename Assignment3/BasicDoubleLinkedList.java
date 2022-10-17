/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Generic queue class
 * Due: 10/25/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int listSize;
	
	public BasicDoubleLinkedList() {
		head=null;
		tail=null;
		listSize=0;
	}
	
	/**
	 * Gets number of nodes in list
	 * @return list size
	 */
	public int getSize() {
		return listSize;
	}
	
	/**
	 * Checks if list is empty
	 * @return true if list is empty
	 */
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds a node to the end of the list
	 * @param data
	 */
	public void addToEnd(T data) {
		Node<T> newNode=new Node<T>(data);
		
		if (isEmpty()) {
			head=newNode;
			tail=newNode;
		} 
		else {
			tail.next=newNode;
			tail=newNode;
		}
		listSize++;
	}
	
	/**
	 * Adds a node to the front of the list
	 * @param data
	 */
	public void addToFront(T data) {
		Node<T> newNode=new Node<T>(data);
		
		if (isEmpty()) {
			head=newNode;
			tail=newNode;
		} 
		else {
			head.prev=newNode;
			head=newNode;
		}
		listSize++;
	}
	
	/**
	 * Gets the first node in the list without removing
	 * @return first node
	 */
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		else {
			return head.data;
		}
	}
	
	/**
	 * Gets the last node in the list without removing
	 * @return last node
	 */
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		else {
			return tail.data;
		}
	}
	
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator<T>();
	}
	
	/**
	 * removes a targeted data from the list
	 * @param targetData
	 * @param comparator
	 * @return node with target data or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node<T> currentNode=head;
		while (currentNode!=null) {
			if (comparator.compare(targetData, currentNode.data)==0) {
				if (currentNode==head) {
					head = head.next;
				} else if (currentNode==tail) {
					tail = tail.prev;
				} else {
					currentNode.prev.next=currentNode.next;
					currentNode.next.prev=currentNode.prev;
				}
				listSize--;
				return this;
			}
			currentNode=currentNode.next;
		}
		return this;
	}
	
	/**
	 * Removes and gets the first element of the list
	 * @return first element from the list
	 */
	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		}
		else {
			T headData=head.data;
			head=head.next;
			listSize--;
			return headData;
		}
	}
	
	/**
	 * Removes and gets the last element of the list
	 * @return last element from the list
	 */
	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
		}
		else {
			T tailData=tail.data;
			tail=tail.prev;
			listSize--;
			return tailData;
		}
	}
	
	/**
	 * Returns an arraylist with the elements of the list
	 * @return arraylist
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> arrayList=new ArrayList<T>(listSize);
		
		Node<T> currentNode=head;
		
		while (currentNode!=null) {
			arrayList.add(currentNode.data);
			currentNode=currentNode.next;
		}

		return arrayList;
	}
	
	/**
	 * Inner class Node
	 * @author wudin
	 *
	 * @param <T>
	 */
	protected class Node<T>{
		protected T data;
		protected Node<T> prev;
		protected Node<T> next;
		
		protected Node(T data) {
			this.data=data;
			prev=null;
			next=null;
		}
	}
	
	/**
	 * Inner class DoubleLinkedListIterator
	 * @author wudin
	 *
	 * @param <T>
	 */
	protected class DoubleLinkedListIterator<T> implements ListIterator<T>{
		public Node currentNode=head;
		public Node<T> prevNode=null;
		
		@Override
		public boolean hasNext() {
			if(currentNode==null) {
				return false;
			}
			else {
				return true;
			}
		}
		
		@Override
		public T next() throws NoSuchElementException{
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				prevNode=currentNode;
				currentNode=currentNode.next;
				return prevNode.data;
			}
		}
		
		@Override
		public boolean hasPrevious() {
			if(prevNode==null) {
				return false;
			}
			else {
				return true;
			}
		}
		
		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else {
				currentNode=prevNode;
				prevNode=prevNode.prev;
				return (T) currentNode.data;
			}
		}
		
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void add(T data) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void set(T data) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}

}
