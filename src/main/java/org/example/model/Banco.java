package org.example.model;

import lombok.Getter;
import org.example.model.conta.Conta;
import org.example.model.conta.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    @Getter
    private String nome;
    private List<Conta> contasCadastradas;

    public Banco(String nome) {
        this.nome = nome;
        this.contasCadastradas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contasCadastradas.add(conta);
    }

    public List<Conta> retornarTodasAsDeContas() {
        return contasCadastradas;
    }

    public void retornarTipoDeConta(TipoConta tipoConta) {
        contasCadastradas.stream()
                .filter(conta -> conta.getTipoConta() == tipoConta)
                .forEach(Conta::extratoContas);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", contasCadastradas=" + contasCadastradas +
                '}';
    }
}
