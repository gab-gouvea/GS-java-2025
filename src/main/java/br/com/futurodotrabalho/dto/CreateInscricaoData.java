package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateInscricaoData(
        @NotBlank Long usuario_id,
        @NotBlank Long trilha_id

) {
}
