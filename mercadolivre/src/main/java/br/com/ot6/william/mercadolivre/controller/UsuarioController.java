package br.com.ot6.william.mercadolivre.controller;

import br.com.ot6.william.mercadolivre.dto.NovoUsuarioRequest;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

     @Transactional
    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoUsuarioRequest request) {
        Usuario usuario = request.toModel();
        usuarioRepository.save(usuario);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getSenha());
        System.out.println(usuario.getDataCriacao());

        return ResponseEntity.ok().build();
    }
}
