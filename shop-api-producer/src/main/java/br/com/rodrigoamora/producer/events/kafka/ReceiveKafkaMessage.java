package br.com.rodrigoamora.producer.events.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.rodrigoamora.producer.dto.ShopDTO;
import br.com.rodrigoamora.producer.entity.Shop;
import br.com.rodrigoamora.producer.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

	private final ShopRepository shopRepository;
	private static final String SHOP_TOPIC_EVENT_NAME = "SHOP_TOPIC_EVENT";
	
	@KafkaListener(topics = SHOP_TOPIC_EVENT_NAME, groupId = "group")
	public void listenShopEvents(ShopDTO shopDTO) {
		try {
			log.info("Status da compra recebida no tópico: {}.", shopDTO.getIdentifier());
			Shop shop = this.shopRepository.findByIdentifier(shopDTO.getIdentifier());
			shop.setStatus(shopDTO.getStatus());
			this.shopRepository.save(shop);
		} catch(Exception e) {
			log.error("Erro no processamento da compra {}", shopDTO.getIdentifier());
		}
	}
	
}
