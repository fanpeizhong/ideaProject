package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 范培忠 on 2017/2/17.
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "BookList";
    }

    @RequestMapping(value = "/cities")
    public String listCities(Model model){
        Map<String, String> capitals = new HashMap<String, String>();
        capitals.put("In", "ja");
        capitals.put("Ch", "BJ");
        capitals.put("Th", "MG");
        model.addAttribute("capitals", capitals);

        Map<String, String[]> bigCities = new HashMap<String, String[]>();
        bigCities.put("Au", new String[]{"a", "b", "c"});
        bigCities.put("中国", new String[]{"铁岭", "成都", "广州"});
        model.addAttribute("bigCities", bigCities);

        return "Cities";
    }
}
