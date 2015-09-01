package team5.service;

public class PasswordNotFoundException extends Exception{
	public PasswordNotFoundException() {};
	public PasswordNotFoundException(String message){
		super(message);
	};
}
