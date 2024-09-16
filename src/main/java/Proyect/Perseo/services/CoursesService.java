package Proyect.Perseo.services;

import Proyect.Perseo.models.Courses;
import Proyect.Perseo.repositories.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CoursesService {
    @Autowired
    ICoursesRepository iCoursesRepository;

    public ArrayList<Courses> getAllCourses(){
        return (ArrayList<Courses>) iCoursesRepository.findAll();
    }

    public Courses getCourseById(Long id){
        Courses courses;
        courses = iCoursesRepository.findById(id).orElseThrow();
        return courses;

    }

    public Courses addCourse(Courses courses ){
        return iCoursesRepository.save(courses);
    }

    public void updateCourse(Courses courses){
        iCoursesRepository.save(courses);
    }

    public String deleteCourse(Long id){
        try{
            iCoursesRepository.deleteById(id);
            return "delete Course";
        }catch (Exception error){
            return "error to delete course";
        }
    }
    
}
