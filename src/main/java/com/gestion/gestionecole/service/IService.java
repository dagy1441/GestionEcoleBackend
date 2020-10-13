package com.gestion.gestionecole.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IService <T, ID extends Serializable> {
	
	public T save(final T entity);

    public T update(final T entity);

    public void delete(final T entity);

    public List<T> readAll();

    public Optional<T> readOne(final ID id);

    public Long count();
}
