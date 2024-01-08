package com.example.demo.web.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProduitDAO;
import com.example.demo.entities.Produit;
import com.example.demo.web.exceptions.ProduitNotFoundException;

@RestController
public class ProduitController {
	@Autowired
	ProduitDAO produitDAO;
	
    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/produits")
    public List<Produit> listeDesProduits(){

        List<Produit> products = produitDAO.findAll();
        if(products.isEmpty()) 
        	throw new ProduitNotFoundException("Aucun produit n'est disponible à la vente");
        return products;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/produits/{id}")
    public Produit recupererUnProduit(@PathVariable Long id) {

        Produit product = produitDAO.findById(id).get();

        if(product==null)
        	throw new ProduitNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
        return product;
    }
}
