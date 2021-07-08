package com.clinic.controller.api;

import com.clinic.model.Department;
import com.clinic.service.department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentAPI {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Department>> showDepartments(){
        Iterable<Department> departments = departmentService.findAll();
        if (((List) departments).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }
}
