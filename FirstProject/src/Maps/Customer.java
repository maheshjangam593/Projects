package Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customer {
    private int id;
    private String name;
    private List<String> phoneNumbers;

    public Customer(int id, String name, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    public static List<Customer> getAll() {
        return Stream.of(new Customer(1000, "sdks", Arrays.asList("213", "12312")), new Customer(
                4, "ser", Arrays.asList("2123", "2323")), new Customer(2232, "jsPDF", Arrays.asList("2323", "223"))).collect(Collectors.toList());

    }
    public static List<Customer> getAllParalelly() {

        List<Customer> list=new ArrayList<>();

        for (int i = 1; i <1000 ; i++) {

            list.add(new Customer(i,"emp "+ i,Arrays.asList("213", "12312")));
        }
        return  list;

    }
}
