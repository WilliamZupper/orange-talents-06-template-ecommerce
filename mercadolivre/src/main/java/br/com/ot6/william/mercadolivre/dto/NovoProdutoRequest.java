package br.com.ot6.william.mercadolivre.dto;

import br.com.ot6.william.mercadolivre.modelo.Categoria;
import br.com.ot6.william.mercadolivre.modelo.Produto;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.validacao.CheckId;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NovoProdutoRequest {

    @NotBlank
    private String nome;

    @Positive
    @NotNull
    private BigDecimal valor;

    @Positive
    @NotNull
    private int quantidade;

    @NotBlank
    @Length(max = 1000)
    private String descricao;

    @NotNull
    @CheckId(Classe = Categoria.class, campo = "id")
    private Long idCategoria;

    @Size(min = 3)
    @Valid
    private List<NovaCaracteriscaRequest> caracteristicas = new ArrayList<>();


    public NovoProdutoRequest(String nome, BigDecimal valor, int quantidade, String descricao, @NotNull Long idCategoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.caracteristicas.addAll(caracteristicas);
    }

    public List<NovaCaracteriscaRequest> getCaracteristicas() {
        return caracteristicas;
    }

    @Override
    public String toString() {
        return "NovoProdutoRequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", caracteristicas=" + caracteristicas +
                '}';
    }

    public Produto toModel(EntityManager manager, Usuario usuario) {
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Produto(nome, valor, quantidade, descricao, categoria, usuario, caracteristicas);
    }

    public Set<String> buscaCaracteristicasIguais() {
        HashSet<String> nomesIguais = new HashSet<>();
        HashSet<String> resultados = new HashSet<>();
        for (NovaCaracteriscaRequest caracteristica : caracteristicas) {
            String nome = caracteristica.getNome();
            if (!nomesIguais.add(nome)) {
                resultados.add(nome);
            }

        }
        return resultados;
    }
}
