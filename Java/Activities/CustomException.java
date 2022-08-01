package alchemy.activities;

public class CustomException extends Exception{
	
	String message = null;
	
	CustomException(String message)
	{
		this.message = message;
		
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	
}
