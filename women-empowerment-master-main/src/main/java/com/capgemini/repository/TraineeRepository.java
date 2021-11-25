package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.model.Trainee;



@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	
	public abstract Trainee findByAadharNo(Long aadharNo);

//	@Query(value="Select c from trainee_details c where c.courseid=:id")
//	public Trainee findByCourseId(@Param("id")int courseId);
	
	//public abstract Trainee findByCourseId(int courseId);


//	@Query(value = "Select location From Trainee_Details  Where location = :location")
	// public abstract List<Trainee> getAllTraineeByLocation(@Param("location")
	// String location);
	public abstract List<Trainee> getAllTraineeByLocation(String location);

}
