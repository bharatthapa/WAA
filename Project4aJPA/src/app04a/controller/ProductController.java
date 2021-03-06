package app04a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app04a.domain.Phone;
import app04a.domain.Product;
import app04a.service.PhoneService;
import app04a.service.ProductService;

@Controller
public class ProductController {
 
	@Autowired
	ProductService productService;
	
	@Autowired
	PhoneService phoneService;
	
     @RequestMapping(value={"/product"}, method = RequestMethod.GET)
    public String inputProduct() {
         return "ProductForm";
    }

    @RequestMapping(value="/product", method = RequestMethod.POST)
    public String saveProduct(Product product ) {
    	
// Simulate detached object for product cascade
 //   	Phone phone = phoneService.save(product.getHotLine());
 //   	phone.setNumber(1);
 //   	product.setHotLine(phone);
 //----------------------------------------   	
    	
    	productService.save(product);
    	// Get it again....Demo Cascade
    	product = productService.find(product.getId());
    	
        return "ProductDetails";
    }
    
    
    @RequestMapping(value="/listproducts", method = RequestMethod.GET)
    public String listProducts(Product product, Model model ) {
    	
    	
		List<Product> list = productService.getAllProducts();
		model.addAttribute("products",  list);
    	
        return "ListProducts";
    }
    
  
    @RequestMapping(value="/addPhone", method = RequestMethod.GET)
    public String addPhone(Model model ) {
    	
    	Phone   phone = new Phone();
    	phone.setAreaCode(123);
    	phone.setNumber(2367);
    	phone.setPrefix(222);
    	
    	Product product = new Product();
    	product.setName("TestPhone");
    	product.setDescription("Test SAVE Phone");
    	product.setPrice((float)44.00);
    	
    	phone.setProduct(product);
    	
    	phoneService.save(phone);
    	
		List<Product> list = productService.getAll();
		model.addAttribute("products",  list);
    	
        return "ListProducts";
    }
    

    
}
