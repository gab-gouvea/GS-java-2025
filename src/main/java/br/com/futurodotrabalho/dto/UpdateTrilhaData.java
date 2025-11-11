package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Nivel;

import java.util.List;

public record UpdateTrilhaData(
        String titulo,
        String descricao,
        Nivel nivel,
        String areaFoco,
        Integer cargaHoraria,
        List<String> habilidadesDesenvolvidas
) {
}
