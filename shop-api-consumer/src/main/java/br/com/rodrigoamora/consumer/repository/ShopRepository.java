package br.com.rodrigoamora.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoamora.consumer.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	Optional<Shop> findByIdentifier(String identifier);
	
}
