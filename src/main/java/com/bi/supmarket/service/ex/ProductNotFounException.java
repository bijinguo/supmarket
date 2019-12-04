package com.bi.supmarket.service.ex;

public class ProductNotFounException extends ServiceException {
    public ProductNotFounException(String s) {
    }

    public ProductNotFounException() {
        super();
    }

    public ProductNotFounException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFounException(Throwable cause) {
        super(cause);
    }
}
