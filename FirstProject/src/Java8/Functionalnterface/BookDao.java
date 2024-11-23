package Java8.Functionalnterface;

import Java8.Functionalnterface.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1, "mahesh"));
        list.add(new Book(4, "ajay"));
        list.add(new Book(2, "ram"));
        return list;
    }
}
