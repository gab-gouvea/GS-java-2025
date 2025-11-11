package br.com.futurodotrabalho.repository;

import br.com.futurodotrabalho.entity.Inscricao;
import br.com.futurodotrabalho.entity.TrilhaAprendizado;
import br.com.futurodotrabalho.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao,Long> {
    boolean existsByUsuarioAndTrilhaAprendizado(Usuario usuario, TrilhaAprendizado trilhaAprendizado);
}
