package br.com.dio.java_bank.excetion;

public class WalletNotFoundException extends RuntimeException{

    public WalletNotFoundException(String message){super(message);}
}
