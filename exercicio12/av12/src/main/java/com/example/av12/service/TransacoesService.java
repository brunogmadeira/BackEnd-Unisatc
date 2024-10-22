package com.example.av12.service;

import com.example.av12.model.Conta;
import com.seu_projeto.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private final List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        contas.add(new Conta("500-1", "Fulano", 500.0));
        contas.add(new Conta("320-2", "Ciclano", 300.0));
    }

    public Conta buscarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Transacao realizarTransacao(String codigoOrigem, String codigoDestino, Double valor) {
        Conta origem = buscarContaPorCodigo(codigoOrigem);
        Conta destino = buscarContaPorCodigo(codigoDestino);

        if (origem.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);

        return new Transacao(origem, destino, valor);
    }
}
