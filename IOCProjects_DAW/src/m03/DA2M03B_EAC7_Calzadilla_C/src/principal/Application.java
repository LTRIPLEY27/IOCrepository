package principal;

import areesTaller.Client;
import java.util.Scanner;

/**
 *
 * @author Maria Isabel Calzadilla
 */
public class Application {

    private static Taller[] tallers = new Taller[10];
    private static int pTallers = 0; //Priemra posició buida del vector tallers
    private static Taller tallerActual = null;
    
    public static final Scanner DADES  = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de tallers");
            System.out.println("\n2. Gestió de clients o clientes");
            System.out.println("\n3. Gestió de mecànics o mecàniques");
            System.out.println("\n4. Gestió de recanvis");
            System.out.println("\n5. Gestió de reparacions");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuTallers();
                    break;
                case 2:
                    if (tallerActual != null) {
                        menuClients();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el taller al menú Gestió de tallers");
                    }
                    break;
                case 3:
                    if (tallerActual != null) {
                        menuMecanics();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el taller al menú Gestió de tallers");
                    }
                    break;
                case 4:
                    if (tallerActual != null) {
                        menuRecanvis();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el taller al menú Gestió de tallers");
                    }
                    break;
                case 5:
                    if (tallerActual != null) {
                        menuReparacions();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el taller al menú Gestió de tallers");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuTallers() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista de tallers");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    tallers[pTallers] = Taller.addTaller();
                    pTallers++;
                    break;
                case 2:
                    indexSel = selectTaller();
                    if (indexSel >= 0) {
                        tallerActual = tallers[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquest taller");
                    }
                    break;
                case 3:
                    indexSel = selectTaller();
                    if (indexSel >= 0) {
                        tallers[indexSel].updateTaller();
                    } else {
                        System.out.println("\nNo existeix aquest taller");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pTallers; i++) {
                        tallers[i].showTaller();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menuClients amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut tallerActual no és null
       
     Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     Opció 1. Alta -->         Crea un client o clienta del taller actual. Penseu que Taller sap crear clients o clientes        
     Opció 2. Modificar -->     Permet modificar un client o clienta que està donat d'alta al taller actual
     (per comprovar l'existència del client o clienta tenim un mètode en la classe Taller que ens ajuda)
     Opció 3. Llista de clients i clientes --> Imprimeix les dades dels clients o clientes del taller actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     */
    public static void menuClients() {
       
        int opcion;
        int client = -1;
        String nif;

        do {
            System.out.println("Seleccione una opcion del menu");
            System.out.println("\n 0. para Salir");
            System.out.println("\n 1. para Alta");
            System.out.println("\n 2. para Modificar");
            System.out.println("\n 3. para ver Clientes registrados");
            opcion = DADES.nextInt();
            
            switch(opcion) {
                case 0 :
                    break;
                case 1 :
                    tallerActual.addClient();
                    pTallers++;
                    System.out.println("Cliente dado de alta");
                    break;
                case 2 :
                    System.out.println("Indique su NIF");
                    nif = DADES.next();
                    client = tallerActual.selectClient(nif);
                    if(client >= 0) { // RECIBE RESPUESTA DEL METODO "SELECT CLIENT"
                        tallerActual.getClients()[client].updateClient(); // UBICA AL CLIENT CON "GETCLIENTS" [INDICE DESDE 0] Y ACTUALIZA AL ENCONTRADO
                    } else {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 3 :
                    for(int i = 0; i < tallerActual.getpClients(); i++) {  // UBICA LA LONGITUD DEL ARRAY "CLIENTS" DE TALLER CON EL INDICE DE PCLIENTS
                        tallerActual.getClients()[i].showClient();
                        }
                    break;
                default:
                    System.out.println("debe de seleccionar una de las opciones del menu");
                    break;
                
            }
        } while(opcion != 0);
        
    }

    /*
     TODO Heu de desenvolupar el menuMecanics amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut tallerActual no és null
       
     Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     Opció 1. Alta -->         Crea un mecànic o mecànica del taller actual. Penseu que Taller sap crear mecànics o mecàniques        
     Opció 2. Modificar -->     Permet modificar un mecànic o mecànica que està donat d'alta al taller actual
     (per comprovar l'existència del mecànic o mecànica tenim un mètode en la classe Taller que ens ajuda)
     Opció 3. Llista de mecànics i mecàniques --> Imprimeix les dades dels mecànics i mecàniques del taller actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     */
    public static void menuMecanics() {
        
        int opcion;
        String nif;
        int indexMecanic = -1;
        
        do {
            
            System.out.println("indique la opcion");
            System.out.println(" \n 0. para salir");
            System.out.println(" \n 1. Alta Mecanico");
            System.out.println(" \n 2. Modificar mecanico");
            System.out.println(" \n 3. Listado de mecanicos");
           
            opcion = DADES.nextInt();
            
            switch(opcion) {
                
                case 0:
                    break;
                case 1:
                    tallerActual.addMecanic();
                    pTallers++;
                    System.out.println("Mecanico dado de alta");
                    break;
                case 2:
                    System.out.println("indique CIF mecanico");
                    nif = DADES.next();
                    indexMecanic = tallerActual.selectMecanic(nif);
                    if(indexMecanic >= 0) {
                        tallerActual.getMecanics()[indexMecanic].updateMecanic();
                    } else {
                        System.out.println("Mecanico no encontrado");
                    }
                    
                    break;
                case 3:
                    for(int i = 0; i < tallerActual.getpMecanics(); i++) {
                        tallerActual.getMecanics()[i].showMecanic();
                    }
                default:
                    System.out.println("Debe de seleccionar una opcion del menu para continuar");
                    break;
            }
            
            
            
        }while(opcion != 0);
        
    }

    /*
     TODO Heu de desenvolupar el menuRecanvis amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut tallerActual no és null
       
     Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     Opció 1. Alta -->         Crea un recanvi del taller actual. Penseu que Taller sap crear recanvis        
     Opció 2. Modificar -->     Permet modificar un recanvi que està donat d'alta al taller actual
     (per comprovar l'existència del recanvi tenim un mètode en la classe Taller que ens ajuda)
     Opció 3. Llista de recanvis --> Imprimeix les dades dels recanvis del taller actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     */
    public static void menuRecanvis() {
        
        int opcion;
        int indexRecanvi = -1;
        String codi;
        
        do {
            System.out.println("indique la opcion");
            System.out.println(" \n 0. para salir");
            System.out.println(" \n 1. Alta Recambios");
            System.out.println(" \n 2. Modificar Recambios");
            System.out.println(" \n 3. Listado de Recambios");
           
            opcion = DADES.nextInt();
            
            switch(opcion) {
                case 0:
                    break;
                case 1:
                    tallerActual.addRecanvi();
                    pTallers++;
                    System.out.println("Recambio dado de alta");
                    break;
                case 2:
                    System.out.println("Indique codigo del recambio");
                    codi = DADES.next();
                    indexRecanvi = tallerActual.selectRecanvi(codi);
                    if(indexRecanvi >= 0) {
                        tallerActual.getRecanvis()[indexRecanvi].updateRecanvi();
                    } else {
                        System.out.println("Recambio no encontrado");
                    }
                    
                    break;
                case 3:
                    for(int i = 0; i < tallerActual.getpRecanvis(); i++) {
                        tallerActual.getRecanvis()[i].showRecanvi();
                    }
                    break;
                default:
                    System.out.println("debe de elegir una de las opciones del menu");
                    break;
            }
        } while(opcion != 0);
    }

    /*
     TODO Heu de desenvolupar el menuReparacions amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut tallerActual no és null
       
     Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     Opció 1. Alta -->         Crea una reparació del taller actual. Penseu que Taller sap crear reparacions        
     Opció 2. Modificar -->    Permet modificar una reparació que està donat d'alta al taller actual
     (per comprovar l'existència de la reparació tenim un mètode en la classe Taller que ens ajuda)     
     Opció 3. Assignar client o clienta -->   Assigna un client o clienta a una reparació, però penseu que Taller sap com fer-ho
     Opció 4. Assignar mecànic o mecànica -->   Assigna un mecànic o mecànica a una reparació, però penseu que Taller sap com fer-ho
     Opció 5. Assignar recanvi -->   Assigna un recanvi a una reparació però penseu que Taller sap com fer-ho
     Opció 6. Calcular preu -->   Calcula el preu d'una reparació però penseu que Taller sap com fer-ho
     Opció 7. Llista de reparacions --> Imprimeix les dades de les reparacions del taller actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     */
    public static void menuReparacions() {
       
        int opcion;
        String codi;
        int indexReparacio = -1;
        
        do {
            System.out.println("indique la opcion");
            System.out.println(" \n 0. para salir");
            System.out.println(" \n 1. Alta Reparacion");
            System.out.println(" \n 2. Modificar Reparacion");
            System.out.println(" \n 3. Asignar cliente");
            System.out.println(" \n 4. Asignar mecanico");
            System.out.println(" \n 5. Asignar recambio");
            System.out.println(" \n 6. Calcular precio");
            System.out.println(" \n 7. Listado de reparaciones");
           
            opcion = DADES.nextInt();
            
            switch(opcion) {
                
                case 0:
                    break;
                case 1:
                    tallerActual.addReparacio();
                    pTallers++;
                    System.out.println("Reparacion dada de alta");
                    break;
                case 2:
                    System.out.println("Indique codigo reparacion");
                    codi = DADES.next();
                    indexReparacio = tallerActual.selectReparacio(codi);
                    if(indexReparacio >= 0) {
                        tallerActual.getReparacions()[indexReparacio].updateReparacio();
                    } else {
                        System.out.println("Codigo no encontrado");
                    }
                    break;
                case 3:
                    tallerActual.addClientReparacio();
                    pTallers++;
                    break;
                case 4:
                    tallerActual.addMecanicReparacio();
                    pTallers++;
                    break;
                case 5:
                    tallerActual.addRecanviReparacio();
                    pTallers++;
                    break;
                case 6:
                    tallerActual.calcularPreuReparacio();
                    break;
                case 7:
                    for(int i = 0; i < tallerActual.getpReparacions(); i++) {
                        tallerActual.getReparacions()[i].showReparacio();
                    }
                    break;
                default:
                    System.out.println("Debe de elegir una de las opciones del menu");
                    break;
                    
            }
            
        } while(opcion != 0);
    }

    public static Integer selectTaller() {

        System.out.println("\nCIF del taller?:");
        String cif = DADES.next();

        for (int i = 0; i < pTallers; i++) {
            if (tallers[i].getCif().equals(cif)) {
                return i;
            }
        }
        return -1;
    }

}
