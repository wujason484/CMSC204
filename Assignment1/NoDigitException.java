/**
 * Exception when password is missing a digit
 * @author wudin
 *
 */
public class NoDigitException extends Exception{
	
	public NoDigitException() {
		super("The password must contain at least one digit");
	}

}
