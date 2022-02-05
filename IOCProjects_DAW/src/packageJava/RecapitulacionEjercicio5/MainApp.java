package packageJava.RecapitulacionEjercicio5;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        Conductor conductor = new Conductor();
        Usuario usuario;
        String name,destino;
        int edad;
        String [] destinos = {"Tarragona", "Reus", "Vilanova", "El vendrell", "Barcelona"};// ARRAY DE RUTAS
        System.out.println("Desea realizar compra de billete?");
        String question = ask.next().toLowerCase();
        
        if(question.equals("si")){ // CONDICIONAL DE INICIO DEL PROGRAMA
           System.out.println("Hola, soy el conductor " + conductor.getName());
           System.out.println("Indiqueme su nombre");
           name = ask.next();
           System.out.println("Indiqueme su edad");
           edad = ask.nextInt();
           System.out.println("La ruta que cubre el autobús es la siguiente:");
           for(int i = 0; i < destinos.length; i++){// IMPRESIÓN DEL ARRAY QUE CONTIENE LAS RUTAS
               System.out.println(destinos[i]);
           }
           System.out.println("Indiqueme su eleccion");
           destino = ask.next().toLowerCase();// CONDICIONAL PARA QUE LA LETRA SIEMPRE ESTÉ EN MINÚSCULAS
           usuario = new Usuario(name, edad, destino);
           //VERIFICA SI EL DESTINO NO ESTÁ VETADO
           if(usuario.DestinoVerificado()){
               System.out.println("Lo siento, este autobus ya acabó su ruta hacia Barcelona, aborde otra unidad");
               System.out.println("Indique con 'SI' o 'NO' si desea abordar otra unidad");
               String respuesta1 = ask.next().toLowerCase();
               //RETORNA EL BUCLE DE UBICAR UNA UNIDAD SEGÚN EL DESTINO
                if(respuesta1.equals("si")){
                    try{
                        System.out.println("Hola, soy el conductor " + conductor.getName());
                        System.out.println("Indiqueme su nombre");
                        name = ask.next();
                        System.out.println("Indiqueme su edad");
                        edad = ask.nextInt();
                        System.out.println("La ruta que cubre el autobús es la siguiente:");
                        for(int i = 0; i < destinos.length; i++){// IMPRESIÓN DEL ARRAY QUE CONTIENE LAS RUTAS
                            System.out.println(destinos[i]);
                        }
                        System.out.println("Indiqueme su eleccion");
                        destino = ask.next().toLowerCase();// CONDICIONAL PARA QUE LA LETRA SIEMPRE ESTÉ EN MINÚSCULAS
                        usuario = new Usuario(name, edad, destino);
                        System.out.println("El costo del viaje es de 4 euros");// ESTÁ DECLARADO COMO CONSTANTE EL PRECIO
                        System.out.println("Indiqueme su eleccion \n1.-Pago con tarjeta \n2.-Pago en efectivo ");
                        int respuesta = ask.nextInt();
                        //EN CASO DE ESCOGER EL PAGO RETORNAR EL VUELTO
                        if(respuesta == 2){
                            System.out.println("Indiqueme cantidad a abonar");
                            double cantidad = ask.nextDouble();
                            System.out.println("Los datos de su conductor son : " + conductor.toString());
                            System.out.println("Los datos de su compra son los siguientes \n" + usuario.toString() + "\nCambio del ticket " + usuario.darCambio(cantidad));
                        } else {
                             System.out.println("Los datos de su compra son los siguientes \n" + usuario.toString());
                             System.out.println("Gracias por su compra");
                        }
                    //EXCEPCION QUE CIERRA EL PROGRAMA
                    } catch(Exception e){
                             System.out.println("Adeu..");
                             ask.close();
                    }
                }else{
                    System.out.println("Adeu..");
                    ask.close();
                }
             //SIE L DESTINO NO ESTÁ BLOQUEADO CONTINÚA CON LA VENTA DEL PASAJE
            } else {
                    System.out.println("El costo del viaje es de 4 euros");// ESTÁ DECLARADO COMO CONSTANTE EL PRECIO
                    System.out.println("Indiqueme su eleccion \n1.-Pago con tarjeta \n2.-Pago en efectivo ");
                    int respuesta = ask.nextInt();
                    if(respuesta == 2){
                        System.out.println("Indiqueme cantidad a abonar");
                        double cantidad = ask.nextDouble();
                        System.out.println("Los datos de su conductor son : " + conductor.toString());
                        System.out.println("Los datos de su compra son los siguientes \n" + usuario.toString() + "\nCambio del ticket " + usuario.darCambio(cantidad));
                        } else {
                            System.out.println("Los datos de su compra son los siguientes \n" + usuario.toString());
                            System.out.println("Gracias por su compra");
                        }
                    }
        //SI RESPUESTA INICIAL ES NO, SOLO SALE DEL PROGRAMA
        }else{
            System.out.println("Adeu..");
        }
    }
    
}
