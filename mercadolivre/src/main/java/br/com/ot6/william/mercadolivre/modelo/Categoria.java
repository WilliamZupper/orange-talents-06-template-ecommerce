package br.com.ot6.william.mercadolivre.modelo;

import javax.persistence.*;


@Entity
@Table(name = "tbcategoria")
public class Categoria {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;


     @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Categoria categoriaMae;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void setMae(Categoria categoriaMae) {
        this.categoriaMae = categoriaMae;
    }

   @Deprecated
    public Categoria() {
    }


}
