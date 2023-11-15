package com.company;


public class UserExceptionHandling extends  RuntimeException{
    public  UserExceptionHandling(){

    }
    public  UserExceptionHandling(String message){
        super(message);
    }
}