package com.educationalsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.educationalsite.module.EducationalSite;

public interface EducationalSiteRepo extends JpaRepository<EducationalSite, Integer>{

	@Query(value ="select * from educational_site where course_selected=?1",nativeQuery = true)
	List<EducationalSite> getByCourse(String course);
	
}
