package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Product;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.controller.Controller;
import mum.edu.validator.ProductValidator;

public class ProductController implements Controller {

@AutoWired	
 ProductValidator productValidator;
	
 	public String inputProduct(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

	public String saveProduct(Product product, HttpServletRequest request, 
			HttpServletResponse response) {
         List<String> errors = productValidator.validate(product);
        if (errors.isEmpty()) {
              // store product in a scope variable for the view
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
  
            // store errors and product in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", product);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
 	}
}
