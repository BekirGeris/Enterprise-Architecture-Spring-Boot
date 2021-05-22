package com.begers.northwind.core.utilities.result;

public class Result {

	private boolean success;
	private String message;

	public Result(boolean success) {
		this(success, null);
	}

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public boolean isSucces() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
