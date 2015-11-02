package app04a.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


// How does RedirectAttributess   work [OR not work!] -- in conjunction with  @SessionAttributes...
@Controller
@SessionAttributes({"Collie","Setter"}) 
public class DogController {

	 @RequestMapping("/dogSession")
	  public String input(Model model ) {
	 
		 // Setter WILL have "continuity" because it is NOT in Conflict 
		 // with FlashAttributes
 		 String setter = "Setter-Irish";
 		 model.addAttribute("Setter",setter);
 
		 return "dogSession";
	   }
	 
	 @RequestMapping(value="/dogSession", method = RequestMethod.POST)
	  public String input(Model model, RedirectAttributes redirectAttributes) {
	 
		 String ridgeback = "Ridgeback-Rhodesian";
 		 String collie = "Collie-Scottish";
	
 		 // Collie won't be in Model... won't be in session....because FlashMap supersedes it
 		 // That is - since they are SET in the same method as addFlashAttributes
 		 // They won't get into the model...
		 model.addAttribute("Collie",collie);
 		  
		 // Ridgeback WILL be in Model...
		 redirectAttributes.addFlashAttribute("Ridgeback", ridgeback);
		     
	      return "redirect:dogSessionDetails";
	   }
	  
	 @RequestMapping("/dogSessionDetails")
	  public String ouput(Map<String, Object> asMap, HttpSession session) {   
	 
  	    System.out.println("DOG DETAILS");
 
		 
 	     	for (Map.Entry<String, Object> entry :   asMap.entrySet())
 	     	    System.out.println(entry.getValue());
 
 	     	// Collie NOT in session either !!!
 	     	String collie = (String)session.getAttribute("Collie");
     	    System.out.println("Is collie in Session? - " + collie);
     	   
 	      return "dogSessionDetails";
	   }
	  
}

