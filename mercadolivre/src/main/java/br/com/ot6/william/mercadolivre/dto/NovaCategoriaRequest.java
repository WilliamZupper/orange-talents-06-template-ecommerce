package br.com.ot6.william.mercadolivre.dto;

import br.com.ot6.william.mercadolivre.modelo.Categoria;
import br.com.ot6.william.mercadolivre.validacao.CheckId;
import br.com.ot6.william.mercadolivre.validacao.UniqueValue;


import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class NovaCategoriaRequest {

     @NotBlank
     @UniqueValue(Classe = Categoria.class, campo = "nome")
    private String nome;

     @Positive
    @CheckId(Classe = Categoria.class, campo = "id")
     private Long idCategoriaMae;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdCategoriaMae(Long idCategoriaMae) {
        this.idCategoriaMae = idCategoriaMae;
    }



    public Categoria toModel(EntityManager manager) {

         Categoria categoria = new Categoria(nome);

        if(idCategoriaMae != null){
            Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
            categoria.setMae(categoriaMae);
        }
        return  categoria;
    }
}
