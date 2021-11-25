package com.capgemini.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Scheme;

@Repository
public interface ISchemeRepository extends JpaRepository<Scheme, Integer>{
	
	public abstract List<Scheme> findBySchemeType(String schemeType);
	
	public abstract List<Scheme> findBySchemeLaunchDate(LocalDate schemeLaunchDate);
	
	public abstract List<Scheme> findBySchemeEligibility(String schemeEligibility);
	
//	public abstract Scheme addScheme(Scheme scheme);

//	Scheme updateScheme(Scheme scheme);
//
//	Scheme viewScheme(int schemeId);
//
//	List<Scheme> viewAllScheme();
//
//	void deleteScheme(int schemeId);
//
//	List<Scheme> viewSchemesByType(String schemeType);
//
//	List<Scheme> viewSchemeByLaunchDate(LocalDate date);

}
