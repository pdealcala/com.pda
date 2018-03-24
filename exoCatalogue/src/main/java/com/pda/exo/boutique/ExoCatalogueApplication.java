package com.pda.exo.boutique;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pda.exo.boutique.dao.CategorieRepository;
import com.pda.exo.boutique.dao.ProduitRepository;
import com.pda.exo.boutique.entities.Categorie;
import com.pda.exo.boutique.entities.Produit;

@SpringBootApplication
public class ExoCatalogueApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitrepository;
	@Autowired
	private CategorieRepository categorierepository;

	public static void main(String[] args) {
		SpringApplication.run(ExoCatalogueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		/* CATEGORIES */
		int nb = 5;
		for (int i = 1; i < nb; i++) {
			int ref = i;
			categorierepository.save(new Categorie("CATEGORIE" + String.valueOf(ref)));
		}

		List<Categorie> cats = categorierepository.findAll();
		cats.forEach(p -> System.out.println(p.getLibelle()));

		/* PRODUITS */
		nb = 100;
		for (int i = 0; i < nb; i++) {
			int ref = (int) ((Math.random()) * 100 + i);
			produitrepository.save(new Produit(String.valueOf(ref), 100 + i, 100 + i));
		}

		List<Produit> prods = produitrepository.findAll();
		prods.forEach(p -> System.out.println(p.getDesignation()));
	}
}
