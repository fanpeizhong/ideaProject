package service;

import domain.Book;
import domain.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 范培忠 on 2017/1/26.
 */
@Service
public class BookServiceImpl implements BookService {
    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        Category category1 = new Category(1, "Computing");
        Category category2 = new Category(2, "Travel");
        Category category3 = new Category(3, "Health");
        
        categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<Book>();
        books.add(new Book(1L, "9780980839623",
                "Servlet & JSP: A Tutorial",
                category1, "Budi Kurniawan"));
        books.add(new Book(2L, "9780980839630",
                "C#: A Beginner's Tutorial",
                category1, "Jayden Ky"));
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
    public Book update(Book book) {
        Book book1 = get(book.getId());
        if (book1 != null) {
            books.set(books.indexOf(book1), book);
        }
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
    public long getNextId() {
        long id = 0L;
        for (Book book : books) {
            if (book.getId() > id) {
                id = book.getId();
            }
        }
        return id + 1;
    }
}
