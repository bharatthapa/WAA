package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XSSController {

      @RequestMapping(value = "/XSS", method = RequestMethod.GET)
    public String XSS() {
 
         return "XSS";
    }

 
}