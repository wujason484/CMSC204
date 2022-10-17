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
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator=comparator;
	}
	
	/**
	 * Inserts element into correct position of the sorted list
	 * @param data
	 */
	public void add(T data) {
		Node<T> newNode=new Node(data);
		Node<T> headNode=head;
		
		if (listSize == 0) {
			head=newNode;
			tail=newNode;
			listSize++;
		}
		else if (comparator.compare(head.data, data) > 0) {
			newNode.next=head;
			head=newNode;
			listSize++;
		}
		else {
			while (comparator.compare(headNode.data, data) < 0) {
				if (headNode.next==null) {
					headNode.next=newNode;
					tail=newNode;
					listSize++;
				}
				else {
					headNode=headNode.next;
				}
			}
			headNode.prev.next=newNode;
			newNode.prev=headNode.prev;
			headNode.prev=newNode;
			newNode.next=headNode;
			listSize++;
		}
	}
	
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	@Override
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/**
	 * Implements iterator by calling super class iterator method
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * Implements remove operation by calling the super class remove method
	 */
	public BasicDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}

}
