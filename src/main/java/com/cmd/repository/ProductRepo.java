package com.cmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmd.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
