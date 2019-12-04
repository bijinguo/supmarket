package com.bi.supmarket.service.ex;

/**
 * 插入操作时出现的异常
 * 无法描述原因或特殊情况时出现异常
 */
public class InsertException extends ServiceException {

	public InsertException() {
		super();
	}

	public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertException(String message) {
		super(message);
	}

	public InsertException(Throwable cause) {
		super(cause);
	}

}
