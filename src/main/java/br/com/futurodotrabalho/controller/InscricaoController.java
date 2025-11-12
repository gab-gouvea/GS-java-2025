package br.com.futurodotrabalho.controller;

import br.com.futurodotrabalho.dto.CreateInscricaoData;
import br.com.futurodotrabalho.dto.UpdateInscricaoData;
import br.com.futurodotrabalho.entity.Inscricao;
import br.com.futurodotrabalho.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<Inscricao> criar(@RequestBody @Valid CreateInscricaoData data) {
        Inscricao inscricao = inscricaoService.criar(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @GetMapping
    public ResponseEntity<List<Inscricao>> buscarTodos() {
        List<Inscricao> inscricoes = inscricaoService.buscarTodos();
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id) {
        Inscricao inscricao = inscricaoService.buscarPorId(id);
        return ResponseEntity.ok(inscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateInscricaoData data) {
        Inscricao inscricao = inscricaoService.atualizar(id, data);
        return ResponseEntity.ok(inscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        inscricaoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
