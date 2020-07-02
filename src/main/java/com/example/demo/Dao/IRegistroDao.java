package com.example.demo.Dao;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Registro;

public interface IRegistroDao {
	public List<Registro> readAll();
	public Registro readById(Long id);
}
