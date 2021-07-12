package br.com.ot6.william.mercadolivre.modelo;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime criadoem;


    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.criadoem = LocalDateTime.now();
    }

     @Deprecated
    public Usuario() {
    }
}
