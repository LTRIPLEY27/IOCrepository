
package packageJava.ExamenFinal;

import java.util.Scanner;

public class Ejercicio1_Continentes {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Indique un número del 1 al 5 para indicar un continente y conocer su pico más alto \n 1. Contiente américano \n 2. Continente europeo \n 3. Contiente africano \n 4. Contiente asiático \n 5. Continente Oceanía");
        int num = ask.nextInt();
        
        switch(num){
            case 1: System.out.println("La montaña más alta del continente americano es el cerro Aconcagua, una prominencia de 6 960 metros de altitud situada en la provincia de Mendoza, al oeste de Argentina");
                break;
            case 2: System.out.println("El Monte Elbús. Su nombre oficial “La Montaña de las mil montañas”, es  considerado la montaña más alta de Europa con 5642 metros de altitud, está situado en territorio ruso, cerca de la república de Georgia y Chechenia y es para los alpinistas una de las codiciadas “Siete Cumbres”. ");
                break;
            case 3: System.out.println("El Kilimanjaro es una montaña situada en el noreste de Tanzania, formada por tres volcanes inactivos: el Shira, en el oeste, de 3962 m de altitud; el Mawenzi, en el este, de 5149 m y el Kibo, entre ambos, el más reciente desde el punto de vista geológico y cuyo pico, el Uhuru, se eleva hasta los más 5891,8 m. Es la montaña más alta de África, la montaña independiente más alta del mundo —a unos 4900 m de altura desde su base en la meseta— y el cuarto pico ultraprominente en la Tierra.");
                break;
            case 4: System.out.println("La montaña más alta del continente asiático es el monte Everest, una prominencia de 8850 metros de altitud situada en la frontera entre los países de Nepal y China.");
                break;
            case 5: System.out.println("La montaña más alta del continente oceánico es el monte Jaya (conocido como \"Puncak Jaya\" por los nativos), una prominencia de 4 884 metros de altitud situada en la región indonesia de la isla de Nueva Guinea");
                break;
            default:
                System.out.println("Indique una opción válida");
                break;
    }
    }
}
