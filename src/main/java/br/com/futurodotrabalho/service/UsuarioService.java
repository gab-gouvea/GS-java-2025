package br.com.futurodotrabalho.service;

import br.com.futurodotrabalho.dto.CreateUsuarioData;
import br.com.futurodotrabalho.dto.UpdateUsuarioData;
import br.com.futurodotrabalho.entity.Usuario;
import br.com.futurodotrabalho.exception.RegraDeNegocioException;
import br.com.futurodotrabalho.exception.UsuarioNotFoundException;
import br.com.futurodotrabalho.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario criar(CreateUsuarioData data) {
        if (usuarioRepository.existsByEmail(data.email())) {
            throw new RegraDeNegocioException("Email já cadastrado no sistema.");
        }

        var entity = new Usuario(
                data.nome(),
                data.email(),
                data.senha(),
                data.ocupacaoAtual(),
                data.objetivoProfissional(),
                data.role()
        );

        return usuarioRepository.save(entity);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorNome(String nome) {
        return usuarioRepository.findByNome(nome)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado no sistema." + nome));
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário nåo encontrado: " + id));
    }

    @Transactional
    public Usuario atualizar(Long id, UpdateUsuarioData data) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado: " + id));

        usuario.atualizarValores(data);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void remover(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado: " + id));
        usuarioRepository.delete(usuario);
    }
}
