/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Generic tree node class
 * Due: 11/30/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
public class TreeNode<T> {
	private T dataNode;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	TreeNode(T dataNode){
		this.dataNode= dataNode;
		leftChild= null;
		rightChild= null;
	}
	
	TreeNode(TreeNode<T> node){
		this.dataNode= node.dataNode;
		leftChild= node.leftChild;
		rightChild= node.rightChild;
	}
	
	public void setData(T dataNode) {
		this.dataNode= dataNode;
	}
	
	public T getData() {
		return dataNode;
	}
	
	public void setLeft(TreeNode<T> leftChild) {
		this.leftChild= leftChild;
	}
	
	public TreeNode<T> getLeft() {
		return leftChild;
	}

	public void setRight(TreeNode<T> rightChild) {
		this.rightChild= rightChild;
	}
	
	public TreeNode<T> getRight() {
		return rightChild;
	}

}
