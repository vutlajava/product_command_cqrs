package com.cmd.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.dto.ProductEvent;
import com.cmd.entity.Product;
import com.cmd.service.ProductCommandService;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	
	@Autowired
	private ProductCommandService productCommandService;
	
	
	@PostMapping( value="", consumes= { MediaType.APPLICATION_JSON_VALUE,
			                             MediaType.APPLICATION_XML_VALUE  }  
	          )
	public Product create(@RequestBody ProductEvent product) {

		System.out.println("Hello");
		return productCommandService.createProduct(product);
		
		
		
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable("id") Long id, @RequestBody ProductEvent product) {
		
		
		return productCommandService.updateProduct(id, product);
		
		
		
	}

}
