/**
 * Occurs when top or pop method is called on empty stack
 * @author wudin
 *
 */
public class StackUnderflowException extends Exception{
	
	public StackUnderflowException() {
		super("The stack is empty");
	}

}
