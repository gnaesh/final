package com.capgemini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.NGO;



public interface INGOController {
	ResponseEntity<NGO> addngo(NGO ngo);

	ResponseEntity<NGO> updateNgo(NGO ngo);

	 ResponseEntity<NGO> deleteNgoByNgoId(Integer ngoId);

	ResponseEntity<List<NGO>> getallngos();

	ResponseEntity<NGO> getNgoByngoId(Integer ngoId);

	ResponseEntity<List<NGO>> viewNGOByMotive(String motive);

	ResponseEntity<List<NGO>> viewNGOByLocation(String location);
}
