package com.educationalsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.educationalsite.module.EducationalSite;
import com.educationalsite.service.EducationalSiteService;

@RestController
public class EducationalSiteController {
	
	@Autowired
	EducationalSiteService es;
	
	@PostMapping("/saveStudent")
	ResponseEntity<EducationalSite> saveStduent(@RequestBody EducationalSite e){
		
		return new ResponseEntity<EducationalSite>(es.saveStudentDetails(e),HttpStatus.CREATED);
	}
	@GetMapping("/allDetails")
	List<EducationalSite> allDetails(){
		return es.allDetails();
	}
	
	@GetMapping("/findById/{id}")
	ResponseEntity<EducationalSite> getById(@PathVariable int id){
		return new ResponseEntity<EducationalSite>(es.getById(id),HttpStatus.OK);
	}
	@GetMapping("/getByCourse/{course}")
	List<EducationalSite> getByCourse(@PathVariable String course){
		return es.getByCourse(course);
	}
	@PutMapping("/update/{id}")
	ResponseEntity<EducationalSite> updateById(@PathVariable("id") int id ,@RequestBody EducationalSite s){
		return new ResponseEntity<EducationalSite>(es.updateById(s, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteById/{id}")
	ResponseEntity<EducationalSite> deleteById(@PathVariable int id){
		return new ResponseEntity<EducationalSite>(es.deleteById(id),HttpStatus.OK);
	}
	
	
}
