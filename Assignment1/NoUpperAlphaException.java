/**
 * Exception for if password doesn't contain an uppercase latter
 * @author wudin
 *
 */
public class NoUpperAlphaException extends Exception{
	
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

}
