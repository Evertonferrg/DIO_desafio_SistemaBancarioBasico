package br.com.dio.java_bank.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MoneyAudit(
        UUID transactionId,
        BankService targetService,
        String description,
        OffsetDateTime createAt)
{
}
