package com.bi.supmarket.controller.ex;

/**
 * 文件上传中对应 IllegalStateException的自定义异常
 */
public class FileStateException extends FileUploadException {


	private static final long serialVersionUID = 1L;

	public FileStateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileStateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileStateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
