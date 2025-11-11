package br.com.futurodotrabalho.dto;

public record UpdateUsuarioData(
        String nome,
        String email,
        String ocupacaoAtual,
        String objetivoProfissional
) {
}
