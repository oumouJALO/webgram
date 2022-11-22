package com.webgram.dao;


import com.webgram.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProduitRepository  extends JpaRepository<Produit, Long> {

}
