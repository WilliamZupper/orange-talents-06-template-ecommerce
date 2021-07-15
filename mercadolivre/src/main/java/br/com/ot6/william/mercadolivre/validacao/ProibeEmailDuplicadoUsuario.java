package br.com.ot6.william.mercadolivre.validacao;

import br.com.ot6.william.mercadolivre.dto.NovoUsuarioRequest;
import br.com.ot6.william.mercadolivre.modelo.Usuario;
import br.com.ot6.william.mercadolivre.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoUsuario implements Validator {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoUsuarioRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){
            return;
        }

        NovoUsuarioRequest request = (NovoUsuarioRequest) target;

        Optional<Usuario>possivelUsuario = usuarioRepository.findByLogin(request.getLogin());
if(possivelUsuario.isPresent()){

    errors.rejectValue("login", null,
   " já existe um usuario com esse email " +request.getLogin());
}

    }
}
