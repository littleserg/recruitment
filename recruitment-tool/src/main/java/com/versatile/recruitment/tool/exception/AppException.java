package com.versatile.recruitment.tool.exception;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class AppException extends Exception {

    private static final long serialVersionUID = 2186447466978703829L;

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
