package br.com.futurodotrabalho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private TrilhaAprendizado trilhaAprendizado;

    @CreatedDate
    private LocalDate dataInscricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Inscricao(Usuario usuario, TrilhaAprendizado trilhaAprendizado, Status status) {
        this.usuario = usuario;
        this.trilhaAprendizado = trilhaAprendizado;
        this.status = status;
    }
}
