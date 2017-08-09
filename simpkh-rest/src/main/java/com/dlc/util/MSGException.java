package com.dlc.util;

public class MSGException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ErrCode;
	private String ErrMessage;
	
	public MSGException(int errCode, String errMsg){
		super(errMsg);
		this.ErrCode = errCode;
		this.ErrMessage = errMsg;
	}

	public int getErrCode() {
		return ErrCode;
	}

	
	public String getErrMessage() {
		return ErrMessage;
	}

		
}
