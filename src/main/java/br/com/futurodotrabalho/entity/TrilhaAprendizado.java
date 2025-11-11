package br.com.futurodotrabalho.entity;


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
}
