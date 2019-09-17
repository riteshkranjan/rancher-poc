package com.rancher.BeerApplication.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rancher.BeerApplication.BeerException;
import com.rancher.BeerApplication.entity.Beer;

public interface BeerService {
	
	public List<Beer> getAllBeers();
	
	public Beer getBeerByID(String brewery_id) throws BeerException ;
	
	public void addBeer(Beer b);
	
	public void updateBeer(String brewery_id, Beer b) throws BeerException ;
	
	public void deleteBeer(String brewery_id) throws BeerException ;

	public void bulkAdd(int size);

	public void bulkDetele(int size);

	public Page<Beer> findPaginated(Pageable pageable);

	public Page<Beer> findPaginated(Pageable pageable, String string);

}
