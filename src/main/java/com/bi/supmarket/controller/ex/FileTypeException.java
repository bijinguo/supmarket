package com.bi.supmarket.controller.ex;

/**
 * 文件类型不匹配的异常
 */
public class FileTypeException extends FileUploadException {


	private static final long serialVersionUID = 1L;

	public FileTypeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
