package main.java.laborator2;

public class Ex1 {
    public static void main(String[] args) {
        char c = 't';
        Character cc = c;
        // Aici se intampla unboxing care este echivalentul lui:
        // Character cc = new Character(c);
        Integer i1 = 4;
        Integer i2 = Integer.valueOf(4);
        Integer i3 = Integer.valueOf("4");

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        System.out.println(i2 == i3);
        Integer i4 = Integer.valueOf(128);
        Integer i5 = Integer.valueOf("128");

        System.out.println(i4 == i5);

        boolean b1 = Boolean.valueOf("true");

    }
}
