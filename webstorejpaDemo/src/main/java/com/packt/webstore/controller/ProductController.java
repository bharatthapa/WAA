package com.packt.webstore.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.CustomerService;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
 
	@Autowired
	private CustomerService customerService;
 
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/all")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);

		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("products", products);
		return "products";
	}

	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") String productId) {

		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "product";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}

		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = productToBeAdded.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+productToBeAdded.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

		try {
			productService.addProduct(productToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/products";
	}
	

	// CACHING example
	// If you WATCH the logging on the console.. you will see MUTIPLE fetches from the DB for P1234
	// AND ONLY one fetch for P1235
	@RequestMapping(value = "/cache" )
	public String processCacheTest(Model model, @RequestParam("P1234")String P1234, @RequestParam("P1235") String P1235 ) {

	System.out.printf("Start Cache Test\n" );

		
	// Get P1234 2X OUTSIDE transaction so NO cache
	 Product p = productService.getProductById("P1234");
	 p = productService.get(p.getId());
	
	 // Change P1234 Need to get and merge[ on Update and then get again....
	 p.setDescription(P1234);
	 productService.addProduct(p);
	 p = productService.get(p.getId());

	 System.out.printf("Product p: %s\n",p.getDescription());

	 // P1235 is a "description", a real get P1235 is hardcoded in getAddproduct
	 Product pp = productService.getAddProduct(P1235 );
// get P1235 again....
	 pp = productService.get(pp.getId());
	 
	 System.out.printf("Product pp: %s\n",pp.getDescription());

	 return "products";
	}
	
	// CASCADE - Add a product...through saving Customer
	// need to update product as it holds foreign key
	@RequestMapping(value = "/cascade" )
	public String processCascadeTest(Model model ) {
		
		// new product
		Product p = new Product();
		p.setName("Kemosabe");
		p.setProductId("P4321");
		p.setUnitPrice(new BigDecimal(23));
//		p.setUnitPrice(new BigDecimal(23));
	
		Product p2 = productService.getProductById("P1234");
		
		// Create a customer	
		Customer c = new Customer();
	
		c.setLastName("Dreamer");
		c.setFirstName("Freddy");
		c.setAge(15);
	
		c.getProductList().add(p);
		c.getProductList().add(p2);
			
		customerService.save(c);
 
		return "products";
	
	}
	
	@RequestMapping(value = "/fetch" )
	public String processFetchTest(Model model ) {
		
		List<Product> productList = productService.getProductsByDescOrder();
		
		for (Product pp: productList) {
		   System.out.println(pp.getProductId());
		}
		
	return "products";

	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidProductId", exception.getProductId());
		 mav.addObject("exception", exception);
		 mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		 mav.setViewName("productNotFound");
		 return mav;
	}
	
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
			return "invalidPromoCode";
	}



}
