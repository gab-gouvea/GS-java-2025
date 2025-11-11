package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Status;

public record UpdateInscricaoData(
        Long usuario_id,
        Long trilha_id,
        Status status
) {
}
