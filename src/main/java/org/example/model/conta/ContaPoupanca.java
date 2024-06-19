package org.example.model.conta;

import lombok.Getter;
import org.example.model.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.POUPANCA);
    }

    @Override
    public void imprimirInfos() {
        System.out.println("*** Extrato Conta poupança ***");
        super.extratoContas();
    }

}
