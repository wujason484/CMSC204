/**
 * Exception for when password doesn't contain a lower case letter
 * @author wudin
 *
 */
public class NoLowerAlphaException extends Exception{
	
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}

}
