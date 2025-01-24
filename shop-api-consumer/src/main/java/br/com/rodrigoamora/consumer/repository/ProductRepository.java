package br.com.rodrigoamora.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoamora.consumer.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdentifier(String identifier);
	
}
