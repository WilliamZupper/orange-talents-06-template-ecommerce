package br.com.ot6.william.mercadolivre.controller;

;
import br.com.ot6.william.mercadolivre.dto.NovoUsuarioRequest;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario>criar(@RequestBody @Valid NovoUsuarioRequest usuarioRequest){

          Usuario usuario = usuarioRequest.toModel();
            usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }


}
