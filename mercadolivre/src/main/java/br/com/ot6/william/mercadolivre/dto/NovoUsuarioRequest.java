package br.com.ot6.william.mercadolivre.dto;

import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.validacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioRequest {

    @NotBlank
    @Email
    @UniqueValue(Classe = Usuario.class, campo = "email")
    private String email;

    @NotBlank
    @Length(min = 6)
    private String senha;

    public NovoUsuarioRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public Usuario toModel() {
        return new Usuario(this.email, this.senha);
    }

}
