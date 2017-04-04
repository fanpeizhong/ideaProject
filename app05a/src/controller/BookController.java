package controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Book;
import domain.Category;
import service.BookService;

@Controller
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book_input")
    public String inputBook(Model model) {
        logger.info("book_input");
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book(hashCode(), "isbn", "title", categories.get(1), "author"));
        return "BookAddForm";
    }

    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable("id") long id) {
        logger.info("book_edit");
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }
    /*@RequestMapping(value = "/book_edit")
    public String editBook(Model model, @ModelAttribute("id") long id) {
        logger.info("book_edit");
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }*/

    @RequestMapping(value = "/book_save")
    public String saveBook(@ModelAttribute Book book) {
        logger.info("book_save");
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book) {
        logger.info("book_update");
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        logger.info("book_list");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }
}