package packageJava.setClass;

import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Indique tamaño ?");
        String size = ask.next();
        boolean response = false;
        System.out.println("Indique si lleva o no mozzarella con 1 para si y 2 para no ?");
        String model= ask.next();
        System.out.println("Indique cantidad ?");
        int canti = ask.nextInt();
        
        ClassMethods pizza = new ClassMethods(size, response, canti);
        System.out.println(pizza.toString());
        if(model.equals("si")){
            pizza.setMozzarella(true);
            System.out.println(pizza.toString());
        }
        
        
    }
    
}
