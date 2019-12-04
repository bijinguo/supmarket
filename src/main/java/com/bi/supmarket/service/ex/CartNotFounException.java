package com.bi.supmarket.service.ex;

public class CartNotFounException extends ServiceException {
    public CartNotFounException() {
        super();
    }

    public CartNotFounException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CartNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFounException(String message) {
        super(message);
    }

    public CartNotFounException(Throwable cause) {
        super(cause);
    }
}
