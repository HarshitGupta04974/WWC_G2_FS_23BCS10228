package com.wwc.controller;

import com.wwc.model.Studnet;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController

@RequestMapping("/student")

public class StudentController
{
    List<Studnet> ls=new ArrayList<>();

    //Register
    @PostMapping
    public String registerStudent(@RequestBody Studnet studnet)
    {
        for(Studnet s:ls)
        {
            if(s.getId()==studnet.getId())
            {
                return "409 CONFLICT Id must be unique";
            }
        }
        if(studnet.getName()==null||studnet.getCourse()==null)
        {
            return "400 BAD REQUEST Validation failed";
        }
        else
        {
            ls.add(studnet);
            return "200 Student successfully registered";
        }
    }
    //Fetching All students
    @GetMapping
    public List<Studnet> getAllStudents()
    {
        if(ls==null)
    {
        return new ArrayList<>();
    }
        return ls;
    }
    //Fetching By ID
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable int id) throws Exception
    {
        try
        {
            return ls.stream().filter(x->x.getId()==id).findFirst().get().toString();
        }
        catch(Exception e){
            System.out.println(e);
            return "404 Student not found";
        }
    }

    // Deleting by ID
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable int id) throws Exception
    {
        try
        {
            ls.removeIf(x->x.getId()==id);
            return "Student successfully deleted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
}
