package com.packt.webstore.service;

import java.util.List;

public interface AbstractService<T, ID> {
	
	public void add(T t);

	public void update(T t);

	public List<T> findAll();

	public T findOne(ID obj);

}
