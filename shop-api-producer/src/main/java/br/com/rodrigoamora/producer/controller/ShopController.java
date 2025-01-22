package br.com.rodrigoamora.producer.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoamora.producer.dto.ShopDTO;
import br.com.rodrigoamora.producer.entity.Shop;
import br.com.rodrigoamora.producer.entity.ShopItem;
import br.com.rodrigoamora.producer.repository.ShopRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

	private final ShopRepository shopRepository;
	
	@GetMapping
	public List<ShopDTO> getShop() {
		return this.shopRepository.findAll()
							 	  .stream()
							 	  .map(shop -> ShopDTO.convert(shop))
							 	  .collect(Collectors.toList());
	}
	
	@PostMapping
	public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
		shopDTO.setIdentifier(UUID.randomUUID().toString());
		shopDTO.setDateShop(LocalDate.now());
		shopDTO.setStatus("PENDING");
		
		Shop shop = Shop.convert(shopDTO);
		for (ShopItem shopItem : shop.getItems()) {
			shopItem.setShop(shop);
		}
		
		var shopSaved = this.shopRepository.save(shop);
		
		return ShopDTO.convert(shopSaved);
	}
}
