package com.begers.northwind.business.abstracts;

import java.util.List;

import com.begers.northwind.entities.concoretes.Product;

public interface ProductService {
	List<Product> getAll();
}
