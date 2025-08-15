package br.com.dio.java_bank.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@EqualsAndHashCode
@Getter
public class Money {

    private long amount ;

    private final List<MoneyAudit> history = new ArrayList<>();

    public Money(final long amount, final MoneyAudit history){
        if (amount <= 0) throw new IllegalArgumentException("amount dever ser > 0");
        this.amount = amount;
        this.history.add(history);
    }

    public Money(final MoneyAudit history){
        this(1L, history);
    }
    public void addHistory(final MoneyAudit history){
        this.history.add(history);
    }

    public Money take(final long value){
        if (value <= 0 || value > this.amount) {
            throw new IllegalArgumentException("Valor inválido para take: " + value);
        }
        Money out = new Money(value, this.history.get(0));
        for (int i = 1; i < this.history.size(); i++) {
            out.addHistory(this.history.get(i));
        }
        this.amount -= value;
        return out;
    }
    @Override
    public String toString() {
        BigDecimal valor = BigDecimal.valueOf(amount, 2);
        return "Money{" +
                "valor=" + NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(valor) +
                ", totalTransacoes=" + history.size() +
                ", ultimaTransacao=" + (history.isEmpty() ? "nenhuma" : history.get(history.size() - 1)) +
                '}';
    }

}
