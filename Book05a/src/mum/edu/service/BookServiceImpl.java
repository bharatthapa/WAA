package mum.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mum.edu.domain.Book;
import mum.edu.domain.Category;
import mum.edu.domain.ISBNumber;

@Service
public class BookServiceImpl implements BookService {
    
    /*
     * this implementation is not thread-safe
     */
    private List<Category> categories;
    private List<Book> books;
    
    public BookServiceImpl() {
        categories = new ArrayList<Category>();
        Category computingCategory1 = new Category(1, "Computing");
        Category travelCategory = new Category(2, "Travel");
        Category healthCategory = new Category(3, "Health");
        categories.add(computingCategory1);
        categories.add(travelCategory);
        categories.add(healthCategory);
        
        books = new ArrayList<Book>();
         books.add(new Book(1L, "23456789", 
                "Servlet & JSP: A Tutorial", 
                computingCategory1, "Budi Kurniawan"));
         books.add(new Book(2L, "7876453",
                "C#: A Beginner's Tutorial",
                computingCategory1, "Jayden Ky"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }
    
    @Override
    public Category getCategory(int id) {
        for (Category category : categories) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book get(long id) {
        for (Book book : books) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }
    
    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for (int i = 0; i < bookCount; i++) {
            Book savedBook = books.get(i);
            if (savedBook.getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }
        return book;
    }
    
    @Override
    public long getNextId() {
        // needs to be locked
        long id = 0L;
        for (Book book : books) {
            long bookId = book.getId();
            if (bookId > id) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
