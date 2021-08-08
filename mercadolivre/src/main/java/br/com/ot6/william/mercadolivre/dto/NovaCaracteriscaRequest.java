package br.com.ot6.william.mercadolivre.dto;

import br.com.ot6.william.mercadolivre.modelo.CaracteristicaProduto;
import br.com.ot6.william.mercadolivre.modelo.Produto;

import javax.validation.constraints.NotBlank;

public class NovaCaracteriscaRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;


    public NovaCaracteriscaRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "NovaCaracteriscaRequest{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteristicaProduto toModel(Produto produto) {

        return new CaracteristicaProduto(nome,descricao, produto);
    }
}
