package principal;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Application {

    private final static Scanner DADES = new Scanner(System.in);

    private static Taller[] tallers = new Taller[10];
    private static int pTallers = 0; //Priemra posició buida del vector tallers
    private static Taller tallerActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de tallers");
            System.out.println("\n2. Gestió de components");
            System.out.println("\n3. Gestió de reparacions");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuTallers();
                    break;
                case 2:
                    if (tallerActual != null) {
                        menuComponents();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el taller al menú Gestió de tallers");
                    }
                    break;
                case 3:
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
                        tallers[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquest taller");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pTallers; i++) {
                        tallers[i].showComponent();
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
    
    
    /* case 3:
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
                    break;*/
    public static void menuComponents() {
        int opcio = 0;
        int client = -1;
        String nif;
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Clientes");
            System.out.println("\n2. Mecanicos");
            System.out.println("\n3. Recambios");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    do {
                         System.out.println("\nSelecciona una opció");
                         System.out.println("\n 0. Sortir");
                         System.out.println("\n 1. para Alta");
                         System.out.println("\n 2. para Modificar");
                         System.out.println("\n 3. para ver Clientes registrados");
                         opcio = DADES.nextInt();
                         
                         switch(opcio) {
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
                                client = tallerActual.selectComponent(1, nif);
                                if(client >= 0) { // RECIBE RESPUESTA DEL METODO "SELECT CLIENT"
                                    tallerActual.getComponents()[client].updateComponent(); // UBICA AL CLIENT CON "GETCLIENTS" [INDICE DESDE 0] Y ACTUALIZA AL ENCONTRADO
                                } else {
                                    System.out.println("Cliente no encontrado");
                                }
                                break;
                            case 3 :
                                for(int i = 0; i < tallerActual.getpComponents(); i++) {  // UBICA LA LONGITUD DEL ARRAY "CLIENTS" DE TALLER CON EL INDICE DE PCLIENTS
                                    tallerActual.getComponents()[i].showComponent();
                                    }
                                break;
                            default:
                                System.out.println("debe de seleccionar una de las opciones del menu");
                                break;
                
                            }
                        } while(opcio != 0);
                    break;
                case 2:

                    do {
                        System.out.println("\nSelecciona una opció");
                        System.out.println("\n0. Sortir");
                        System.out.println("\n1. Alta");
                        System.out.println("\n2. Modificar");
                        System.out.println("\n3. Llista de mecànics i mecàniques");
                        opcio = DADES.nextInt();
                        switch (opcio) {
                            case 0:
                                break;
                            case 1:
                                tallerActual.addMecanic();
                                break;
                            case 2:
                                int indexSel = tallerActual.selectComponent(2,null);
                                if (indexSel >= 0) {
                                    tallerActual.getComponents()[indexSel].updateComponent();
                                } else {
                                    System.out.println("\nNo existeix aquest mecànic o mecànica");
                                }
                                break;
                            case 3:
                                for (int i = 0; i < tallerActual.getpComponents(); i++) {
                                    tallerActual.getComponents()[i].showComponent();
                                }
                                break;
                            default:
                                System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                                break;
                        }
                    } while (opcio != 0);
                case 3:
                   do {
                       System.out.println("\nSelecciona una opció");
                       System.out.println("\n0. Sortir");
                       System.out.println("\n1. Alta");
                       System.out.println("\n2. Modificar");
                       System.out.println("\n3. Llista de recanvis");
                       opcio = DADES.nextInt();
                       switch (opcio) {
                           case 0:
                               break;
                           case 1:
                               tallerActual.addRecanvi();
                               break;
                           case 2:
                               int indexSel = tallerActual.selectComponent(3, null);
                               if (indexSel >= 0) {
                                   tallerActual.getComponents()[indexSel].updateComponent();
                               } else {
                                   System.out.println("\nNo existeix aquest recanvi");
                               }
                               break;
                           case 3:
                               for (int i = 0; i < tallerActual.getpComponents(); i++) {
                                   tallerActual.getComponents()[i].showComponent();
                               }
                               break;
                           default:
                               System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                               break;
            }
        } while (opcio != 0);
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
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
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Assignar client o clienta");
            System.out.println("\n4. Assignar mecànic o mecànica");
            System.out.println("\n5. Assignar recanvi");
            System.out.println("\n6. Calcular preu");
            System.out.println("\n7. Llista de reparacions");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    tallerActual.addReparacio();
                    break;
                case 2:
                    int indexSel = tallerActual.selectComponent(4,null);
                    if (indexSel >= 0) {
                        tallerActual.getComponents()[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquesta reparació");
                    }
                    break;
                case 3:
                    tallerActual.addClientReparacio();
                    break;
                case 4:
                    tallerActual.addMecanicReparacio();
                    break;
                case 5:
                    tallerActual.addRecanviReparacio();
                    break;
                case 6:
                    tallerActual.calcularPreuReparacio();
                    break;
                case 7:
                    for (int i = 0; i < tallerActual.getpComponents(); i++) {
                        tallerActual.getComponents()[i].showComponent();
                    };
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
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
