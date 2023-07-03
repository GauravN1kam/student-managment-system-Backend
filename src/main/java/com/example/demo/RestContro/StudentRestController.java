package com.example.demo.RestContro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moodle.Student;
import com.example.demo.repo.StudentRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentRestController {
	@Autowired
	private StudentRepo studentrepo;
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student)
	{
		return studentrepo.save(student);
	}
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentrepo.findAll();
	}
	@GetMapping("student/{sid}")
	public Student getStudentbyId(@PathVariable("sid") int sid)
	{
		return studentrepo.findById(sid).get();
	}
}
