package Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapAndReduce {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(1,4,5,2,8,6);

        List<String> words=Arrays.asList("skdjf","javataechi","hibernate");

        //sum using map
        int sum = list.stream().mapToInt(i -> i).sum();
        System.out.println(sum);

        //sum using reduce
        Integer reduceSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        //using method refference

        Optional<Integer> reduceMethodRefference = list.stream().reduce(Integer::sum);
        System.out.println(reduceMethodRefference.get());

        //max value

        Integer max = list.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(max);

        Integer methodamax = list.stream().reduce(Integer::max).get();
        System.out.println(methodamax);


        String maxLength = words.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();

        System.out.println(maxLength);


        double avgOfEmp = Customer.getAll().stream().filter(emp -> emp.getName().startsWith("s")).map(emp -> emp.getId()).mapToInt(i->i).average().getAsDouble();

        System.out.println(avgOfEmp);


    }


}
