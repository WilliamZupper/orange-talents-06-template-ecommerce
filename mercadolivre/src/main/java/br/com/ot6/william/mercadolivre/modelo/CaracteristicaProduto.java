package br.com.ot6.william.mercadolivre.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CaracteristicaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Produto produto;


    public CaracteristicaProduto(@NotBlank String nome, @NotBlank String descricao, Produto produto) {
        this.nome=nome;
        this.descricao=descricao;
        this.produto = produto;
    }

     @Deprecated
    public CaracteristicaProduto() {
    }
}
