package app04a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import app04a.domain.Product;

@Controller
@SessionAttributes("Michaelangelo") 
public class ForewardRedirect {

    // Demo redirect PLUS demo  @RequestParam 
    @RequestMapping(value="/redirect" )
    public String redirect (Model model ) {
        System.out.println("REDIRECT");

        // This is a request parameter
        // Shouldn't see it on redirect
        model.addAttribute("requestAttribute","requestAttribute");
        
       return "redirect:/get_redirect?redirectParamTest=4";
    }   
    
    
    @RequestMapping(value="/get_redirect" )
    public String getRedirect (@RequestParam("redirectParamTest")Integer productId, Model model ) {
        System.out.println("GET REDIRECT");
   	 
    	model.addAttribute("redirectParamTest","Product ID = " + productId);
  
        // Should NOT see RequestAttribute on session.jsp
        return "session";
    }   


    // Demo forward & remove "declared" "regular" session attribute
    @RequestMapping(value="/forward" )
    public String forward ( Model model, SessionStatus status) {
    	
        // This is a request parameter
        // Should  see it on forward
        model.addAttribute("requestAttribute"," Attribute is Set");
       
        System.out.println("FORWARD");
 
        
        model.addAttribute("Michaelangelo","Michaelangelo Turtle");
        // Should  see Michaelangelo  
        getSessionAttribute( model);

        // Removes Michaelangelo - TEST for removal in same controller
        status.setComplete();
        
       return "forward:/get_forward";
    }   
    
    @RequestMapping(value="/get_forward" )
    public String getForward (Model model) {
   	
        System.out.println(" GET FORWARD");
        
    	// Shouldn't see Michaelangelo anymore
        getSessionAttribute( model);
    	
        // Should see RequestAttribute on session.jsp
       return "session";
    }   

    public void getSessionAttribute(Model model) {


    	String michaelangelo = (String)( ((ModelMap) model).get("Michaelangelo") );
    	if (michaelangelo != null)
    		System.out.printf("Michaelangelo name : %s\n", michaelangelo);
    	else System.out.printf("No Session attribute named Michaelangelo \n" );
    		

    }



}
