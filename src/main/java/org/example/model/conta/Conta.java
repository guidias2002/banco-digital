package org.example.model.conta;

import lombok.Getter;
import lombok.ToString;
import org.example.exceptions.BalanceException;
import org.example.exceptions.InvalidValueException;
import org.example.exceptions.LimitExceededException;
import org.example.model.Cliente;

import java.util.List;

@ToString
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter
    protected int agencia;
    @Getter
    protected int numero;
    @Getter
    protected double saldo;
    protected Cliente cliente;
    @Getter
    protected TipoConta tipoConta;

    public Conta(Cliente cliente, TipoConta tipoConta) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    public void sacar(double valor) throws BalanceException, InvalidValueException, LimitExceededException {
        if(valor <= 0) {
            throw new InvalidValueException("O valor de saque deve ser maior que zero.");
        }

        limitePorTransacao(valor);

        if(valor <= saldo) {
            saldo -= valor;
        } else {
            throw new BalanceException("Saldo insuficiente");
        }
    }

    public void depositar(double valor) throws InvalidValueException {
        if(valor <= 0) {
            throw new InvalidValueException("O valor de depósito deve ser maior que zero.");
        }

        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) throws BalanceException, InvalidValueException, LimitExceededException {
        if(valor <= 0) {
            throw new InvalidValueException("O valor de transferência deve ser maior que zero.");
        }

        limitePorTransacao(valor);

        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferência realizada no valor de: R$" + valor);
    }

    private void limitePorTransacao(double valor) throws LimitExceededException {
        if(valor > 2000) {
            throw new LimitExceededException("Limite por transação excedido.");
        }
    }

    public void extratoContas() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Saldo: " + tipoConta);
    }
}
