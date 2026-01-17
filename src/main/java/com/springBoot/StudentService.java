package com.springBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentService {

    @Autowired
    StudentRepo repo;

    @PostMapping("/add")
    public String addData(Student stu) {
        stu.setName("Ritanshu");
        System.out.println("Data Inserted");
        repo.save(stu);
        return "Data Inserted";
    }
    
    @GetMapping("/show")
    public List<Student> showData() {
    	List<Student> list = repo.findAll();
    	for(Student s : list) {
    		System.out.println(s.getId()+" " + s.getName());
    	}
    	return list;
    
    }
}
