package service;

import domain.Book;
import domain.Category;

import java.util.List;

/**
 * Created by 范培忠 on 2017/1/26.
 */
public interface BookService {
    List<Category> getAllCategories();

    Category getCategory(int id);

    List<Book> getAllBooks();

    Book save(Book book);

    Book update(Book book);

    Book get(long id);

    long getNextId();
}
