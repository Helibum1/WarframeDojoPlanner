package main.security;

import main.log.Log;

public class NoSuchConfigException extends Exception {
	private static final long serialVersionUID = 4591073120029690131L;
	
	private String causingModule;
	
	public NoSuchConfigException(String module) {
		causingModule = module;
	}
	
	@Override
	public String getMessage() {
		return "No such configuration loaded: " + causingModule;
	}

}
