package com.example.demo.serviceImp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Dao.IRegistroDao;
import com.example.demo.entity.Alumno;
import com.example.demo.entity.Registro;

@Service
public class AlumnoServiceImp implements IRegistroDao{
	@Autowired
	private RestTemplate clientesRestTemplate;
	@Override
	public List<Registro> readAll() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos =Arrays.asList(clientesRestTemplate.getForObject("http://localhost:9001/list", Alumno[].class));
		return alumnos.stream().map(a->new Registro(a)).collect(Collectors.toList());
	}

	@Override
	public Registro readById(Long id) {
		// TODO Auto-generated method stub
		Map<String, String> datos = new HashMap<String, String >();
		datos.put("id",id.toString());
		Alumno alumno =clientesRestTemplate.getForObject("http://localhost:9001/list/{id}", Alumno.class, datos);
		return new Registro(alumno);
	}

}
