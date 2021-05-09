package com.begers.northwind.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begers.northwind.business.abstracts.ProductService;
import com.begers.northwind.dataAccess.abstracts.ProductDao;
import com.begers.northwind.entities.concoretes.Product;

@Service
public class ProductManeger implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManeger(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public List<Product> getAll() {
		return this.productDao.findAll();
	}

}
