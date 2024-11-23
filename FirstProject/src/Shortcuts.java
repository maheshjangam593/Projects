import java.util.Objects;

import static java.util.Arrays.*;

public class Shortcuts {
    private final int a;
    private final String s;


    public int getA() {
        return a;
    }

    public String getS() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shortcuts shortcuts = (Shortcuts) o;
        return a == shortcuts.a && Objects.equals(s, shortcuts.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, s);
    }

    @Override
    public String toString() {
        return "Shortcuts{" +
                "a=" + a +
                ", s='" + s + '\'' +
                '}';
    }

    public Shortcuts(int a, String s) {
        this.a = a;
        this.s = s;
    }

    public void addItem(String item) {
        int i = 1;

        long list1 = asList(12, 3).stream().count();
        System.out.println(list1);


        if (item != null) {

            String chill = "chill";
            System.out.println(item);
            System.out.println("hep lsdfj +kdsfkjk +dsfkjkj");

            String s = "lskdjflksdklfjdlk" +
                    "kjsdlkfjksdklfjdlk" + "" +
                    "lksjdflkjksdklfjdlk";


        }
    }


    public static void printList() {
        String[] str = new String[]{"hello", "hye"};
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }


    }


    public static void main(String[] args) {
        Shortcuts.printList();
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
    }

}


