package com.webgram.web;

import com.webgram.Service.CategorieServiceImpl;
import com.webgram.model.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieServiceImpl service;

    @PostMapping("/api/webgram/v1/add")
    public ResponseEntity<Categorie>ajouterCategorie(@RequestBody Categorie categorie){
        Categorie cat = service.saveCategorie(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);}

   @GetMapping("/api/webgram/v1/liste")
    public ResponseEntity<Collection<Categorie>> listeCategorie(){
        Collection<Categorie> listeCat = service.listeCategories();
        return ResponseEntity.ok(listeCat);
    }

    @PutMapping("/api/webgram/v1/update/{id}")
    public ResponseEntity<Categorie> modifierCategorie(@PathVariable long id, @RequestBody Categorie categorie){
        Categorie cat = service.updateCategorie(id, categorie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);

    }

    @GetMapping("/api/webgram/v1/deleted/{id}")
    public ResponseEntity<Object> suprimerCategorie(@PathVariable long id){
        service.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
