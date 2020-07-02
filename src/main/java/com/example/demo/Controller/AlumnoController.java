package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.IRegistroDao;
import com.example.demo.entity.Registro;


@RestController
public class AlumnoController {
	@Autowired
	private IRegistroDao iRegistroDao;
	@GetMapping("/listar")
	public List<Registro> listar(){
		return iRegistroDao.readAll();
	}
	@GetMapping("/listar/{id}")
	public Registro  registrar(@PathVariable Long id){
		return iRegistroDao.readById(id);
	}
}
