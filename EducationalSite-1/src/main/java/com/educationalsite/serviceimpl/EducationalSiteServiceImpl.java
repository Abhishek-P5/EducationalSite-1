package com.educationalsite.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educationalsite.exception.ResourceNotFoundException;
import com.educationalsite.module.EducationalSite;
import com.educationalsite.repository.EducationalSiteRepo;
import com.educationalsite.service.EducationalSiteService;

@Service
public class EducationalSiteServiceImpl  implements EducationalSiteService{
	
	@Autowired
	EducationalSiteRepo repo;
	
	
	@Override
	public EducationalSite saveStudentDetails(EducationalSite es) {
		
		return repo.save(es);
	}

	@Override
	public List<EducationalSite> allDetails() {
		return repo.findAll();
	}

	@Override
	public EducationalSite getById(int id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("EducationalSite", "Id", id));
	}

	@Override
	public EducationalSite updateById(EducationalSite es, int id) {
		
	EducationalSite	existingStudent=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("EducationalSite", "Id", id));
		existingStudent.setName(es.getName());
		existingStudent.setPhno(es.getPhno());
		existingStudent.setBranch(es.getBranch());
		existingStudent.setCourseSelected(es.getCourseSelected());
		repo.save(existingStudent);
		return existingStudent;
	}

	@Override
	public List<EducationalSite> getByCourse(String course) {
		
		
		return repo.getByCourse(course);
	}

	@Override
	public EducationalSite deleteById(int id) {
	if(repo.existsById(id)) {
		EducationalSite	e1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("EducationalSite", "Id", id));
		repo.deleteById(id);
		
		return e1 ;
	}else {
		return null;
		
	}

}
}