/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class CourseController extends AbstractController {

    List<Course> courseList;
     Set<Course> myCourses = new HashSet<>();
    public CourseController() {
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false);
        switch (action) {
            case "add": {
                String[] crn = request.getParameterValues("crn");
                for (String courseCRN : crn) {
                    for (Course course : courseList) {
                        if (course.getCrn().equals(courseCRN)) {
                            myCourses.add(course);
                        }
                    }
                }

                return new ModelAndView("mycourses", "mycoursesmodel", myCourses);

            }
            case "search": {
                if(request.getParameter("searchType")!=null)
                {
                String searchType = request.getParameter("searchType");
                String searchQuery = request.getParameter("query");
                ArrayList<Course> searchedResult = new ArrayList<>();
                if (searchType.equals("crn")) {
                    for (Course course : courseList) {
                        if (course.getCrn().equals(searchQuery)) {
                            searchedResult.add(course);
                        }
                    }
                } else if (searchType.equals("title")) {
                    for (Course course : courseList) {
                        if (course.getCourseDescription().equals(searchQuery) || course.getName().equals(searchQuery) || course.getInstructor().equals(searchQuery)) {
                            searchedResult.add(course);
                        }
                    }
                }

                return new ModelAndView("courseview", "courseviewmodel", searchedResult);
                }
                else
                {
                    return new ModelAndView("searchCourse");
                }

            }
            case "remove": {
                //To be completed by students as part of Lab HW
                //getParam for getting value from HTML page and getAttribute is for getting value from the previous JSP page
                String[] crn = request.getParameterValues("crn");
                for (String courseCRN : crn) {
                    for (Course course : courseList) {
                        if (course.getCrn().equals(courseCRN)) {
                            myCourses.remove(course);
                        }
                    }
                }
               return new ModelAndView("mycourses", "mycoursesmodel", myCourses);

            }
            case "redirect" :
                    {
                       return new ModelAndView("mycourses","mycoursesmodel", myCourses); 
                    }
            default:
                break;
        }
        return null;

    }
}
