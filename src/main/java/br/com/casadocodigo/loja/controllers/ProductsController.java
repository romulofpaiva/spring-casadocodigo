package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;

@Controller
@Transactional
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/produtos/form")
	public String form() {
		return "products/form";
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST )
	public String save(Product product) {
		productDAO.save(product);
		return "products/form";
	}
}