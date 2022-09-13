package com.ecommerce.deliveryservice.serviceimpl;

import java.util.List;

import com.ecommerce.deliveryservice.model.DeliveryDetails;
import com.ecommerce.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.deliveryservice.repository.DeliveryRepository;

@Component
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Override
	public List<DeliveryDetails> listDetials() {
		
		return deliveryRepository.findAll();
	}

	@Override
	public DeliveryDetails AddDetials(DeliveryDetails deliveryDetails) {
		
		return deliveryRepository.save(deliveryDetails);
	}

}
