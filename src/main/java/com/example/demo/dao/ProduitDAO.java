package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Produit;

@RepositoryRestResource
public interface ProduitDAO extends JpaRepository<Produit, Long> {

}
