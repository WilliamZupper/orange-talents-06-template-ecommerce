package br.com.ot6.william.mercadolivre.dto;


import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoUsuarioRequest {

    @Email
     @JsonProperty("login")
     @UniqueValue(Classe = Usuario.class, campo = "login")
    @NotBlank
    private String login;

     @JsonProperty("senha")
     @NotBlank
     @Size(min = 6 )
    private String senha;

    public Usuario toModel(){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return new Usuario(login, encoder.encode(senha));
    }
}
