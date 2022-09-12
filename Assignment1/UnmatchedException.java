/**
 * Exception for when typed password and retyped password don't match
 * @author wudin
 *
 */
public class UnmatchedException extends Exception{
	
	public UnmatchedException() {
		super("The passwords do not match");
	}

}
