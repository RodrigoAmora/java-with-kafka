package br.com.rodrigoamora.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoamora.producer.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	public Shop findByIdentifier(String identifier);
	
}
