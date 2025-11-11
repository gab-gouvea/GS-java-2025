package br.com.futurodotrabalho.repository;

import br.com.futurodotrabalho.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao,Long> {
}
