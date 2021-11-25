package com.capgemini.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.NGO;
import com.capgemini.service.NGOService;

@RestController
public class NGOController implements INGOController {

	@Autowired
	private NGOService ingoService;

	private static final Logger LOG = LoggerFactory.getLogger(NGOController.class);

	/*
	 * API requests for Retrieve All NGOs from Database //
	 */
//	http://localhost:8082/getallngo
	@GetMapping("/getallngo")
	public ResponseEntity<List<NGO>> getallngos() {
		LOG.info("Controller getallngos"); // in normal block
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This NGO avaliable in Database.");
		ResponseEntity<List<NGO>> response = new ResponseEntity<List<NGO>>(ingoService.viewAllNGO(), headers,
				HttpStatus.CREATED);
		return response;
	}

//----------------------------------------------------------------------------------------------------------------------------------------

	/*
	 * API requests for Adding NGO in Database
	 */
//	http://localhost:8082/addngo
	@PostMapping("/addngo")
	public ResponseEntity<NGO> addngo(@RequestBody NGO ngo) {
		LOG.info("Controller addngo");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO added successfully.");
		ResponseEntity<NGO> response = new ResponseEntity<NGO>(ingoService.addNGO(ngo), headers, HttpStatus.CREATED);
		return response;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------

	/*
	 * API requests for Update in the Existing NGOs from Database //
	 */
//	http://localhost:8082/updatengo
	@PutMapping("/updatengo")
	public ResponseEntity<NGO> updateNgo(@RequestBody NGO ngo) {
		LOG.info("Controller updateNgo");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO Updated successfully.");
		ResponseEntity<NGO> response = new ResponseEntity<NGO>(ingoService.updateNGO(ngo), headers, HttpStatus.CREATED);
		return response;
	}

//----------------------------------------------------------------------------------------------------------------------------------------

	/*
	 *   API requests for Delete NGOs from Database By Using NGOID//
	 */
//	http://localhost:8082/deletengobyngoid/ngoid
	@DeleteMapping("/deletengobyngoid/{ngoid}")
	public ResponseEntity<NGO> deleteNgoByNgoId(@PathVariable(name = "ngoid") Integer ngoId) {
		LOG.info("Controller deleteNgoByNgoId");
		NGO ngo = ingoService.deleteNGO(ngoId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO deleted successfully.");
		ResponseEntity<NGO> response = new ResponseEntity<NGO>(ngo, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------------------------------------------	

	/*
	 *   API requests for Retrieve NGOs from Database By Using NGOID//
	 */
//	http://localhost:8082/getngobyngoid/ngoid
	@GetMapping("/getbyngoid/{ngoid}")
	public ResponseEntity<NGO> getNgoByngoId(@PathVariable(name = "ngoid") Integer ngoId) {
		LOG.info("Controller getNgoByngoId");
		NGO ngo = ingoService.viewNGO(ngoId);// line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO is found by Ngoid.");
		ResponseEntity<NGO> response = new ResponseEntity<NGO>(ngo, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------------------------------------------

	/*
	 *   API requests for Retrieve NGOs from Database By Its Motive//
	 */
//	http://localhost:8082/getmgobymotive/ngomotive
	@GetMapping("getmgobymotive/{ngomotive}")
	public ResponseEntity<List<NGO>> viewNGOByMotive(@PathVariable(name = "ngomotive") String ngoMotive) {
		LOG.info("Controller getNgoByMotive");
		List<NGO> ngo = ingoService.viewNGOByMotive(ngoMotive);// line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO is found by Motive.");
		ResponseEntity<List<NGO>> response = new ResponseEntity<List<NGO>>(ngo, headers, HttpStatus.OK);
		return response;

	}

//----------------------------------------------------------------------------------------------------------------------------------------	

	/*
	 *   API requests for Retrieve NGOs from Database By Its Location//
	 */
//	http://localhost:8082/getmgobylocatio/ngolocation
	@GetMapping("getngobylocation/{ngolocation}")
	public ResponseEntity<List<NGO>> viewNGOByLocation(@PathVariable(name = "ngolocation") String ngoLocation) {
		LOG.info("Controller getNgoByLocation");
		List<NGO> ngo = ingoService.viewNGOByLocation(ngoLocation);// line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "NGO is found at \"" + ngoLocation + "\"Location.");
		ResponseEntity<List<NGO>> response = new ResponseEntity<List<NGO>>(ngo, headers, HttpStatus.OK);
		return response;
	}

}
