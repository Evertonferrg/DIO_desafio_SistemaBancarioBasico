package br.com.dio.java_bank.repository;

import br.com.dio.java_bank.excetion.NotFundsEnoughException;
import br.com.dio.java_bank.model.AccountWallet;
import br.com.dio.java_bank.model.Money;
import br.com.dio.java_bank.model.MoneyAudit;
import br.com.dio.java_bank.model.Wallet;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static br.com.dio.java_bank.model.BankService.ACCOUNT;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CommonsRepository {

    public static void checkFundsForTransaction(final Wallet source, final long amount){
        if (source.getFunds() < amount){
            throw new NotFundsEnoughException("Seu saldo é insuficiente");
        }
    }

    public static List<Money> generateMoney(final UUID transactionId, final long funds, final String description) {
        var history = new MoneyAudit(transactionId, ACCOUNT, description, OffsetDateTime.now());
        return List.of(new Money(funds, history));
    }
}
