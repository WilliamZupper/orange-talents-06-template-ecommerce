package br.com.ot6.william.mercadolivre.dto;


import br.com.ot6.william.mercadolivre.modelo.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoUsuarioRequest {

    @Email(message = "O login deve estar no formato de email")
    @JsonProperty("login")
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

    public String getLogin() {
        return login;
    }
}
