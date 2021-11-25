package com.capgemini.service;


import java.time.LocalDate;
import java.util.List;

import com.capgemini.model.Scheme;

public interface ISchemeService  {
	
	public Scheme addScheme(Scheme scheme);

	public Scheme updateScheme(Scheme scheme);
	
	public Scheme viewScheme(int schemeId);

	public List<Scheme> viewAllScheme();

	public Scheme deleteScheme(int schemeId);

	public List<Scheme> viewSchemesByType(String schemeType);

	public List<Scheme> viewSchemeByLaunchDate(LocalDate date);
	
	public List<Scheme> viewSchemesByEligibility(String schemeEligibility);
}