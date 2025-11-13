package br.com.futurodotrabalho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUsuarioData(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @Size(min = 8) @NotBlank String senha,
        String ocupacaoAtual,
        String objetivoProfissional,
        @NotBlank String role
) {
}
