package br.com.ot6.william.mercadolivre.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class NovasImagensRequest {

     @Size(min= 1)
     @NotNull
    private List<MultipartFile>imagens = new ArrayList<>();

    public NovasImagensRequest(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }

    public List<MultipartFile> getImagens() {

        return imagens;
    }
}
