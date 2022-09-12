/**
 * Exception when password is valid but less than 10 characters long
 * @author wudin
 *
 */
public class WeakPasswordException extends Exception{
	
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

}
