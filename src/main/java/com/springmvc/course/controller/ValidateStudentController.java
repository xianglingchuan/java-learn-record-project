package com.springmvc.course.controller;

import java.io.UnsupportedEncodingException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springmvc.course.bean.ValidatorBean;
import com.springmvc.course.bean.ValidatorBook;
import com.springmvc.course.bean.ValidatorBookInfo;
import com.springmvc.course.bean.ValidatorStudent;


@Controller
@RequestMapping("/student")
public class ValidateStudentController {

	
    /**
     * 表单提交方法
     */
	@RequestMapping(value="/index", method = {RequestMethod.GET})
    public String index(Model model){
		//如果模型数据中包含同名数据则不再添加，
		//如果不判断将一直重新new新的模型数据
		if(!model.containsAttribute("validatorBean")){
         	ValidatorBean validatorBean = new ValidatorBean();
        	model.addAttribute("validatorBean", new ValidatorBean());            
        }
        return "springmvc/student/index";
    }	
    
    
    /**
     * 表单验证方法
     */
    @RequestMapping(value="/index", method = {RequestMethod.POST})
    public String indexSave(Model model, @Valid @ModelAttribute("validatorBean") ValidatorBean validatorBean, 
            BindingResult result) throws UnsupportedEncodingException{
    	//如果存在验证错误信息重定向到表单提交展示错误信息
    	if(result.hasErrors()){
    		return index(model);
        }      
    	return "redirect:success"; 
    }   
    
    
    /**
     * 在表单提交方法中验证表单内容
     */
	@RequestMapping(value="/form3")
    public String save(Model model,  @Valid @ModelAttribute("validatorBean") ValidatorBean validatorBean, 
            BindingResult result){    	
    	if(result.getErrorCount()<=0){
    		 //开始数据提交工作
    		 //返回提交成功界面
    		 return "redirect:success"; 
    	}
        return "springmvc/student/form3";
    }	
	
	
    /**
     * 在表单同验证两个模型数据
     */	
	@RequestMapping(value="/form4")
    public String form4(Model model,
    		@Valid @ModelAttribute("validatorBookInfo") ValidatorBookInfo validatorBookInfo, 
    		BindingResult result   		
    		){		
		System.out.println("book --> " + validatorBookInfo.getValidatorBook());
		System.out.println("student --> " + validatorBookInfo.getValidatorStudent());
		ValidatorBook validatorBook = validatorBookInfo.getValidatorBook();
		System.out.println("errorCount:"+result.getErrorCount());
        return "springmvc/student/form4";
    }
	
	
    /**
     * 表单提交验证成功方法
     */
	@RequestMapping(value="/success")
    public String success(Model model){
		return "springmvc/student/success";
	}
}
