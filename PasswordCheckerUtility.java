import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		try {
			if (password.equals(passwordConfirm) == false){
			 throw new UnmatchedException();
			}
		}
		catch (UnmatchedException b){
			System.out.println(b.getMessage());
		}
	}
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		boolean result = false;
		
		result = password.equals(passwordConfirm);
		return result;
	}
	public static java.util.ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> badPasswords = new ArrayList<String>();
		for(int i = 0; i < passwords.size(); i++) {
			try {
				if (isValidPassword(passwords.get(i)) == false) {
					badPasswords.add(passwords.get(i));
				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				e.printStackTrace();
			}
		}
		
		return badPasswords;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		boolean result = false;
		
		int length = password.length();
		if (length >= 6 && length <= 9){
			result = true;
		}
		else result = false;
		
		return result;
	}
	public static boolean hasDigit(String password) throws NoDigitException{
		boolean result = false;
		for (int i = 0; i < password.length()-1; i++) {
			char c = password.charAt(i);
			if (Character.isDigit(c)) {
				result = true;
				break;
			}
		}

		try {
			if (result = false) {
				throw new NoDigitException();
			}
		}
		catch(NoDigitException b) {
			System.out.println(b.getMessage());
		}
		return result;
	}

	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		boolean result = false;
		
		for (int i = 0; i < password.length()-1; i++) {
			char c = password.charAt(i);
			if (Character.isLowerCase(c)) {
				result = true;
				break;
			}
		}

		try {
			if (result == false) {
				throw new NoLowerAlphaException();
			}
		}
		catch(NoLowerAlphaException b) {
			System.out.println(b.getMessage());
		}
		return result;
	}
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
		boolean result = false;

		for (int i = 1; i < password.length()-1; i++) {
			char c = password.charAt(i);
			char d = password.charAt(i-1);
			if (c == d) {
				result = true;
				break;
			}
		}
		
		try {
			if (result = true) {
				throw new InvalidSequenceException();
			}
		}
		catch(InvalidSequenceException b) {
			System.out.println(b.getMessage());
		}
		
		return result;
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		try {
			if (matcher.matches() == false) {
				throw new NoSpecialCharacterException();
			}
		}
		catch (NoSpecialCharacterException b) {
			System.out.println(b.getMessage());
		}
		return (!matcher.matches());
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		boolean result = false;
		
		for (int i = 0; i < password.length()-1; i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				result = true;
				break;
			}
		}

		try {
			if (result = false) {
				throw new NoUpperAlphaException();
			}
		}
		catch(NoUpperAlphaException b) {
			System.out.println(b.getMessage());
		}
		return result;
	}
	
	public static boolean isValidPassword(String password) throws LengthException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoDigitException,
    NoSpecialCharacterException,
    InvalidSequenceException
	{
		boolean result = true;
		try {
			if (!isValidLength(password)) {
				throw new LengthException();
			}
			if (!hasUpperAlpha(password)) {
				throw new NoUpperAlphaException();
			}
			if (!hasLowerAlpha(password)) {
				throw new NoLowerAlphaException();
			}
			if (!hasDigit(password)) {
				throw new NoDigitException();
			}
			if (!hasSpecialChar(password)) {
				throw new NoSpecialCharacterException();
			}
			if (!hasSameCharInSequence(password)) {
				throw new InvalidSequenceException();
			}
			
		}
		catch (LengthException e){
			result = false;
		}
		catch (NoUpperAlphaException e){
			result = false;
		}
		catch (NoLowerAlphaException e){
			result = false;
		}
		catch (NoDigitException e){
			result = false;
		}
		catch (NoSpecialCharacterException e){
			result = false;
		}
		catch (InvalidSequenceException e){
			result = false;
		}
		return result;
	}
	public static boolean isValidLength(String password) throws LengthException {
		boolean result = false;

		int length = password.length();
		try {
			if (length < 6) {
				throw new LengthException();
			}
		} catch (LengthException a){
			System.out.println(a.getMessage());
			result = false;
		}
		
		return result;
	}
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		boolean result = false;
		try {
			if (hasBetweenSixAndNineChars(password) == true) {
				throw new WeakPasswordException();
			}
		} catch (WeakPasswordException b){
			System.out.println(b.getMessage());
			result = true;
		}
		return result;
	}
	
	
	

	

	
}