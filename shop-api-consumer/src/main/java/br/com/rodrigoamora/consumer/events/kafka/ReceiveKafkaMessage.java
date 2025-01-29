package br.com.rodrigoamora.consumer.events.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.rodrigoamora.consumer.dto.ShopDTO;
import br.com.rodrigoamora.consumer.dto.ShopItemDTO;
import br.com.rodrigoamora.consumer.entity.Product;
import br.com.rodrigoamora.consumer.entity.ShopStatus;
import br.com.rodrigoamora.consumer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

	private static final String SHOP_TOPIC_NAME = "SHOP_TOPIC";
	private static final String SHOP_TOPIC_EVENT_NAME = "SHOP_TOPIC_EVENT";
	
	private final ProductRepository productRepository;
	private final KafkaTemplate<String, ShopDTO> kafkaTemplate;
	
	@KafkaListener(topics = SHOP_TOPIC_NAME, groupId = "group")
	public void listenShopTopic(ShopDTO shopDTO) {
		try {
			log.info("Compra recebida no tópico: {}.", shopDTO.getIdentifier());
			boolean success = true;
			
			for (ShopItemDTO item : shopDTO.getItems()) {
				Product product = this.productRepository.findByIdentifier(item.getProductIdentifier());
				if (!this.isValidShop(item, product)) {
					this.shopError(shopDTO);
					success = false;
					break;
				}
			}
			
			if (success) {
				this.shopSuccess(shopDTO);
			}
		} catch(Exception e) {
			log.error("Erro no processamento da compra {}", shopDTO.getIdentifier());
		}
	}
	
	// valida se a compra possui algum erro
	private boolean isValidShop(ShopItemDTO item, Product product) {
		return product != null && product.getAmount() >= item.getAmount();
	}
	
	// Envia uma mensagem para o Kafka indicando erro na compra
	private void shopError(ShopDTO shopDTO) {
		log.info("Erro no processamento da compra {}.", shopDTO.getIdentifier());
		shopDTO.setStatus(ShopStatus.ERROR.toString());
		this.kafkaTemplate.send(SHOP_TOPIC_EVENT_NAME, shopDTO);
	}
	
	// Envia uma mensagem para o Kafka indicando sucesso na compra
	private void shopSuccess(ShopDTO shopDTO) {
		log.info("Compra {} efetuada com sucesso.", shopDTO.getIdentifier());
		shopDTO.setStatus(ShopStatus.SUCCESS.toString());
		this.kafkaTemplate.send(SHOP_TOPIC_EVENT_NAME, shopDTO);
	}
	
}
