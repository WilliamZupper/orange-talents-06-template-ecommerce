package br.com.ot6.william.mercadolivre.modelo;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class ImagemProduto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @URL
    @NotBlank
    private  String link;
    @ManyToOne
    @Valid
    private Produto produto;
    public ImagemProduto(Produto produto, @URL String link) {
        this.produto = produto;
        this.link = link;
    }

    @Deprecated
    public ImagemProduto() {
    }

    @Override
    public String toString() {
        return "ImagemProduto{" +
                "id=" + id +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemProduto that = (ImagemProduto) o;
        return Objects.equals(link, that.link) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, produto);
    }
}
