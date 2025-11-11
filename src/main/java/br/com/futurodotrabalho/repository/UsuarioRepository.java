package br.com.futurodotrabalho.repository;

import br.com.futurodotrabalho.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
