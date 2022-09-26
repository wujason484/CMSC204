/**
 * Occurs when push method is called on a full stack
 * @author wudin
 *
 */
public class StackOverflowException extends Exception{
	
	public StackOverflowException() {
		super("The stack is full");
	}

}
