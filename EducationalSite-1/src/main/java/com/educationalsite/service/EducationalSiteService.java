package com.educationalsite.service;

import java.util.List;

import com.educationalsite.module.EducationalSite;



public interface EducationalSiteService {
	
	EducationalSite saveStudentDetails(EducationalSite es);
	
	List<EducationalSite> allDetails();
	
	EducationalSite getById(int id);
	
	EducationalSite updateById(EducationalSite es,int id);
	
	EducationalSite deleteById(int id);
	
	List<EducationalSite> getByCourse(String course);
}
