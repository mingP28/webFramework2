package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {


    // Controller -> Service -> Dao 이런 구조
    @Autowired
    private CourseService courseService;

    @GetMapping("/totalcredit")
    public String showTotalCredits(Model model) {
        List<Course> totalCredits = courseService.getTotalCredits();
        int sumTotalCredits = courseService.getSumTotalCredits(totalCredits);
        model.addAttribute("totalCredits", totalCredits);
        model.addAttribute("totalSum", sumTotalCredits);
        return "totalcredit";
    }
    @GetMapping("/detail/{year}/{semester}")
    public String showDetailCourses(@PathVariable int year, @PathVariable int semester, Model model) {
        List<Course> courses = courseService.getDetailCourses(year, semester);
        model.addAttribute("detailCourses", courses);
        return "detailcourse";
    }
    @GetMapping("/addcourse")
    public String showAddCourse(Model model){
        model.addAttribute("course", new Course());
        return "addcourse";
    }
    @PostMapping("/completeadd")
    public String completeAdd(Model model, @Valid Course course, BindingResult result) {

        // System.out.println(offer);
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "addcourse";
        }

        // Controller -> Service -> Dao
        courseService.insert(course);

        return "completeadd";
    }
    @GetMapping("/inquirycourse")
    public String inquiryCourse(Model model){
        List<Course> courses = courseService.getAddCourse();
        model.addAttribute("addCourses", courses);
        return "inquirycourse";
    }
}
