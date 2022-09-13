package com.ecommerce.deliveryservice.controller;

import java.util.List;

import com.ecommerce.deliveryservice.model.DeliveryDetails;
import com.ecommerce.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/delivery")
@CrossOrigin(origins = "*")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;

	@GetMapping(value = "/check")
	public String check(){
		return "Server is Running At Port 8060";
	}

	@GetMapping(value="/allDeliveries")
	public ResponseEntity<Object> getAllDelivery() {
		try {
			List<DeliveryDetails> deliveries = deliveryService.listDetials();
			if (!deliveries.isEmpty()) {
				return new ResponseEntity<>(deliveries, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@PostMapping(value = "/addDelivery")
	public ResponseEntity<DeliveryDetails> addItem(@RequestBody DeliveryDetails deliveryDetails) {
		try {
			DeliveryDetails AddedDetails = deliveryService.AddDetials(deliveryDetails);
			return new ResponseEntity<>(AddedDetails, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
