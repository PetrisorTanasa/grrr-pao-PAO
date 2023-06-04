package main.java.exercitii;

public class C {
    public int a;
    public static int b;
    public C(){
        b++;
        b = b+a;
    }
    public void met(){
        a = a+b;
        a++;
    }
}
