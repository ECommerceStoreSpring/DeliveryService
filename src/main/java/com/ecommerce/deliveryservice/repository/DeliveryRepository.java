package com.ecommerce.deliveryservice.repository;

import com.ecommerce.deliveryservice.model.DeliveryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<DeliveryDetails, String>{

}
