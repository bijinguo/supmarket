package com.bi.supmarket.controller.ex;

/**
 * 文件上传中对应 IOException的自定义异常
 */
public class FileIOException extends FileUploadException {


	private static final long serialVersionUID = 1L;

	public FileIOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileIOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileIOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileIOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
