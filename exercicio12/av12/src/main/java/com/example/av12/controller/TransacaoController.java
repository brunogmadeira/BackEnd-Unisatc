package com.example.av12.controller;

import com.example.av12.dto.ContaDTO;
import com.example.av12.dto.TransacaoRequestDTO;
import com.example.av12.dto.TransacaoResponseDTO;
import com.example.av12.mapper.ContaMapper;
import com.example.av12.service.TransacoesService;
import com.seu_projeto.model.Transacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/'transacoes'")
public class TransacaoController {

    private final TransacoesService transacoesService;

    public TransacaoController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        Transacao transacao = transacoesService.realizarTransacao(
                transacaoRequestDTO.origem(),
                transacaoRequestDTO.destino(),
                transacaoRequestDTO.valor()
        );

        ContaDTO contaOrigemDTO = ContaMapper.toDTO(transacao.getOrigem());
        ContaDTO contaDestinoDTO = ContaMapper.toDTO(transacao.getDestino());

        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO(contaOrigemDTO, contaDestinoDTO, transacao.getValor());

        return ResponseEntity.ok(responseDTO);
    }
}
