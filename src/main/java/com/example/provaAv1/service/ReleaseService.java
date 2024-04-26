package com.example.provaAv1.service;

import com.example.provaAv1.model.ReleaseEntity;
import com.example.provaAv1.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public String buscarRelease() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            ReleaseEntity releaseEntity = new ReleaseEntity();

            releaseEntity.setResponseBody(responseBody);
            releaseRepository.save(releaseEntity);
            return responseBody;
        } else {
            return "Não foi possível buscar as releases";
        }
    }

    public ReleaseEntity inserir(ReleaseEntity realease) {return releaseRepository.save(realease);}
}