package com.cadastros.produtos.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cadastros.produtos.dao.ProductsDao;
import com.cadastros.produtos.models.Product;

@Controller
public class ProductsController {
	@Autowired
	private ProductsDao service;
	@RequestMapping("/")
	public String ViewHomePage(Model model) {
		List<Product> listProducts = service.listall();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	@RequestMapping("/prodregistration")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "prodregistration";
	}
	
	@RequestMapping(value="/save", method =RequestMethod.POST)
	public String saveProduct(Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("edit");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav; 
	}
	
}
