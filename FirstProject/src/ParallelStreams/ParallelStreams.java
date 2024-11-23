package ParallelStreams;

import Maps.Customer;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {
        long start = 0;
        long end = 0;


        /*start = System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out::println);
        end = System.currentTimeMillis();

        System.out.println("normal time " + (end - start));

        start = System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();

        System.out.println("parallel time " + (end - start));*/

        IntStream.range(1, 10).forEach(x -> {
            System.out.println("normal Thread " + Thread.currentThread().getName() + " " + x);
        });

        IntStream.range(1, 10).parallel().forEach(x -> {
            System.out.println(" prallel Thread " + Thread.currentThread().getName() + " " + x);
        });


        // get list from cutomer class

        List<Customer> list = Customer.getAllParalelly();

        start = System.currentTimeMillis();
        double asStreamDouble = list.stream().map(Customer::getId).mapToInt(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println(asStreamDouble + " stream time " + (end - start));

        // parallel
        start = System.currentTimeMillis();
        double asParellelStreamDouble = list.parallelStream().map(Customer::getId).mapToInt(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println(asParellelStreamDouble + "  parallel stream time " + (end - start));

    }
}
