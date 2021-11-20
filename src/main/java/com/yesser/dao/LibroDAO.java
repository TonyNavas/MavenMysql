package com.yesser.dao;

import com.yesser.modelo.Libro;

import java.util.List;

public interface LibroDAO {
    public int delete(int id);
    public List<Libro> findAll();
    public int insert(Libro libro);
    public int update(Libro libro);
}
