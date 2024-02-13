package com.example.Ecommerce.ExceptionHandler;

public class IdException extends Exception {
    private String errorMessage;
public IdException(String message, String errorMessage){
super(message);
this.errorMessage = errorMessage;
}

public String getErrorMessage(){
    return errorMessage;
}

}
