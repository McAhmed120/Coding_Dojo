package com.ahmed.BooksApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmed.BooksApi.models.Book;
import com.ahmed.BooksApi.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // update a book
    public Book updateBook(Long id,String title,String desc,String lang,Integer numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	Book updatedBook=optionalBook.get();
        	updatedBook.setTitle(title);
            updatedBook.setDescription(desc);
            updatedBook.setLanguage(lang);
            updatedBook.setNumberOfPages(numOfPages);
            return bookRepository.save(updatedBook);
        } else {
            return null;
        }
    }
    // delete a book
    public String deleteBook(Long id) {
    	 bookRepository.deleteById(id);
    	 return "deleted";
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}