package com.begers.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.begers.northwind.entities.concoretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
}
