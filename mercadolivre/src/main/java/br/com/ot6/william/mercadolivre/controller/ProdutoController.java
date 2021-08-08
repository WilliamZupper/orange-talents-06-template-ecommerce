package br.com.ot6.william.mercadolivre.controller;

import br.com.ot6.william.mercadolivre.dto.NovoProdutoRequest;
import br.com.ot6.william.mercadolivre.modelo.Produto;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.ProdutoRepository;
import br.com.ot6.william.mercadolivre.validacao.ProibeCaracteristicasComNomeIgualValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PersistenceContext
    EntityManager manager;


    @Autowired
    private ProdutoRepository produtoRepository;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ProibeCaracteristicasComNomeIgualValidator());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarProdutor(@RequestBody @Valid NovoProdutoRequest request) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Produto produto = request.toModel(manager, usuario);

        produtoRepository.save(produto);


        return ResponseEntity.ok().build();
    }
}
