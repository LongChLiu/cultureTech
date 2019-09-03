package com.llc.controller;


import com.llc.model.Student;
import com.llc.service.StudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("stu")
public class StudentController {

    @Resource(name = "stuService")
    private StudentService stuService;


    @ApiOperation(value = "获得所有的学生对象list",notes = "get请求，查询所有的学生。")
    @RequestMapping(value = "/getAllStu",method = RequestMethod.GET)
    public ModelAndView getAllStudent(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("stuDisplay");
        mav.addObject("students",stuService.getAllStudent());
        return mav;
    }



    @ApiOperation(value = "根据学生的name,获得单个学生的信息",notes = "根据学生的name,查询" +
            "学生对象的信息。")
    @ApiImplicitParam(name = "name",value = "学生的名称",required = true, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "getStuByName",method = RequestMethod.POST)
    public String getStuByName(String name){
        return  "您得到了"+name;
    }


    @ApiOperation(value = "根据学生的name和age,获得单个学生的信息",notes = "根据学生的name和age,查询学生对象的信息。")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "学生名称",required = true,dataType = "String")})
    public String getStuByNameAndAge(String name,int age){
        return name + "-----名字" + "\n" + age + "-----年龄";
    }



    @ApiOperation(value = "新建学生对象到数据库",notes = "新建数据到数据库。")
    @ApiImplicitParam(name = "stu",value = "学生对象",required = true,dataType = "Student")
    @ResponseBody
    @RequestMapping(value = "createNewStu",method = RequestMethod.POST)
    public String create(@RequestBody Student stu){
        return "创建";
    }








}
