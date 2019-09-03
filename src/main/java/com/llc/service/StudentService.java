package com.llc.service;


import com.llc.dao.StudentDao;
import com.llc.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stuService")
public class StudentService {


    @Resource(name = "stuDao")
    private StudentDao dao;

    public List<Student> getAllStudent(){
        return dao.findAll();
    }



}
