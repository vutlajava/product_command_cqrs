package com.cmd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cmd.dto.ProductEvent;
import com.cmd.entity.Product;
import com.cmd.repository.ProductRepo;

@Service
public class ProductCommandService {
	
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private KafkaTemplate<String,ProductEvent> kafkaTemplate;
	
	
	public Product createProduct(ProductEvent product) {
		
		Product productDO = productRepo.save(product.getProduct());
		ProductEvent event = new ProductEvent("CreateProduct",productDO);
		kafkaTemplate.send("product-event-topic",event);
		
		return productDO;
	}
	
	public Product updateProduct(Long id, ProductEvent product) {
		
		
		Product existingProduct = productRepo.findById(id).get();
		
		existingProduct.setName(product.getProduct().getName());
		existingProduct.setDescription(product.getProduct().getDescription());
		existingProduct.setPrice(product.getProduct().getPrice());
		Product productDO =productRepo.save(existingProduct);
		ProductEvent event = new ProductEvent("UpdateProduct",productDO);
		kafkaTemplate.send("product-event-topic",event);
		
		return productDO;
		
	}
	

}
