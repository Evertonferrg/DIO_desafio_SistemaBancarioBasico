package br.com.dio.java_bank.model;

public record Investment(
        long id,
        long tax,
        long initialFunds)
{

    @Override
    public String toString() {
        return String.format(
                "Investment{id=%d, tax=%d%%, initialFunds=R$ %d,%02d}",
                id, tax, initialFunds / 100, initialFunds % 100
        );
    }
}
