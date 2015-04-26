package main.security;

public class NameCollisionException extends Exception {
	private static final long serialVersionUID = 6747268102465609479L;
	
	private String causingName;
	
	public NameCollisionException(String name) {
		causingName = name;
	}
	
	@Override
	public String getMessage() {
		return "Whilst registering the config modules, a duplicate was found: " + causingName;
	}
	
}
