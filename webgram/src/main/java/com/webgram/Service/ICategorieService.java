package com.webgram.Service;

import com.webgram.model.Categorie;

import java.util.Collection;

public interface ICategorieService {
    Categorie saveCategorie (Categorie cat);
    Collection<Categorie> listeCategories();
    Categorie updateCategorie(Long id,Categorie Cat);
    Categorie deleteCategorie(long id);
}
