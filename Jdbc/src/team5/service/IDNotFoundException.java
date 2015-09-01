package team5.service;

public class IDNotFoundException extends Exception{
	public IDNotFoundException (){};
	public IDNotFoundException(String message) {
		super(message);	
	};
}
