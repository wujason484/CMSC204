/**
 * Occurs when enqueue method is called on full queue
 * @author wudin
 *
 */
public class QueueOverflowException extends Exception{
	
	public QueueOverflowException() {
		super("The queue is full");
	}

}
