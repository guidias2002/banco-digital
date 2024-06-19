package org.example.model.conta;

import lombok.Getter;
import org.example.model.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CORRENTE);
    }

    @Override
    public void imprimirInfos() {
        System.out.println("*** Extrato Conta corrente ***");
        super.extratoContas();
    }
}
