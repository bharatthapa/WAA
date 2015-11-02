package app04a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import app04a.domain.Product;
/*
 * 
 * ..PASSING Session Attributes to Another Controller [ from ProductController]
 */
@Controller
//Donatello was "set" in product as a "regular Attribute
// We are making him onto a @SessionAttribute now!!!
@SessionAttributes({"Leonardo","Donatello"}) 
public class SessionController {

     @RequestMapping(value={"/session"}, method = RequestMethod.GET)
         public void inputProduct(Map map, HttpServletRequest request, SessionStatus status ) {
 
        System.out.println("SESSION GET");
        	
        // check for Session attribute[s] from ProductController
        getSessionProduct( map);
        
        // Should remove Donatello [even though set as a "regular" attribute in Product]
        // as he was declared as a @SessionAttribute HERE
        // He is removed AFTER completion of method...so we will see him here BUT
        // he will be missing when we return to add product
	    status.setComplete(); 

        // and Regular attribute
        System.out.printf("Raphael : %s\n", request.getSession().getAttribute("Raphael"));
        System.out.printf("Donatello : %s\n", request.getSession().getAttribute("Donatello"));
        System.out.printf("Regular Session-Splinter : %s\n", request.getSession().getAttribute("Splinter"));
       
        // Picks up view name from RequestMapping
         return ;
    }

     
    public void getSessionProduct(Map map) {

    	Product product = (Product) map.get("Leonardo");
         if (product != null)  {
        	System.out.printf("Leonardo name : %s\n", product.getName());
         }
       else System.out.printf("No @SessionAttribute named Leonardo \n" );
 
    	 String splinter = (String) map.get("Splinter");
         if (product != null)  {
         	System.out.printf("Splinter name : %s\n", splinter);
          }
        else System.out.printf("No @SessionAttribute named Splinter \n" );

    }


}
