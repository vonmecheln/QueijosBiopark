package br.com.ifprbiopark.queijo_desktop.exception;

public class BasicException extends Exception{

    public BasicException() {
    }

    public BasicException(Exception e) {
        super(e.getMessage());
    }
    
    public BasicException(String message) {
        super(message);
    }
    
    
    
    
    
    
}
