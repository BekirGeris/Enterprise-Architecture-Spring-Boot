package com.begers.northwind.business.abstracts;

import java.util.List;

import com.begers.northwind.core.utilities.result.DataResult;
import com.begers.northwind.core.utilities.result.Result;
import com.begers.northwind.entities.concoretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
}
