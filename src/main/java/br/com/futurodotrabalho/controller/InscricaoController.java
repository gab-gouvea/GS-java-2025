package br.com.futurodotrabalho.controller;

import br.com.futurodotrabalho.dto.CreateInscricaoData;
import br.com.futurodotrabalho.entity.Inscricao;
import br.com.futurodotrabalho.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
