package com.spring.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movies.model.Director;
@Repository
public interface DirectorRepo extends JpaRepository<Director, Integer> {

	//custom query
	@Query(value="select dname,dgender,success from director  where success between :succ1 and :succ2",nativeQuery = true)
	List<Object[]> getDirectorBySuccess(@Param("succ1") int succ1,@Param("succ2") int succ2);

}
