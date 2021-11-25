package com.capgemini.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.model.Scheme;



public interface ISchemeController {
	ResponseEntity<Scheme> addScheme(Scheme scheme);

	ResponseEntity<Scheme> updateScheme(Scheme scheme);

	ResponseEntity<Scheme> viewSchemeById(int schemeId);

	ResponseEntity<List<Scheme>> getAllSchemes();

	ResponseEntity<Scheme> deleteSchemeById(int schemeId);

	ResponseEntity<List<Scheme>> getSchemeByType(String schemeType);

	ResponseEntity<List<Scheme>> getSchemeByLaunchDate(LocalDate date);
}
