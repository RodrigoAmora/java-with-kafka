package br.com.rodrigoamora.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoamora.consumer.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
