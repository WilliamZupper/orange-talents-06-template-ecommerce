package br.com.ot6.william.mercadolivre.validacao;

import br.com.ot6.william.mercadolivre.dto.NovoProdutoRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class ProibeCaracteristicasComNomeIgualValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz){
        return NovoProdutoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors error){
        if(error.hasErrors()){
            return;
        }

        NovoProdutoRequest request = (NovoProdutoRequest) target;
        Set<String>nomesIguais=request.buscaCaracteristicasIguais();
        if(!nomesIguais.isEmpty()){
            error.rejectValue("caracteristicas", null, "Você tem caracteristicas iguais " + nomesIguais);

        }
    }
}
