package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Status;

public record UpdateInscricaoData(
        String usuario_id,
        String trilha_id,
        Status status
) {
}
