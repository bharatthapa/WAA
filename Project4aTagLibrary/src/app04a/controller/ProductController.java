package app04a.controller;

import java.util.List;

import app04a.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app04a.domain.Product;
import app04a.service.CategoryService;
import app04a.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;


	@RequestMapping(value = { "/", "/product" }, method = RequestMethod.GET)
	public String inputProduct(Product product, Model model) {

		List<Category> categories = categoryService.getAll();
		//System.out.println("Size  " + categories.size());
		model.addAttribute("categories", categories);

		return "ProductForm";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		Category category = categoryService.getCategory(product.getCategory()
				.getId());
		product.setCategory(category);
		productService.save(product);
		return "ProductDetails";
	}

	@RequestMapping(value = "/listproducts", method = RequestMethod.GET)
	public String listProducts(Model model) {

		List<Product> list = productService.getAll();
		model.addAttribute("products", list);

		return "ListProducts";
	}
	/*
	 * @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
	 * public String inputProduct(Product oldProduct, Product newProduct, Model
	 * model) {
	 * 
	 * // Which "product" "survives in model? newProduct.setDescription("NEW");
	 * oldProduct.setDescription("OLD"); Product product =
	 * (Product)model.asMap().get("product");
	 * System.out.println(product.getDescription() );
	 * 
	 * // NOW which one ???!!?? product = new Product();
	 * product.setDescription("EXTRA"); model.addAttribute(product);
	 * 
	 * List<Category> categories = categoryService.getAll();
	 * model.addAttribute("categories", categories);
	 * 
	 * 
	 * return "ProductForm"; }
	 */

}
