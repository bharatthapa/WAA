package app04a.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 public class CookieController {

    @RequestMapping(value={"/cookie"}, method = RequestMethod.GET)
    public String cookie( HttpServletResponse response) {

	 // Will last "forever" - in "Current" browser
	    Cookie c = new Cookie("permanentCookie", "Forever");
	    // actually lasts for 3600/60 seconds = 60 minutes...
	    c.setMaxAge(30);
	    response.addCookie(c);
	    
	    // Only for life of "active" browser...
	    c = new Cookie("temporaryCookie", "Temporary");
	    response.addCookie(c);

     return "redirect:cookieDetails";
}


    @RequestMapping(value={"/cookieDetails"}, method = RequestMethod.GET)
    public String cookie(@CookieValue(value= "permanentCookie", defaultValue = " ") String permanentCookie,
    		@CookieValue(value="temporaryCookie",defaultValue = " ") String temporaryCookie, Model model, HttpServletRequest request) {

        System.out.println("COOKIES:");
       Cookie[] cookies = request.getCookies();
        if (cookies != null ) 
        	for (Cookie cookie : cookies) {
        		System.out.println(cookie.getName() +": " + cookie.getValue());
        	}
        
        model.addAttribute("permanentCookie",permanentCookie);
        model.addAttribute("temporaryCookie",temporaryCookie);
        
        
      return "cookieDetails";
  }

 
}
