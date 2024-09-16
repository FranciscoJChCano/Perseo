package Proyect.Perseo.controllers;

import Proyect.Perseo.models.Courses;
import Proyect.Perseo.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CoursesController {
    
     
    @Autowired
    CoursesService coursesServices;

    @GetMapping(path = "")
    public ArrayList<Courses> getAllCourses() {
        return coursesServices.getAllCourses();
    }

    @GetMapping(path = "/{id}")
    public Courses getCourseById(@PathVariable("id") Long id) {
        return coursesServices.getCourseById(id);
    }

    @PostMapping(path = "")
    public Courses addCourse(@RequestBody Courses newCourse) {
        return coursesServices.addCourse(newCourse);
    }

    @PutMapping(path = "/{id}")
    public void updateCourse(@RequestBody Courses courses, @PathVariable Long id) {
        courses.setId(id);
        coursesServices.updateCourse(courses);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
		return coursesServices.deleteCourse(id);
	}
}
