package br.com.rodrigoamora.consumer.dto;

import br.com.rodrigoamora.consumer.entity.ShopItem;
import lombok.Data;

@Data
public class ShopItemDTO {

	private String productIdentifier;
	private Integer amount;
	private Float price;
	
	public static ShopItemDTO convert(ShopItem shopItem) {
		ShopItemDTO shopItemDTO = new ShopItemDTO();
		shopItemDTO.setProductIdentifier(shopItem.getProductIdentifier());
		shopItemDTO.setAmount(shopItem.getAmount());
		shopItemDTO.setPrice(shopItem.getPrice());
		return shopItemDTO;
	}
}
