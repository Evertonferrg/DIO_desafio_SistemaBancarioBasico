package br.com.dio.java_bank.model;


import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static br.com.dio.java_bank.model.BankService.INVESTMENT;

@ToString
@Getter
public class InvestimentWallet extends Wallet{

    private final Investment investment;
    private final AccountWallet account;

    public InvestimentWallet(Investment investment, AccountWallet account, final long amount) {
        super(INVESTMENT);
        this.investment = investment;
        this.account = account;
        addMoney(account.reduceMoney(amount), getService(), "investimento");
    }

    public void updateAmount(final long percent) {
        long amount = getFunds() * percent / 100;
        if (amount <= 0) return;
        var history = new MoneyAudit(UUID.randomUUID(), getService(), "rendimentos", OffsetDateTime.now());
        this.money.add(new Money(amount, history));
    }



}
