package com.capgemini.service;

import java.util.List;

import com.capgemini.model.NGO;
/*
 * NGO Interface for Service
 */
public interface INGOService  {

	public abstract NGO addNGO(NGO ngo);

	public abstract NGO updateNGO(NGO ngo);

	public abstract NGO viewNGO(int ngoId);

	public abstract List<NGO> viewAllNGO();

	public abstract NGO deleteNGO(int ngoId);

	public abstract List<NGO> viewNGOByMotive(String motive);

	public abstract List<NGO> viewNGOByLocation(String location);
}
