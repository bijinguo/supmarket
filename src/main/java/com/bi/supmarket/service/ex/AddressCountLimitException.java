package com.bi.supmarket.service.ex;

/**
 * 用户已经存在的收货地址达到上限
 * 添加新地址时抛出的异常
 */
public class AddressCountLimitException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public AddressCountLimitException() {
		super();
	}

	public AddressCountLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressCountLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressCountLimitException(String message) {
		super(message);
	}

	public AddressCountLimitException(Throwable cause) {
		super(cause);
	}

	
}
