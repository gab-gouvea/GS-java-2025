package br.com.futurodotrabalho.service;

import br.com.futurodotrabalho.dto.CreateTrilhaData;
import br.com.futurodotrabalho.dto.UpdateTrilhaData;
import br.com.futurodotrabalho.entity.TrilhaAprendizado;
import br.com.futurodotrabalho.exception.TrilhaNotFoundException;
import br.com.futurodotrabalho.repository.TrilhaAprendizadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaAprendizadoService {

    private final TrilhaAprendizadoRepository trilhaAprendizadoRepository;

    public TrilhaAprendizadoService(TrilhaAprendizadoRepository trilhaAprendizadoRepository) {
        this.trilhaAprendizadoRepository = trilhaAprendizadoRepository;
    }

    @Transactional
    public TrilhaAprendizado criar(CreateTrilhaData data) {
        var entity = new TrilhaAprendizado(
                data.titulo(),
                data.descricao(),
                data.nivel(),
                data.areaFoco(),
                data.cargaHoraria(),
                data.habilidadesDesenvolvidas()
        );

        return trilhaAprendizadoRepository.save(entity);
    }

    public List<TrilhaAprendizado> buscarTodos() {
        return trilhaAprendizadoRepository.findAll();
    }

    public TrilhaAprendizado buscarPorId(Long id) {
        return trilhaAprendizadoRepository.findById(id)
                .orElseThrow(() -> new TrilhaNotFoundException("Trilha de aprendizado não encontrada: " + id));
    }

    @Transactional
    public TrilhaAprendizado atualizar(Long id, UpdateTrilhaData data) {
        TrilhaAprendizado trilhaAprendizado = trilhaAprendizadoRepository.findById(id)
                .orElseThrow(() -> new TrilhaNotFoundException("Trilha de aprendizado não encontrada: " + id));

        trilhaAprendizado.atualizarValores(data);
        return trilhaAprendizadoRepository.save(trilhaAprendizado);
    }

    @Transactional
    public void remover(Long id) {
        TrilhaAprendizado trilha = trilhaAprendizadoRepository.findById(id)
                .orElseThrow(() -> new TrilhaNotFoundException("Trilha de aprendizado não encontrada: " + id));
        trilhaAprendizadoRepository.delete(trilha);
    }
}
