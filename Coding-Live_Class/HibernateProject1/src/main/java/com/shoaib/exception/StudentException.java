package com.shoaib.exception;

import com.shoaib.domain.Student;

public class StudentException extends  RuntimeException{
    public StudentException(){

    }
    public StudentException(String message){
        super(message);
    }
}
