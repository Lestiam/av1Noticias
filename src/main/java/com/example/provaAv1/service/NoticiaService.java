package com.example.provaAv1.service;

import com.example.provaAv1.model.NoticiaEntity;
import com.example.provaAv1.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;
    public String buscarNoticia() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            NoticiaEntity noticiaEntity = new NoticiaEntity();

            noticiaEntity.setResponseBody(responseBody);
            noticiaRepository.save(noticiaEntity);
            return responseBody;
        } else {
            return "Nãoo foi possível buscar as notícias";
        }
    }
    public NoticiaEntity inserir(NoticiaEntity noticia) {return noticiaRepository.save(noticia);}

    public String buscarNoticiasRelease() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            NoticiaEntity noticiaEntity = new NoticiaEntity();
            noticiaEntity.setResponseBody(responseBody);

            noticiaRepository.save(noticiaEntity);

            return responseBody;
        } else {
            return "Nãoo foi possível buscar as notícias e as releases";
        }
    }

    public void inserirNoticia(NoticiaEntity noticia) {
        noticiaRepository.save(noticia);
    }
}
