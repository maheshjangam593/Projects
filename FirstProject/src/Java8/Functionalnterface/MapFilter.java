package Java8.Functionalnterface;

import java.util.*;

public class MapFilter {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(19);
        list.add(15);
        list.add(12);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        list.stream().sorted().forEach(s -> System.out.println(s));// ascnding
        System.out.println("descneindg");
        list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));//descending

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "sdfa");
        map.put(12, "bsdf");
        map.put(31, "sdfc");
        map.put(4, "dsdfs");

        //  map.forEach((key,value)-> System.out.println(key+" "+value));
        // map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(obj-> System.out.println(obj));
        /* sorting of map need to convert to list */

// traditional
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<Integer, String> entry : entries) {

            System.out.println(entry.getValue());

        }

        Collections.sort(entries, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey() - o2.getKey();
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for (Map.Entry<Integer, String> entry : entries) {

            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("using streams");
        System.out.println();

        //based on value
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);


        //having key as an object

        Map<Book, Integer> mapObject = new HashMap<>();
        mapObject.put(new Book(10, "rk"), 10);
        mapObject.put(new Book(9, "st"), 9);
        mapObject.put(new Book(12, "shan"), 12);

        // reverse order by key

        mapObject.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Book::getName).reversed())).forEach(System.out::println);

        System.out.println("by  value");
        mapObject.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    }

}
