package com.webgram.Service;
import com.webgram.dao.CategorieRepository;
import com.webgram.model.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
 @RequiredArgsConstructor

public class CategorieServiceImpl implements ICategorieService{
     private final CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie cat) {
        Categorie existing = categorieRepository.findByNom(cat.getNom());
        if (existing !=null)
            throw new RuntimeException("une categorie avec le meme nom existe deja");
        return categorieRepository.save(cat);
    }

    @Override
    public Collection<Categorie> listeCategories() {
        return categorieRepository.getAllCatgorie();
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie Cat) {
        Categorie existing =getCategorie(id);
        existing.setNom(Cat.getNom());
        existing.setDescription(Cat.getDescription());
        return categorieRepository.save(existing);
    }

    @Override
    public Categorie deleteCategorie(long id) {
        Categorie existing = getCategorie(id);
        existing.setDeleted(true);
        categorieRepository.save(existing);
        return existing;

    }

     private Categorie getCategorie(long id){
         return categorieRepository.findById(id).orElseThrow(()->new RuntimeException("la catégorie recherché n'existe pas"));
     }

 }
