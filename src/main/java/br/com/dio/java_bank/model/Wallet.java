package br.com.dio.java_bank.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;

@ToString
public abstract class Wallet {

    @Getter
    private final BankService service;

    protected final List<Money> money;

    public Wallet(final BankService serviceType) {
        this.service = serviceType;
        this.money = new ArrayList<>();
    }

    protected List<Money> generateMoney(final long amount, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), service, description, OffsetDateTime.now());
        return List.of(new Money(amount, history));
    }

    public long getFunds(){
        return money.stream().mapToLong(Money::getAmount).sum();
    }

    public void addMoney(final List<Money> money, final BankService service, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), service, description, OffsetDateTime.now());
        money.forEach(m -> m.addHistory(history));
        this.money.addAll(money);
    }

    public List<Money> reduceMoney(final long amount){
        List<Money> removed = new ArrayList<>();
        long remaining = amount;
        var it = this.money.iterator();
        while (remaining > 0 && it.hasNext()){
            Money m = it.next();
            long available = m.getAmount();

            if (available <= remaining){
                remaining -= available;
                it.remove();
                removed.add(m);
            } else {
                // divide a unidade atual e pega apenas o necessário
                Money part = m.take(remaining);
                removed.add(part);
                remaining = 0;
            }
        }
        // Assuma que checkFundsForTransaction já foi chamado antes
        return removed;

    }

    public List<MoneyAudit> getFinancialTransactions(){
        return money.stream().flatMap(m -> m.getHistory().stream()).toList();
    }

    @Override
    public String toString() {
        long cents = getFunds();
        return "Wallet{" +
                "service=" + service +
                ", money= R$" + (cents / 100) + ", " + (cents % 100) +
                '}';
    }
}
