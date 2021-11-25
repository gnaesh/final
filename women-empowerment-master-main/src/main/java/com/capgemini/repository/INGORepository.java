package com.capgemini.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.model.NGO;

/*
 * INGORepository Interface extends on JPARepository 
 */
public interface INGORepository extends JpaRepository<NGO, Integer> {
	/*
	 * Repository Methods for retrieved NGO by its Location.
	 */
	public abstract List<NGO> findByNgoMotive(String ngoMotive);

	/*
	 * Repository Methods for retrieved NGO by its Location.
	 */
	public abstract List<NGO> findByNgoLocation(String ngoLocation);
}