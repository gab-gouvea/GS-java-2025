package br.com.futurodotrabalho.service;

import br.com.futurodotrabalho.dto.CreateInscricaoData;
import br.com.futurodotrabalho.dto.UpdateInscricaoData;
import br.com.futurodotrabalho.entity.Inscricao;
import br.com.futurodotrabalho.entity.Status;
import br.com.futurodotrabalho.entity.TrilhaAprendizado;
import br.com.futurodotrabalho.entity.Usuario;
import br.com.futurodotrabalho.exception.InscricaoNotFoundException;
import br.com.futurodotrabalho.exception.RegraDeNegocioException;
import br.com.futurodotrabalho.exception.TrilhaNotFoundException;
import br.com.futurodotrabalho.exception.UsuarioNotFoundException;
import br.com.futurodotrabalho.repository.InscricaoRepository;
import br.com.futurodotrabalho.repository.TrilhaAprendizadoRepository;
import br.com.futurodotrabalho.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TrilhaAprendizadoRepository trilhaAprendizadoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository, UsuarioRepository usuarioRepository, TrilhaAprendizadoRepository trilhaAprendizadoRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.trilhaAprendizadoRepository = trilhaAprendizadoRepository;
    }

    @Transactional
    public Inscricao criar(CreateInscricaoData data) {
        Usuario usuario = usuarioRepository.findById(data.usuario_id())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado: " + data.usuario_id()));

        TrilhaAprendizado trilhaAprendizado = trilhaAprendizadoRepository.findById(data.trilha_id())
                .orElseThrow(() -> new TrilhaNotFoundException("Trilha de aprendizado não encontrada: " + data.trilha_id()));

        var entity = new Inscricao(
                usuario,
                trilhaAprendizado,
                Status.INSCRITO
        );

        if (inscricaoRepository.existsByUsuarioAndTrilhaAprendizado(usuario, trilhaAprendizado)) {
            throw new RegraDeNegocioException("Usuário já cadastrado nessa trilha de aprendizado");
        }

        return inscricaoRepository.save(entity);
    }

    public List<Inscricao> buscarTodos() {
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarPorId(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new InscricaoNotFoundException("Inscrição não encontrada: " + id));
    }

    @Transactional
    public Inscricao atualizar(Long id, UpdateInscricaoData data) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new InscricaoNotFoundException("Inscrição não encontrada: " + id));

        Usuario usuario = null;
        TrilhaAprendizado trilhaAprendizado = null;

        if (data.usuario_id() != null) {
            usuario = usuarioRepository.findById(data.usuario_id())
                    .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado: " + data.usuario_id()));
        }

        if (data.trilha_id() != null) {
            trilhaAprendizado = trilhaAprendizadoRepository.findById(data.trilha_id())
                    .orElseThrow(() -> new TrilhaNotFoundException("Trilha de aprendizado não encontrada: " + data.trilha_id()));
        }

        inscricao.atualizarValores(usuario,trilhaAprendizado,data.status());
        return inscricaoRepository.save(inscricao);
    }

    @Transactional
    public void remover(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new InscricaoNotFoundException("Inscrição não encontrada: " + id));

        inscricaoRepository.delete(inscricao);
    }
}
