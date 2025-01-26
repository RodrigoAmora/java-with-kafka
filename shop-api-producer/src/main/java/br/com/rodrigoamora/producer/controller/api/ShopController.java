package br.com.rodrigoamora.producer.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoamora.producer.dto.ShopDTO;
import br.com.rodrigoamora.producer.serivce.ShopService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

	private final ShopService shopService;
	
	@GetMapping
	public List<ShopDTO> findAll() {
		return this.shopService.findAll();
	}
	
	@GetMapping(value = { "/{id}" })
	public ResponseEntity<ShopDTO> findShopByID(@PathVariable(name = "id") Long id) {
		ShopDTO shopFound = this.shopService.findShopByID(id);
		if (shopFound != null) {
			return ResponseEntity.ok(shopFound); 
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
		return this.shopService.saveShop(shopDTO);
	}
	
}
