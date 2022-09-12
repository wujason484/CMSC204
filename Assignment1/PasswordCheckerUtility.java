/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Check a user entered password for if they meet the requirements of a valid password
 * Due: 9/10/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	public PasswordCheckerUtility() {
		
	}
	
	/**
	 * Compares password with retyped password to see if they are the same
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		
		if(password.length()>=passwordConfirm.length()) {
			for(int i=0; i<password.length(); i++) {
				if(password.charAt(i)!=passwordConfirm.charAt(i)) {
					throw new UnmatchedException();
				}
			}
		}
		
		else if(password.length()<passwordConfirm.length()) {
			for(int i=0; i<passwordConfirm.length(); i++) {
				if(password.charAt(i)!=passwordConfirm.charAt(i)) {
					throw new UnmatchedException();
				}
			}
		}
	}
	
	/**
	 * Compares password with retyped password to see if they are the same and returns boolean
	 * @param password
	 * @param passwordConfirm
	 * @return if passwords are the same or not
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(password.length()>=passwordConfirm.length()) {
			for(int i=0; i<password.length(); i++) {
				if(password.charAt(i)!=passwordConfirm.charAt(i)) {
					return false;
				}
			}
		}
		
		else if(password.length()<passwordConfirm.length()) {
			for(int i=0; i<passwordConfirm.length(); i++) {
				if(password.charAt(i)!=passwordConfirm.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Checks if password has the minimum six characters
	 * @param password
	 * @return if password has at least six characters
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException{
		boolean result=false;
		if(password.length()>=6) {
			result=true;
		}
		else {
			result= false;
			throw new LengthException();
		}
		return result;
	}
	
	/**
	 * Checks if password contains an uppercase letter
	 * @param password
	 * @return if password has uppercase letter
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		boolean result=false;
		
		for (int i=0; i<password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				result=true;
				i=password.length();
			}
			else if(!Character.isUpperCase(password.charAt(i))) {
				throw new NoUpperAlphaException();
			}
		}
		return result;
	}
	
	/**
	 * Checks if password contains a lowercase letter
	 * @param password
	 * @return if password has lowercase letter
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		boolean result=false;
		
		for (int i=0; i<password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				result=true;
				i=password.length();
			}
			else if(!Character.isLowerCase(password.charAt(i))) {
				throw new NoLowerAlphaException();
			}
		}
		return result;
	}
	
	/**
	 * Checks if password has a digit
	 * @param password
	 * @return if password has a digit
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		boolean result=false;
		
		for (int i=0; i<password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				result=true;
				i=password.length();
			}
			else if(!Character.isDigit(password.charAt(i))) {
				throw new NoDigitException();
			}
		}
		return result;
	}
	
	/**
	 * Checks if password contains a special character
	 * @param password
	 * @return if password has a special character
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
	    Matcher m = p.matcher(password);
	    boolean result=m.find();
	    
	    if(result) {
	    	throw new NoSpecialCharacterException();
	    }
	    
	    return result;
	}
	
	/**
	 * Checks if the same character is used more than two times in a row
	 * @param password
	 * @return true if no same character and false if there is
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
	    boolean result=false;
	    
	    for(int i=0; i<password.length()-2; i++) {
	    	if((password.charAt(i))==(password.charAt(i+1)) && (password.charAt(i+1))==(password.charAt(i+2))) {
	    		result=false;
	    		throw new InvalidSequenceException();
	    	}
	    	else {
	    		result=true;
	    	}
	    	
	    }
	    
	    return result;
	}
	
	/**
	 * Checks if password meets all the requirements
	 * @param password
	 * @return true if all requirements met and false if not
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException,
	NoSpecialCharacterException, InvalidSequenceException{
		boolean result=false;
		
		result=isValidLength(password);
		result=hasUpperAlpha(password);
		result=hasLowerAlpha(password);
		result=hasDigit(password);
		result=hasSpecialChar(password);
		result=NoSameCharInSequence(password);
		
		return result;
	}
	
	/**
	 * Checks if password is between 6 to 9 characters
	 * @param password
	 * @return true if between six to nine characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length()>=6 && password.length()<=9) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if valid password is weak
	 * @param password
	 * @return true if password is weak
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		boolean result=hasBetweenSixAndNineChars(password);
		
		if(result) {
			result=true;
			throw new WeakPasswordException();
		}
		return result;
	}
	
	/**
	 * Takes a list of passwords and checks for valid ones
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (String p : passwords) {
			try {
				isValidPassword(p);
			} catch (LengthException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			} catch (NoUpperAlphaException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			} catch (NoLowerAlphaException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			} catch (NoDigitException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			} catch (NoSpecialCharacterException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			} catch (InvalidSequenceException i) {
				invalidPasswords.add(p + " " + i.getMessage());
			}

		}

		return invalidPasswords;
	}

}
