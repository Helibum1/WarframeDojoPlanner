package main.security;

import main.log.Log;

public class NoSuchKeyException extends Exception {
	private static final long serialVersionUID = 301501397666829464L;
	
	private String causingKey;
	private String inModule;
	
	public NoSuchKeyException(String module, String key) {
		causingKey = key;
		inModule = module;
	}
	
	@Override
	public String getMessage() {
		return "Then key '" + causingKey + "' doesn't exist in module '" + inModule + "'";
	}
	
}
