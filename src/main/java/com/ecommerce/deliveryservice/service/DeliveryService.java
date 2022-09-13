package com.ecommerce.deliveryservice.service;

import java.util.List;

import com.ecommerce.deliveryservice.model.DeliveryDetails;

public interface DeliveryService {
	
	public List<DeliveryDetails> listDetials();
	public DeliveryDetails AddDetials(DeliveryDetails deliveryDetails);

}
