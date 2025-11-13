package br.com.futurodotrabalho.controller;

import br.com.futurodotrabalho.entity.Usuario;
import br.com.futurodotrabalho.security.JwtUtil;
import br.com.futurodotrabalho.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String nome, @RequestParam String senha){
        Usuario usuario = usuarioService.buscarPorNome(nome);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return JwtUtil.gerarToken(usuario.getNome(), usuario.getRole());
        } else {
            return "Credenciais inválidas!";
        }
    }
}
