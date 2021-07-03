package com.begers.northwind.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.begers.northwind.business.abstracts.ProductService;
import com.begers.northwind.core.utilities.result.DataResult;
import com.begers.northwind.core.utilities.result.Result;
import com.begers.northwind.core.utilities.result.SuccessDataResult;
import com.begers.northwind.core.utilities.result.SuccessResult;
import com.begers.northwind.dataAccess.abstracts.ProductDao;
import com.begers.northwind.entities.concoretes.Product;
import com.begers.northwind.entities.dtos.ProductWithCategoryDto;

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
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "Data Listelendi.");
	}


	@Override
	public Result add(Product product) {
		//business code
		this.productDao.save(product);
		return new SuccessResult("Urun eklendi");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		//business code
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Data Listelendi.");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business code
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Data Listelendi.");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		//business code
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryId), "Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Sayfasal data getirildi");
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Siralandi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data Listelendi");
	}

}
