package br.com.dio.java_bank;

import br.com.dio.java_bank.excetion.AccountNotFoundException;
import br.com.dio.java_bank.excetion.NotFundsEnoughException;
import br.com.dio.java_bank.excetion.WalletNotFoundException;
import br.com.dio.java_bank.model.AccountWallet;
import br.com.dio.java_bank.repository.AccountRepository;
import br.com.dio.java_bank.repository.InvestmentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.temporal.ChronoUnit.SECONDS;

public Main {
    private final static AccountRepository accountRepository = new AccountRepository();
    private final static InvestmentRepository investmentRepository = new InvestmentRepository();

    static Scanner leitura = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Ola seja bem vindo ao DIO Bank");
        while (true){
            System.out.println("Selecione a operação desejada");
            System.out.println("1 - Criar uma conta");
            System.out.println("2 - Criar um investimento");
            System.out.println("3 - Criar uma cateira de investimento");
            System.out.println("4 - Depositar na conta");
            System.out.println("5 - Sacar da conta");
            System.out.println("6 - Transferencia entre contas");
            System.out.println("7 - Investir");
            System.out.println("8 - Sacar Investimento");
            System.out.println("9 - Listar contas");
            System.out.println("10 - Listar investimentos");
            System.out.println("11 - Listar carteiras de investimentos");
            System.out.println("12 - Atualizar investimentos");
            System.out.println("13 - Historico de conta");
            System.out.println("14 - Sair");
            var option = leitura.nextInt();

            switch (option){
                case 1 -> createAccount();
                case 2 -> createInvestment();
                case 3 -> createWalletInvestment();
                case 4 -> deposit();
                case 5 -> withdraw();
                case 6 -> transferToAccount();
                case 7 -> incInvestment();
                case 8 -> rescueInvestment();
                case 9 -> accountRepository.list().forEach(System.out::println);
                case 10 -> investmentRepository.list().forEach(System.out::println);
                case 11 -> investmentRepository.listWallets().forEach(System.out::println);
                case 12 -> {
                    investmentRepository.updateAmount();
                    System.out.println("investimentos reajustados");
                }
                case 13 -> checkHistory();
                case 14 -> System.exit(0);
                default -> System.out.println("Opção invalida");
            }

        }
    }



    private static void createAccount() {
        System.out.println("Informe as chaves pix (separadas por ',' ");
        var pix = Arrays.stream(leitura.next().split(";")).toList();
        System.out.println("Informe o valor inicial de deposito");
        var amount = leitura.nextLong();
        var wallet= accountRepository.create(pix, amount);
        System.out.println("Conta criada: " + wallet);
    }

    private static void createInvestment() {
        System.out.println("Informe a taxa do investimento");
        var tax = leitura.nextInt();
        System.out.println("Informe o valor inicial de deposito");
        var initialFunds = leitura.nextLong();
        var investment = investmentRepository.create(tax, initialFunds);
        System.out.println("investimento criado: " + investment);
    }

    private static void withdraw(){
        System.out.println("informe a chave pix da conta para saque:");
        var pix = leitura.next();
        System.out.println("Informe o valor que será sacado: ");
        var amount = leitura.nextLong();
        try{
            accountRepository.withdraw(pix, amount);
        } catch (NotFundsEnoughException | AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void deposit(){
        System.out.println("informe a chave pix da conta para deposito:");
        var pix = leitura.next();
        System.out.println("Informe o valor que será depositado: ");
        var amount = leitura.nextLong();
        try{
            accountRepository.deposit(pix, amount);
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void transferToAccount(){
        System.out.println("informe a chave pix da conta de origem:");
        var source = leitura.next();
        System.out.println("informe a chave pix da conta de destino: ");
        var target = leitura.next();
        System.out.println("Informe o valor que será depositado: ");
        var amount = leitura.nextLong();
        try{
            accountRepository.transferMoney(source, target, amount);
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void createWalletInvestment(){
        System.out.println("informe a chave pix da conta:");
        var pix = leitura.next();
        var account = accountRepository.findByPix(pix);
        System.out.println("Informe o identificador do investimento");
        var investmentId = leitura.nextInt();
        var investmentWallet = investmentRepository.initInvestment(account, investmentId);
        System.out.println("Conta de investimento criada " + investmentWallet);
    }

    private static void incInvestment() {
        System.out.println("informe a chave pix da conta para investimento:");
        var pix = leitura.next();
        System.out.println("Informe o valor que será investido: ");
        var amount = leitura.nextLong();
        try{
            accountRepository.deposit(pix, amount);
        }catch (WalletNotFoundException | AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void rescueInvestment(){
        System.out.println("informe a chave pix da conta para resgate do investimento:");
        var pix = leitura.next();
        System.out.println("Informe o valor que será sacado: ");
        var amount = leitura.nextLong();
        try{
            investmentRepository.withdraw(pix, amount);
        } catch (NotFundsEnoughException | AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void checkHistory() {
        System.out.println("Informe a chave pix da conta para verificar extrato:");
        var pix = leitura.next();
        try {
            var sortedHistory = accountRepository.getHistory(pix);
            sortedHistory.forEach((k, v) -> {
                System.out.println("Data: " + k.format(ISO_DATE_TIME));
                System.out.println("Transação: " + v.getFirst().transactionId());
                System.out.println("Descrição: " + v.getFirst().description());
                System.out.println("Quantidade de registros no grupo: " + v.size());
                System.out.println("------------------------------");
            });
        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
