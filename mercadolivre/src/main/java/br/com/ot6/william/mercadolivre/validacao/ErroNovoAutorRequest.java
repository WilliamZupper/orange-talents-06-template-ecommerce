package br.com.ot6.william.mercadolivre.validacao;

public class ErroNovoAutorRequest {

    private String campo;
    private String erro;


    public ErroNovoAutorRequest(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
