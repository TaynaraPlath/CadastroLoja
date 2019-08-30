package com.cadastros.produtos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastros.produtos.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
