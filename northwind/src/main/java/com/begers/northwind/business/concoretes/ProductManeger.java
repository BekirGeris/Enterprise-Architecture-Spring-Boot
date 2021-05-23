package com.begers.northwind.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begers.northwind.business.abstracts.ProductService;
import com.begers.northwind.core.utilities.result.DataResult;
import com.begers.northwind.core.utilities.result.Result;
import com.begers.northwind.core.utilities.result.SuccessDataResult;
import com.begers.northwind.core.utilities.result.SuccessResult;
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
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi.");
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Urun eklendi");
	}

}
