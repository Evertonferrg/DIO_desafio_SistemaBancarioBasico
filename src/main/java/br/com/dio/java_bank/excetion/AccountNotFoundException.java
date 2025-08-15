package br.com.dio.java_bank.excetion;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message){super(message);}
}
