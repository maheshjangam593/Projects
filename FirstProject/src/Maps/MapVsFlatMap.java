package Maps;

import java.util.List;
import java.util.stream.Collectors;

import Maps.Customer;
public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Customer> customerList=Customer.getAll();

        System.out.println(customerList);
        //map
        List<String> collect = customerList.stream().map(m -> m.getName()).collect(Collectors.toList());

        System.out.println(collect);

        //flatmap

        List<String> collect1 = customerList.stream().flatMap(m -> m.getPhoneNumbers().stream()).collect(Collectors.toList());

        System.out.println(collect1);
    }

}
