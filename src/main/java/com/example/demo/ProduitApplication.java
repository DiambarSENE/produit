package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.ProduitDAO;
import com.example.demo.entities.Produit;

@SpringBootApplication
public class ProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProduitDAO produitDAO, RepositoryRestConfiguration rrc) {
		rrc.exposeIdsFor(Produit.class);
		return products -> {
			produitDAO.save(new Produit(null, "Bougie fonctionnant au feu","bougie qui fonctionne comme une ampoule mais sans électricité !","https://m.media-amazon.com/images/I/71iazwPQ2sL._AC_UL480_QL65_.jpg", 22.0));
			produitDAO.save(new Produit(null, "Chaise pour s'assoire", "Chaise rare avec non pas 1 ni 2 mais 3 pieds",
					"https://m.media-amazon.com/images/I/719hw3zHL2L._AC_SY879_.jpg", 95.0));
			produitDAO.save(new Produit(null, "Cheval pour nains",
					"Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains",
					"https://m.media-amazon.com/images/I/81iAbNbW6vL._AC_UL480_QL65_.jpg", 360.0));
			produitDAO.save(new Produit(null, "Coq of steel, le superman des volailles", "Ne passe pas au four",
					"https://m.media-amazon.com/images/I/81YYCgs9WPL._AC_UL480_QL65_.jpg", 620.0));
			produitDAO.save(new Produit(null, "Flacon à frotter avec un génie dedans",
					"Vous donne droit à l'équivalent de 3/0 voeux",
					"https://images-eu.ssl-images-amazon.com/images/I/71FLw9gSpOS.__AC_SX300_SY300_QL70_ML2_.jpg",
					1200.0));
			produitDAO.save(new Produit(null, "Horloge quantique",
					"Donne l'heure, les minutes et même les secondes. Ne fait pas de café",
					"https://m.media-amazon.com/images/I/61OZpX-XrRL._AC_SX679_.jpg", 180.0));
			produitDAO.save(new Produit(null, "Table d'opération pour Hamsters",
					"Pour réaliser vos opérations chirugicales sur votre Hamster!",
					"https://m.media-amazon.com/images/I/51owjAY6SXL._AC_UL480_QL65_.jpg", 210.0));
			produitDAO.save(new Produit(null, "Vase ayant appartenu a Zeus", "Risque de choc électrique",
					"https://images-eu.ssl-images-amazon.com/images/I/41O5QPr5SGL.__AC_SX300_SY300_QL70_ML2_.jpg",
					730.0));

			produitDAO.findAll().forEach(System.out::println);
		};
	}

}
