/**
 * Exception when more than two of the same character is used in a row
 * @author wudin
 *
 */
public class InvalidSequenceException extends Exception{
	
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}

}
