package com.pda.exo.boutique.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pda.exo.boutique.entities.Produit;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitrepository;
	
	@RequestMapping(value="/produits", method=RequestMethod.GET)
	public Page<Produit> listProduit(int page, int size){
		return produitrepository.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping(value="/chercherProduits", method=RequestMethod.GET)
	public Page<Produit> chercherProduits(String motcle, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size){
		return produitrepository.findProduits("%"+motcle+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/produits/{id}", method=RequestMethod.GET)
	public Produit getProduit(@PathVariable("id") Long id){
		return produitrepository.findOne(id);
	}

	@RequestMapping(value="/produits", method=RequestMethod.POST)
	public Produit save(@RequestBody Produit p) {
		return produitrepository.save(p);
	}
	
	@RequestMapping(value="/produits/{id}", method=RequestMethod.PUT)
	public Produit update(@RequestBody Produit p,@PathVariable Long id) {
		p.setId(id);
		return produitrepository.saveAndFlush(p);
	}
	
	@RequestMapping(value="/produits/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		produitrepository.delete(id);
	}
}
