package mum.edu.controller;

import java.util.List;

import mum.edu.domain.Book;
import mum.edu.domain.Category;
import mum.edu.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/","/book_list"})
    public String listBooks(Model model) {
 System.out.println("sth is not working");
/*
 * The Following is replaced by @ModelAttribute on addBookList method*/
       List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
 	
        return "BookList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String inputBook(@ModelAttribute("newBook") Book book, Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
         return "BookAddForm";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    // Book list edit
    @RequestMapping(value = "/book_edit/{id}", method = RequestMethod.GET)
    public String editBook(Model model, @PathVariable("id") long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute(book);
 /*     
  * The following would OVERRIDE the above declaration of book  
        book = new Book();
        book.setAuthor("Anybody");
        model.addAttribute(book);
 */     
        return "BookEditForm";
    }
 
    // From Drop down list
    @RequestMapping(value = "/editBook", method = RequestMethod.POST)
    public String editBook(@ModelAttribute("bookSearch") Book searchBook, Model model ) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(searchBook.getId());
        model.addAttribute(book);
 /*       
        book = new Book();
        book.setAuthor("Anybody");
        model.addAttribute(book);
 */     
        return "BookEditForm";
    }

    // From BookEditForm.jsp
    @RequestMapping(value = "/book_update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }
    
    @ModelAttribute("books")
    List<Book> addBookList(Model model) {
      model.addAttribute("bookSearch", new Book());
    	
      return  bookService.getAllBooks();
    
    }

}