/**
 * Occurs when dequeue method is called on empty queue
 * @author wudin
 *
 */
public class QueueUnderflowException extends Exception{
	
	public QueueUnderflowException() {
		super("The queue is empty");
	}

}
