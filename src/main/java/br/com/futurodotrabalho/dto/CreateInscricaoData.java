package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateInscricaoData(
        @NotBlank String usuario_id,
        @NotBlank String trilha_id,
        @NotNull Status status
) {
}
