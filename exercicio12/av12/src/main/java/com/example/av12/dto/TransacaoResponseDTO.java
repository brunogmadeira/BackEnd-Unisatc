package com.example.av12.dto;

import com.example.av12.dto.ContaDTO;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
