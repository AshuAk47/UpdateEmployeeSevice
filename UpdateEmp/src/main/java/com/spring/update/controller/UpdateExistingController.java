package com.spring.update.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.update.model.Emp;
import com.spring.update.model.EmpRepository;

@RestController
@RequestMapping("/employee")
public class UpdateExistingController {
	@Autowired
	EmpRepository edao;



	@GetMapping("/update")
	public String upEmp(@RequestParam("eid") int eid, @RequestParam("ename") String ename, @RequestParam("esalary") int esalary) {
		Emp e = edao.findById(eid).get();
		String r="Emp Not Found";
		if(e!=null) {
			e.setName(ename);
			e.setSalary(esalary);
			edao.save(e);
			r="Emp found and Updated";
		}
		return r;

	}

}

