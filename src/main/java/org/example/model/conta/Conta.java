package org.example.model.conta;

import lombok.Getter;
import lombok.ToString;
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

    public void sacar(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if(valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada no valor de: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente");
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
