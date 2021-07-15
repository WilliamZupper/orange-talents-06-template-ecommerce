package br.com.ot6.william.mercadolivre.controller;

;
import br.com.ot6.william.mercadolivre.dto.NovoUsuarioRequest;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.UsuarioRepository;
import br.com.ot6.william.mercadolivre.validacao.ProibeEmailDuplicadoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ProibeEmailDuplicadoUsuario proibeEmailDuplicadoUsuario;

       @InitBinder
       public void init(WebDataBinder binder){

           binder.addValidators(proibeEmailDuplicadoUsuario);
       }




    @PostMapping
    @Transactional
    public ResponseEntity<Usuario>criar(@RequestBody @Valid NovoUsuarioRequest usuarioRequest){

          Usuario usuario = usuarioRequest.toModel();
            usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }


}
