package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.attribute.standard.Severity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.capgemini.model.NGO;
import com.capgemini.model.TrainingCourse;
import com.capgemini.repository.INGORepository;
import com.capgemini.service.INGOService;

@SpringBootTest
public class NGOControllerTests {

	@MockBean
	private INGORepository repository;

	@Autowired
	private NGOController controller;
	@Autowired
	private INGOService service;

	/**
	 * Testcase for Get All NGOS By "Motive" from database
	 */
	@Test
	public void testGetNgoByMotive() {
		String motive = "help";
		when(repository.findByNgoMotive(motive))
				.thenReturn(Stream
						.of(new NGO(3, "asd", "asd", "asd", "asd", 100.2, 10, "asd", new TrainingCourse()))
						.collect(Collectors.toList()));
		assertEquals(1, service.viewNGOByMotive(motive).size());
	}

	/**
	 * Testcase for Get All NGOS from database
	 */
	@Test
	public void viewAllTest() {
		when(repository.findAll()).thenReturn(Stream.of(
				new NGO(3, "asd", "asd", "asd", "asd", 100.2, 10, "asd", new TrainingCourse()))
				.collect(Collectors.toList()));

		assertEquals(1,service.viewAllNGO().size());
	}
	
	/**
	 * Testcase for Get All NGOS By "Location" from database 
	 */
	@Test
	public void testGetNgoByLocation() {
		String location = "mumbai";
		when(repository.findByNgoLocation(location))
				.thenReturn(Stream
						.of(new NGO(3, "asd", "asd", "asd", "asd", 100.2, 10, "asd", new TrainingCourse()))
						.collect(Collectors.toList()));
		assertEquals(1, service.viewNGOByLocation(location).size());
	}
	/**
	 * Testcase for save NGO in database 
	 */
	@Test
	public void addNgoTest() {
		NGO ngo = new NGO(3, "asd", "asd", "asd", "asd", 100.2, 10, "asd", new TrainingCourse());
		when(repository.save(ngo)).thenReturn(ngo);

		assertEquals(ngo, service.addNGO(ngo));
	}
	/**
	 * Testcase for if Wrong NGO is Save in database 
	 */
	@Test
	public void testNotSaveNgo() {
		NGO ngo = new NGO(3, "asd", "asd", "asd", "asd", 100.2, 10, "asd", null);
		when(repository.save(ngo)).thenReturn(ngo);
		assertNotEquals(1, controller.addngo(ngo));

	}
	/**
	 * Testcase for if Wrong Location entered
	 */
	@Test
	public void testnNotGetNgoByLocation() {
		String location = "mumbai";
		when(repository.findByNgoLocation(location))
				.thenReturn((List<NGO>) Stream.of(new NGO()).collect(Collectors.toList()));
		assertNotEquals(1, controller.viewNGOByLocation(location));

	}
	/**
	 * Testcase for retrive the wrong All NGOS from database. 
	 */
	@Test
	public void testNotGetAllNGO() {

		when(repository.findAll()).thenReturn((List<NGO>) Stream.of(new NGO()).collect(Collectors.toList()));
		assertNotEquals(1, controller.getallngos());

	}
	/**
	 * Testcase for if Wrong Motive entered
	 */
	@Test
	public void testNotGetNgoByMotive() {
		String motive = "help";
		when(repository.findByNgoMotive(motive))
				.thenReturn((List<NGO>) Stream.of(new NGO()).collect(Collectors.toList()));
		assertNotEquals(1, controller.viewNGOByMotive(motive));

	}

//			@Test
//			public void testGetNgoById() {
//				Integer id= 1;
//				when(service.viewNGO(id)).thenReturn((NGO)Stream.of(new NGO()).collect(Collectors.toList()));
//				assertEquals(controller.getNgoByngoId(1),service.viewNGO(id));
//				
//			}
//			@Test
//			public void testDeleteNgo	() {
//				Integer id= 1;
//				NGO ngo= new NGO(3,"asd","asd","asd","asd",100.2,10,"asd", null);
//				service.deleteNGO(id);
//				verify(repository, times(1)).deleteById(id);
//				assertEquals(controller.deleteNgoByNgoId(id),controller.deleteNgoByNgoId(id));
//				
//			}
//			@Test
//			public void testGetAllNGOById() {
//				HttpStatus expected = controller.getNgoByngoId(2).getStatusCode();
//				HttpStatus actual = HttpStatus.OK;
//				
//				assertEquals(expected, actual);
//				
//			}

}
