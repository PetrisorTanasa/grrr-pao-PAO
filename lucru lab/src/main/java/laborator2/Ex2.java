package main.java.laborator2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your age: ");
        Integer age = Integer.valueOf(scanner.nextLine());
        Integer i = 0;
        if(age % 2 == 1){
            for(i=0;i<age;i++){
                System.out.println(i);
            }
        }
        System.out.println("Savem pofta");
        scanner.close();
    }
}
