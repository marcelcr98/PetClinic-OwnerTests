package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);
	
	@Autowired
	private OwnerService ownerService;


	@Test
	public void testCreateOwner() {
		String nombre = "Marcelo";
		String apellido = "Cuellar";
		String calle = "Calle Los Lirios";
		String ciudad = "Lima";
		String telefono = "910127101";
		Owner owner = new Owner(apellido, nombre, calle, ciudad, telefono); 
		Owner o = ownerService.crear(owner);
		logger.info("->" + o.getLast_name() + " " + o.getFirst_name());
	}
	
	@Test
	public void testFindById() {
		String name = "Jeff";
		Owner o = ownerService.buscarNombre(name);
		logger.warn("->" + o.getFirst_name() + " " + o.getLast_name());
	}
	
	
	
	@Test
	public void Update() {
		
		String first_name = "Maria";
		String last_name = "Escobito";
		String address = "345 Maple St.";
		String city = "Madison";
		String telephone = "6085557683";
		
		Owner owner = new Owner(first_name,last_name, address, city, telephone);
		Owner o = ownerService.crear(owner);
		
		logger.info("->"+o.getLast_name());
		
		String new_name = "Andres";
		String new_last = "Gomez";
		String new_direc = "Calle Cascanueces";
		String new_city = "Lima";
		String telefono = "994747154";
		
		o.setFirst_name(new_name);
		o.setLast_name(new_last);
		o.setAddress(new_direc);
		o.setCity(new_city);
		o.setTelephone(telefono);
		
		Owner own = ownerService.update(o);
		
		logger.warn("New ->" + own.getFirst_name() + " - " + own.getLast_name() + " - " 
				+ own.getCity() + " - " + own.getAddress() + " - " + own.getTelephone());
	}
	
	@Test 
	public void Delete(){
		
		String last_name = "Estaban";
		String first_name = "Carlos";
		Owner o = new Owner(last_name, first_name, null, null, null);
		o = ownerService.crear(o);
		ownerService.delete(o.getId());
		logger.warn("Owner removed");
	}
	/*
	*/
	
}
