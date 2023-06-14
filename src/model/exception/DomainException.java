package model.exception;

public class DomainException extends Exception {
	/*Pode se extender da Exception ou da RuntimeException, única diferença é que na RTE o compilador não te obriga a tratar*/

	private static final long serialVersionUID = 1L;
	
	public  DomainException(String msg) {
		super(msg);
	}

}
