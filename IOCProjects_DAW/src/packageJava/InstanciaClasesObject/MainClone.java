
package packageJava.InstanciaClasesObject;
import java.util.Scanner;

public class MainClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner ask = new Scanner(System.in);
        ObjectJava obj = new ObjectJava(42.5, "red", 2);
        
        System.out.println(obj.toString());
        obj.aumentaInventary();
        System.out.println(obj.toString());
        
        ObjectJava objClone = (ObjectJava) obj.clone();
        
        System.out.println(objClone.toString());
        
        if(obj.equals(objClone)){
            System.out.println("Its the same object");
        }
    }   
}
