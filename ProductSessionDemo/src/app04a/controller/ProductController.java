package app04a.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app04a.domain.Product;

@Controller
@SessionAttributes({"Leonardo","Splinter"}) 
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);

    // "Dummy" repository for Flash Attributes test
    Map<String,Product> productRepository = new HashMap<String,Product>();
    
@Autowired
ServletContext servletContext;
    
    @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
         public String inputProduct(Product product, Model model, HttpSession session) {
        logger.info("inputProduct called");

        System.out.println("PRODUCT GET");
   	// check for Session attribute - Leonardo * Splinter
        getSessionProduct( model);
        // and Regular attributes
        System.out.printf("Raphael : %s\n", session.getAttribute("Raphael"));
        System.out.printf("Donatello : %s\n",session.getAttribute("Donatello"));
        
        // Add @SessionAttributes
        addSessionAttributes(model);

        // add Regular attribute
        session.setAttribute("Donatello", "Donatello Turtle");
        session.setAttribute("Raphael", "Raphael Turtle");

        // Application level attribute set in XML servlet configuration
        System.out.printf("Application Name : %s\n", servletContext.getAttribute("appName"));
        
        return "ProductForm";
    }

   @RequestMapping(value="/product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product newProduct, Model model, RedirectAttributes redirectAttributes, 
    		HttpServletRequest request) {
        logger.info("saveProduct called");
  	
        System.out.println("PRODUCT POST");

        // Check for attributes
        getSessionProduct( model);
        System.out.printf("Raphael : %s\n", request.getSession().getAttribute("Raphael"));
        System.out.printf("Donatello : %s\n", request.getSession().getAttribute("Donatello"));
            
            // Application level attribute set in XML servlet configuration
            System.out.printf("Application Name : %s\n", servletContext.getAttribute("appName"));
            
 	    
    	  // this is the NO  PRG pattern  return..
    	  if ( !newProduct.isPrgFlag())
         		  return "ProductDetails";
      	  
    	  productRepository.put(newProduct.getName(), newProduct);
    	  
    	  redirectAttributes.addFlashAttribute( newProduct);
    	  redirectAttributes.addAttribute("name", newProduct.getName());
    	  
     	  return "redirect:details";

    }
    
 
    @RequestMapping(value="/details", method = RequestMethod.GET)
    public String productDetails( Model model, @RequestParam("name") String name, HttpSession session, SessionStatus status ) {
 
        System.out.println("PRODUCT POST-REDIRECT");

        // Check for @Sessionattribute - Leonardo
        getSessionProduct( model);

        Product leo = (Product)session.getAttribute("Leonardo");
        if (leo != null) System.out.printf("Leonardo[from Session object] : %s\n", leo.getName());

      	Product product = (Product)( ((ModelMap) model).get(name) );

      	if (product == null) {
      		product = productRepository.get(name);
      		model.addAttribute("product", product);
      	}
      		

    	
    	// Remove @SessionAttributes DOES NOT remove "Regular" session attributes
	    status.setComplete(); 

        return "ProductDetails";
    }
 
    
    public void addSessionAttributes(Model model) {
    	Product product = new Product();
    	product.setName("Leonardo Turtle");
    	model.addAttribute( "Leonardo",product); 
    	
    	model.addAttribute("Splinter", "Splinter");
    }
    
    public void getSessionProduct(Model model) {
     	Product product = (Product)( ((ModelMap) model).get("Leonardo") );
        if (product != null)  System.out.printf("Leonardo name : %s\n", product.getName());
       else System.out.printf("No @SessionAttribute named Leonardo \n" );
        
     	String splinter = (String)( ((ModelMap) model).get("Splinter") );
        if (splinter != null)  System.out.printf("Splinter name : %s\n", splinter);
       else System.out.printf("No @SessionAttribute named Splinter \n" );
        
        
    }

 

}
