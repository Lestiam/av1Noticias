package com.example.provaAv1.controller;

import com.example.provaAv1.model.NoticiaEntity;
import com.example.provaAv1.model.ReleaseEntity;
import com.example.provaAv1.service.NoticiaService;
import com.example.provaAv1.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class ControllerAmbos {
    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private ReleaseService releaseService;

    @GetMapping()
    public String BuscarNoticias() {return noticiaService.buscarNoticia();}

    @GetMapping("/releases")
    public String BuscarReleases() {return releaseService.buscarRelease();}

    @GetMapping("/noticiasreleases")
    public String BuscarNoticiasReleases() {return noticiaService.buscarNoticiasRelease();}

    @PostMapping ("/releases")
    public ReleaseEntity inserir(@RequestBody ReleaseEntity release){
        return releaseService.inserir(release);
    }

    @PostMapping("/noticias")
    public NoticiaEntity inserir(@RequestBody NoticiaEntity noticia) {return noticiaService.inserir(noticia);}

    @GetMapping("/nova")
    public String novaNoticia(){
        return noticiaService.buscarNoticiasRelease();
    }
}