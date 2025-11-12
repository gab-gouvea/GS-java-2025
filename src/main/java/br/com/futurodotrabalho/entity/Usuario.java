package br.com.futurodotrabalho.entity;


import br.com.futurodotrabalho.dto.UpdateUsuarioData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
    private String ocupacaoAtual;
    private String objetivoProfissional;

    @CreatedDate
    private LocalDateTime dataCadastro;

    public Usuario(String name, String email, String senha, String ocupacaoAtual, String objetivoProfissional) {
        this.nome = name;
        this.email = email;
        this.senha = senha;
        this.ocupacaoAtual = ocupacaoAtual;
        this.objetivoProfissional = objetivoProfissional;
    }

    public void atualizarValores(UpdateUsuarioData data) {
        if (data.nome() != null) this.nome = data.nome();
        if (data.email() != null) this.email = data.email();
        if (data.ocupacaoAtual() != null) this.ocupacaoAtual = data.ocupacaoAtual();
        if (data.objetivoProfissional() != null) this.objetivoProfissional = data.objetivoProfissional();
    }
}
