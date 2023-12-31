package com.back.end.shoppingapi.converter;

import com.back.end.shoppingapi.dto.ItemDTO;
import com.back.end.shoppingapi.dto.ShopDTO;
import com.back.end.shoppingapi.model.Item;
import com.back.end.shoppingapi.model.Shop;

import java.util.stream.Collectors;

public class DTOConverter {
    public static ItemDTO convert(Item item){
        ItemDTO	itemDTO	=	new	ItemDTO();
        itemDTO.setProductIdentifier(
                item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return	itemDTO;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO	shopDTO	=	new	ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
