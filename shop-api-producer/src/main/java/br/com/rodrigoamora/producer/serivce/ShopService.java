package br.com.rodrigoamora.producer.serivce;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.rodrigoamora.producer.dto.ShopDTO;
import br.com.rodrigoamora.producer.entity.Shop;
import br.com.rodrigoamora.producer.entity.ShopItem;
import br.com.rodrigoamora.producer.entity.ShopStatus;
import br.com.rodrigoamora.producer.events.kafka.KafkaClient;
import br.com.rodrigoamora.producer.repository.ShopRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ShopService {

	private final ShopRepository shopRepository;
	private final KafkaClient kafkaClient;
	
	public List<ShopDTO> findAll() {
		return this.shopRepository.findAll()
				 				  .stream()
				 				  .map(shop -> ShopDTO.convert(shop))
				 				  .collect(Collectors.toList());
	}
	
	public ShopDTO findShopByID(@PathVariable(name = "id") Long id) {
		Optional<Shop> shopFound = this.shopRepository.findById(id);
		if (shopFound.isPresent()) {
			return ShopDTO.convert(shopFound.get());
		}
		return null;
	}
	
	public ShopDTO saveShop(ShopDTO shopDTO) {
		String uuid = UUID.randomUUID().toString();
		
		shopDTO.setIdentifier(uuid);
		shopDTO.setDateShop(LocalDate.now());
		shopDTO.setStatus(ShopStatus.PENDING.toString());
	
		Shop shop = Shop.convert(shopDTO);
		for (ShopItem shopItem : shop.getItems()) {
			shopItem.setShop(shop);
		}
		shop = this.shopRepository.save(shop);
		
		shopDTO = ShopDTO.convert(shop);
		this.kafkaClient.sendMessage(shopDTO);
		
		return shopDTO;
	}
	
}
