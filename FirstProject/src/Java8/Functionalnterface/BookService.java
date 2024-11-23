package Java8.Functionalnterface;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    public List<Book> getSortedBook() {
        List<Book> list = new BookDao().getBooks();

        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        List<Book> sortedD = list.stream().sorted(Comparator.comparing(s -> s.getId())).collect(Collectors.toList());
        List<Book> sortedByreffernce = list.stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
        System.out.println(sortedByreffernce);
        System.out.println(sortedD);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getSortedBook());
    }
}
