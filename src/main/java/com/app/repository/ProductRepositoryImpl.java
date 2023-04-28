package com.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from productdata", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public int save(Product transientProduct) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO productdata (name, details, price,discount) VALUES(?,?,?,?)", new Object[] { transientProduct.getName(), transientProduct.getDetails(), transientProduct.getPrice(),transientProduct.getDiscount() });
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		try {
		      Product product = jdbcTemplate.queryForObject("SELECT * FROM productdata WHERE id=?",
		          BeanPropertyRowMapper.newInstance(Product.class), id);

		      return true;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return false;
		    }
	}

	@Override
	public void deleteById(Integer id) {
		jdbcTemplate.update("DELETE FROM productdata WHERE id=?", id);

	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		try {
		      Product product = jdbcTemplate.queryForObject("SELECT * FROM productdata WHERE id=?",
		          BeanPropertyRowMapper.newInstance(Product.class), id);

		      return product;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		    }
	}
	@Override
	public int update(Product transientProduct) {
	    return jdbcTemplate.update("UPDATE productdata SET name=?, details=?, price=?, discount=? WHERE id=?",
	        new Object[] { transientProduct.getName(), transientProduct.getDetails(), transientProduct.getPrice(),transientProduct.getDiscount(),transientProduct.getId() });
	  }

}
