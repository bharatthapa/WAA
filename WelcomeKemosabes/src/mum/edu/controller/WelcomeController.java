package mum.edu.controller;


	import java.util.ResourceBundle;

import mum.edu.domain.CellManagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
	 
	/**
	* @author JB
	*
	*/
	 
	@Controller
 	public class WelcomeController {	 
		
     		CellManagement cellManagement = new CellManagement();
        	int cellCounter = 0;
    		int totalCells = 4;
    		int studentCounter = 0;
    		String currentStudent = "";

     		String[] studentList;
    		
	    @RequestMapping({"/","/welcome"})
	    public ModelAndView helloAjaxTest(Model model) {
  	    	ModelAndView modelAndView = new ModelAndView("welcome", "message", " Welcome Kemosabes!!!");
	
  	    	studentList = getStudentList();

	        return modelAndView ;
	    }
	 
	    @RequestMapping(value = "/welcomeStudent", method = RequestMethod.GET)
	    public @ResponseBody String[] displayWelcome( ) {
	  	
	    	cellCounter++;
	    	if (cellCounter == (totalCells)) {
	    		cellCounter = 0;
	    		currentStudent = studentList[studentCounter];
	    		 if (++studentCounter == studentList.length)
	    			 studentCounter = 0;  		 
	    	}
	    	
  	        String [] result = {
  	        					String.valueOf(totalCells),
  	        					String.valueOf(cellCounter),
  	        					"Welcome to " + currentStudent
  	        					};
 	       
 			 return result;
	    }
	    
	    
	    String [] getStudentList() {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("students");	
			 
			String list = resourceBundle.getString("Students");
			String [] studentList = list.split(",");
	 
			return studentList;

	    }
	}
	
	
