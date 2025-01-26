package br.com.rodrigoamora.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoamora.consumer.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdentifier(String identifier);
	
}
