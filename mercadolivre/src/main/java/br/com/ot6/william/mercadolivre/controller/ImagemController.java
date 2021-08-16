package br.com.ot6.william.mercadolivre.controller;

import br.com.ot6.william.mercadolivre.dto.NovasImagensRequest;
import br.com.ot6.william.mercadolivre.modelo.Produto;
import br.com.ot6.william.mercadolivre.modelo.Uploader;

import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
public class ImagemController {

    @PersistenceContext
    EntityManager manager;

    @Autowired
    ProdutoRepository repository;
    @Autowired
    private Uploader uploaderFake;
    @PostMapping(value = "/produtos/{id}/imagens")
    @Transactional
    public String adicionaImagens(@PathVariable("id")Long id, @Valid NovasImagensRequest request){




        Usuario usuario = (Usuario)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Produto produto =  manager.find(Produto.class, id);

        if(!produto.pertence(usuario)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }


        Set<String> links =  uploaderFake.enviar(request.getImagens());


      produto.associaImagens(links);

      manager.merge(produto);

      return produto.toString();


    }


}
