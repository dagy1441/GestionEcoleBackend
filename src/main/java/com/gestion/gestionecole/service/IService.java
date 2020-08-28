package com.gestion.gestionecole.service;

import java.io.Serializable;
import java.util.List;

public interface IService <T, ID extends Serializable> {
	
	public T save(final T entity);

    public T update(final T entity);

    public void delete(final T entity);

    public List<T> readAll();

    public T readOne(final ID id);

    public Integer count();
}
