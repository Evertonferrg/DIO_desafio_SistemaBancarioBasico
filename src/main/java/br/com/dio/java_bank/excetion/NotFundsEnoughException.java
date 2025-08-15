package br.com.dio.java_bank.excetion;

public class NotFundsEnoughException extends RuntimeException{

    public NotFundsEnoughException(String message){super(message);}
}
