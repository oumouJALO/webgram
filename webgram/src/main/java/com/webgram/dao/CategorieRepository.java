package com.webgram.dao;


import com.webgram.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CategorieRepository  extends JpaRepository<Categorie,Long> {
    Categorie findByNom(@Param("nom") String nom);
    @Query("select c from Categorie c where c.isDeleted = false")
    Collection<Categorie> getAllCatgorie();
}
