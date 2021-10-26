package ejercicio;

import java.util.Scanner;

public class parteA {

    public static void main(String[] args) {
        //PARTE A
        /*Por todos es sabido que el precio de la energía no para de subir, y en concreto,
        la luz que se paga en los hogares está a un precio astronómico.
        
        La idea es que realices una calculadora de consumo eléctrico, de forma que se pueda
        introducir el consumo en vatios de un aparato (entre 1 y 4500), las horas que está
        funcionando al día y el precio del kWh (entre 0.1 y 0.45) para saber cuántos € hay
        que pagar por el consumo de ese aparato.
        
        Por ejemplo, una lavadora consume 450Wh y tarda 2.5h en hacer la colada, en total
        consume 1.12kW en esas dos horas y media. Suponiendo un precio de 0.30€/kWh
        entonces la lavadora ha gastado en lavar la ropa: 1.12kW*0.3€/kWh = 0.33€.*/

        /*Inicializo Scanner y declaro las variables tipo double consumo, horas y preciokWh para su
        posterior uso.*/
        Scanner entrada = new Scanner(System.in);
        double consumo;
        double horas;
        double preciokWh;
        //Creamos menú para que interaccione el usuario.
        System.out.println("Menú de opciones");
        System.out.println("-----------------");
        System.out.println("Opción 1. Utilizar calculadora de consumo.");
        System.out.println("Opción 2. Salir del programa.");
        //Declaro opcion para poder utilizarla dentro y fuera del do-while.
        int opcion;
        //Comienzo el programa con un do-while.
        do {
            System.out.println("\nElija una opción:");
            opcion = entrada.nextInt();
            /*Dentro del do, pongo un switch con dos opciones diferentes: una que nos
            permite seguir con la calculadora, y otra para finalizar el programa.*/            
            switch (opcion) {
                case 1:
                    /*En la primera opción tendremos varios do-while, en función de
                    los datos que solicite la calculadora, tres en este caso*/
                    do {
                        System.out.println("Introduzca la cantidad de consumo en W/h del aparato (entre 1 W/h y 4500 W/h: ");
                        consumo = entrada.nextDouble();
                    } while (consumo < 1 || consumo > 4500);
                    //Solicitamos al usuario la cantidad de horas que ha estado funcionando el aparato.
                    do {
                        System.out.println("Introduzca cuántas horas ha estado encendido el aparato (entre 0 y 24): ");
                        horas = entrada.nextDouble();
                    } while (horas < 0 || horas > 24); //El 24 es la cantidad de horas del día, tal y como pone el enunciado.
                    //Solicitamos al usuario el precio del kWh que tiene contratado, entre 0.1 y 0.45.
                    do {
                        System.out.println("Introduzca el precio del kWh contratado (entre 0,1 y 0,45): ");
                        preciokWh = entrada.nextDouble();
                    } while (preciokWh < 0.1 || preciokWh > 0.45);

                    /*Realizamos la operación para calcular el precio final del consumo del aparato,
                    guardándolo en una nueva variable. Inicializo una nueva variable para convertir
                    vatios/hora a kilovatios/hora*/
                    final double CONVERSION = consumo / 1000;
                    double precioFinal = (CONVERSION * horas * preciokWh);
                    System.out.printf("%nEl gasto final del aparato es de: %.2f", precioFinal);
                    System.out.print("€");
                    break;
                case 2:
                    //En la segunda opción finalizamos el programa
                    System.out.println("Ha elegido salir del programa.");
                    break;
                default:
                    System.out.println("Utilice opción 1 o 2.");
                    /*En default almaceno un sout a mostrar en caso de no cumplir el 
                    while final*/
            }
        } while (opcion != 2); /*Finalizamos el do-while principal, obligando teclear
                                 el número 2 al usuario.*/
    }
}
