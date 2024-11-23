package Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import Maps.Customer;

public class OptionalDemo {

    public static void main(String[] args) {
        Customer customer = new Customer(1,"hello", Arrays.asList("231","312"));

        // creates optinal object f it is null
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        //check for null value if null thorws exception
       /* Optional<String> optionalNull = Optional.of(customer.getName());
        System.out.println(optionalNull);*/

        //if null creates optional object if value is there checks for null using of
        Optional<String> ofNull = Optional.ofNullable(customer.getName());

        if (ofNull.isPresent())
        {
            System.out.println(ofNull.get());
        }

        System.out.println(ofNull.orElse("default message if name is null"));
        System.out.println(ofNull.orElseThrow(()-> new IllegalArgumentException("imail not presetn")));

        System.out.println(ofNull.map(String::toUpperCase).orElseGet(()->"if item not present printed deault msg"));
    }
}
