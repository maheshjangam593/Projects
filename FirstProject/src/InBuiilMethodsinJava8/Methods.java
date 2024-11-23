package InBuiilMethodsinJava8;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public static List<Employee> emp;

    public static void main(String[] args) {

        emp = new ArrayList<>();
        emp.add(new Employee(2, "ramya", "ece", 20, 20930, "FeMale"));
        emp.add(new Employee(12, "mahi", "cse", 29, 2023, "Male"));
        emp.add(new Employee(9, "raji", "cse", 21, 20034, "FeMale"));
        emp.add(new Employee(10, "sri", "mech", 25, 209300, "Male"));
        emp.add(new Employee(3, "abhi", "mech", 22, 10130, "FeMale"));
        emp.add(new Employee(7, "sweety", "cse", 22, 10910, "FeMale"));
        emp.add(new Employee(5, "lucky", "cse", 24, 11231, "FeMale"));
        emp.add(new Employee(6, "vicky", "ece", 25, 22423, "Male"));
        Methods m = new Methods();
        System.out.println("Print how many mail and female members are there in organization");
        m.printFemaleAndMale();
        System.out.println();
        System.out.println("Print the all depts in org");
        m.printDepts();
        System.out.println();
        System.out.println("print the avg age of male and female employess");
        m.avgAgeOfEmp();
        System.out.println();
        System.out.println("Print the Highest paid salary employee");
        m.highestPaidEmp();
        System.out.println();
        m.countEmpOfEachDept();
        System.out.println();
        m.avgSalaryOfEachDept();
        System.out.println();
        System.out.println("print yongest fmale employee in cse");
        m.getYoungestFemaleInCSE();
        System.out.println();
        System.out.println("get avg and sum salary of org");
        m.getAvgAndMaxSalaryOfOrg();
        System.out.println();
        System.out.println("print emp is greater than 25");
        m.getEmpGreaterThan25();



    }

    private void getEmpGreaterThan25() {

        Map<Boolean, List<Employee>> collect = emp.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 23));
        Set<Map.Entry<Boolean, List<Employee>>> entries = collect.entrySet();
        for (Map.Entry<Boolean,List<Employee>> e:entries
             ) {

            if (e.getKey())
            {
                System.out.println("greter than 25");
            }
            else {
                System.out.println("less than 25 age");
            }

            List<Employee> value = e.getValue();
            for (Employee v:value
                 ) {

                System.out.println(v.getName());
            }

        }

    }

    private void getAvgAndMaxSalaryOfOrg() {
        DoubleSummaryStatistics collect = emp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect);
    }

    private void getYoungestFemaleInCSE() {
        Optional<Employee> min = emp.stream().filter(e -> e.getGender() == "FeMale" && e.getDept() == "cse").min(Comparator.comparing(Employee::getAge));
        System.out.println(min);
    }

    private void avgSalaryOfEachDept() {
        Map<String, Double> collect = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect);
    }

    private void countEmpOfEachDept() {
        Map<String, Long> collect = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(collect);
    }

    private void highestPaidEmp() {

        Optional<Employee> max = emp.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max);

        Optional<Employee> collect = emp.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(collect);
    }

    private void avgAgeOfEmp() {
        Map<String, Double> collect = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(collect);
    }


    private void printDepts() {
        Map<String, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getDept));
        Set<Map.Entry<String, List<Employee>>> entries = collect.entrySet();
        for (Map.Entry<String, List<Employee>> e :
                entries) {
            List<Employee> value = e.getValue();
            for (Employee e1 : value
            ) {
                System.out.println(e1);
            }

            emp.stream().map(Employee::getDept).distinct().forEach(System.out::println);
        }
    }

    private void printFemaleAndMale() {

        Map<String, Long> collect = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Set<Map.Entry<String, Long>> entries = collect.entrySet();
        for (Map.Entry<String, Long> m :
                entries) {
            System.out.println(m.getKey() + "  " + m.getValue());
        }

    }
}
