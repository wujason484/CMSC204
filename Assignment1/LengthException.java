/**
 * Exception for when password doesn't reach 6 characters
 * @author wudin
 *
 */
public class LengthException extends Exception{
	
	public LengthException() {
		super("The password must be at least 6 characters long");
	}

}
