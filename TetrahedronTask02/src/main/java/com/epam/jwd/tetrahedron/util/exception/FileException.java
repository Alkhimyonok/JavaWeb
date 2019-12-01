package com.epam.jwd.tetrahedron.util.exception;

public class FileException extends Exception{
    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(Exception e) {
        super(e);
    }

    public FileException(String message, Exception e) {
        super(message, e);
    }
}
