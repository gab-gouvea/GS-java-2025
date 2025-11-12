package br.com.futurodotrabalho.entity;


import br.com.futurodotrabalho.dto.UpdateTrilhaData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class TrilhaAprendizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Column(nullable = false)
    private String areaFoco;

    private Integer cargaHoraria;
    private List<String> habilidadesDesenvolvidas = new ArrayList<>();

    @CreatedDate
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "trilhaAprendizado")
    private List<Inscricao> inscricoes = new ArrayList<>();

    public TrilhaAprendizado(String titulo, String descricao, Nivel nivel, String areaFoco, Integer cargaHoraria, List<String> habilidadesDesenvolvidas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.areaFoco = areaFoco;
        this.cargaHoraria = cargaHoraria;
        this.habilidadesDesenvolvidas = habilidadesDesenvolvidas;
    }

    public void atualizarValores(UpdateTrilhaData data) {
        if (data.titulo() != null) this.titulo = data.titulo();
        if (data.descricao() != null) this.descricao = data.descricao();
        if (data.nivel() != null) this.nivel = data.nivel();
        if (data.areaFoco() != null) this.areaFoco = data.areaFoco();
        if (data.cargaHoraria() != null) this.cargaHoraria = data.cargaHoraria();
        if (data.habilidadesDesenvolvidas() != null) this.habilidadesDesenvolvidas = data.habilidadesDesenvolvidas();
    }
}
