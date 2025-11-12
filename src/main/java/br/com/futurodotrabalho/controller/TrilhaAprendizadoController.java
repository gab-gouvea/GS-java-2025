package br.com.futurodotrabalho.controller;

import br.com.futurodotrabalho.dto.CreateTrilhaData;
import br.com.futurodotrabalho.dto.UpdateTrilhaData;
import br.com.futurodotrabalho.entity.TrilhaAprendizado;
import br.com.futurodotrabalho.service.TrilhaAprendizadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaAprendizadoController {
    private final TrilhaAprendizadoService trilhaAprendizadoService;

    public TrilhaAprendizadoController(TrilhaAprendizadoService trilhaAprendizadoService) {
        this.trilhaAprendizadoService = trilhaAprendizadoService;
    }

    @PostMapping
    public ResponseEntity<TrilhaAprendizado> criar(@RequestBody @Valid CreateTrilhaData data) {
        TrilhaAprendizado trilha = trilhaAprendizadoService.criar(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(trilha);
    }

    @GetMapping
    public ResponseEntity<List<TrilhaAprendizado>> buscarTodos() {
        List<TrilhaAprendizado> trilhas = trilhaAprendizadoService.buscarTodos();
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaAprendizado> buscarPorId(@PathVariable Long id) {
        TrilhaAprendizado trilha = trilhaAprendizadoService.buscarPorId(id);
        return ResponseEntity.ok(trilha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaAprendizado> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateTrilhaData data) {
        TrilhaAprendizado trilha = trilhaAprendizadoService.atualizar(id, data);
        return ResponseEntity.ok(trilha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        trilhaAprendizadoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
