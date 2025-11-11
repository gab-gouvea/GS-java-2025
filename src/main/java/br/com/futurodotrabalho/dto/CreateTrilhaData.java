package br.com.futurodotrabalho.dto;

import br.com.futurodotrabalho.entity.Nivel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateTrilhaData(
        @NotBlank String titulo,
        String descricao,
        @NotNull Nivel nivel,
        @NotBlank String areaFoco,
        Integer cargaHoraria,
        List<String> habilidadesDesenvolvidas
){

}
