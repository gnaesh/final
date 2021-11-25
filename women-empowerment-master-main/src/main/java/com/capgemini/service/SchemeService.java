package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.SchemeAlreadyExistsException;
import com.capgemini.exception.SchemeNotFoundException;
import com.capgemini.model.Scheme;
import com.capgemini.repository.ISchemeRepository;

@Service
public class SchemeService implements ISchemeService {

	private static final Logger LOG = LoggerFactory.getLogger(ISchemeService.class);

	@Autowired
	private ISchemeRepository iSchemeRepository;

	@Override
	public Scheme addScheme(Scheme scheme) {
		LOG.info("Service addScheme");
		boolean schemeOpt = iSchemeRepository.existsById(scheme.getSchemeId());
		if (!schemeOpt) {
			return iSchemeRepository.save(scheme);
		} else {
			throw new SchemeAlreadyExistsException(scheme + " is already exists.");
		}

	}

	// -------------------------------------------------------------------------------------------
	@Override
	public Scheme updateScheme(Scheme scheme) {
		LOG.info("Service updateScheme");
		Optional<Scheme> schemeOpt = iSchemeRepository.findById(scheme.getSchemeId());
		if (schemeOpt.isPresent())
			return iSchemeRepository.save(scheme);
		else
			throw new SchemeNotFoundException(scheme + " not found.");
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public Scheme viewScheme(int schemeId) {
		LOG.info("Service viewScheme");
		Optional<Scheme> schemeOpt = iSchemeRepository.findById(schemeId);
		if (!schemeOpt.isEmpty())
			return schemeOpt.get();
		else
			throw new SchemeNotFoundException("Scheme Id: " + schemeId + " not found.");
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public List<Scheme> viewAllScheme() {
		LOG.info("Service viewAllScheme");
		List<Scheme> schemeOpt = iSchemeRepository.findAll();
		if (!schemeOpt.isEmpty()) {
			return schemeOpt;
		} else {
			throw new SchemeNotFoundException("Schemes not found.");
		}
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public Scheme deleteScheme(int schemeId) {
		LOG.info("Service deleteScheme");
		Optional<Scheme> schemeOpt = iSchemeRepository.findById(schemeId);
		if (schemeOpt.isPresent()) {
			iSchemeRepository.deleteById(schemeId);
			return schemeOpt.get();
		} else {
			throw new SchemeNotFoundException("Scheme Id: " + schemeId + " not found.");
		}
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public List<Scheme> viewSchemesByType(String schemeType) {
		LOG.info("Service viewSchemesByType");
		List<Scheme> schemeOpt = iSchemeRepository.findBySchemeType(schemeType);
		if (!schemeOpt.isEmpty())
			return schemeOpt;
		else
			throw new SchemeNotFoundException("Scheme with type \" " + schemeType + "\" is not found.");
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public List<Scheme> viewSchemeByLaunchDate(LocalDate date) {
		LOG.info("Service viewSchemeByLaunchDate");
		List<Scheme> schemeOpt = iSchemeRepository.findBySchemeLaunchDate(date);
		if (!schemeOpt.isEmpty())
			return schemeOpt;
		else
			throw new SchemeNotFoundException("Scheme with launch date \" " + date + "\" not found.");
	}

	// -------------------------------------------------------------------------------------------

	@Override
	public List<Scheme> viewSchemesByEligibility(String schemeEligibility) {
		LOG.info("Service viewSchemesByEligibility");
		List<Scheme> schemeOpt = iSchemeRepository.findBySchemeEligibility(schemeEligibility);
		if (!schemeOpt.isEmpty())
			return schemeOpt;
		else
			throw new SchemeNotFoundException("Scheme with eligibility \" " + schemeEligibility + "\" not found.");
	}
}
