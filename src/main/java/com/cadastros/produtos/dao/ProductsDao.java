package com.cadastros.produtos.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cadastros.produtos.models.Product;
import com.cadastros.produtos.repository.ProductRepository;

@Service
@Transactional
public class ProductsDao {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> listall(){
		return repository.findAll();
	}
	
	public Product get(int id) {
		return repository.findById(id).get();
	}
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
