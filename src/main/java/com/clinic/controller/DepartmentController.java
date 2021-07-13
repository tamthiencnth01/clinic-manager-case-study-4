package com.clinic.controller;

import com.clinic.model.Department;
import com.clinic.service.department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/departments")
    public ModelAndView showAllList(){
        Iterable<Department> departments = departmentService.findAll();
        ModelAndView modelAndView  = new ModelAndView("/department/list");
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }

    @GetMapping("/create-department")
    public ModelAndView showFormCreateDepartment(){
        ModelAndView modelAndView = new ModelAndView("/department/createFormDepartment");
        modelAndView.addObject("department",new Department());
        return modelAndView;
    }

    @PostMapping("/create-department")
    public ModelAndView createDepartment(@ModelAttribute Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/createFormDepartment");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @GetMapping("/edit-department/{id}")
    public ModelAndView showFormEditDepartment(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/department/updateFormDepartment");
            modelAndView.addObject("department", department.get());
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/department/list");
            return modelAndView;
        }

    }

    @PostMapping ("/edit-department")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/updateFormDepartment");
        modelAndView.addObject("department", department);
        return modelAndView;
    }
}
