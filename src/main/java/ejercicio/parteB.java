
package ejercicio;

import java.util.Scanner;


public class parteB {

   
    public static void main(String[] args) {
       //PARTE B
       /*Modifica el programa anterior para que realice discriminación horaria y ajuste
       el precio de la energía en función de ese horario. Para ello hay que saber cuántas
       horas está funcionando el aparato en horas punta, cuántas en horas llanas y cuántas
       en horas valle. Cada uno de esos tramos horarios tiene un precio del kWh diferente,
       que el usuario introducirá por teclado teniendo en cuenta que el precio en horas punta
       es el más caro, luego sigue el precio en horas llanas y finalmente el precio más barato
       es el de horas valle, sabiendo que todos los precios estarán dentro del rango 0.1 y 0.45.
       Por lo tanto, el precio final dependerá de los consumos realizados en dichos tramos y el precio en cada tramo.
        
       Por ejemplo, una lavadora consume 450Wh y tarda 2.5h en hacer la colada. De esas 2.5 horas,
       1 hora lava en hora punta y la otra hora y media el consumo se realiza en horas llanas.
       Si el precio del kWh en horas punta es 0.31, en horas llanas 0.27 y en horas valle 0.18,
       el gasto final sería la suma del consumo en cada tramo por el precio del kWh en cada tramo: 
       0.45kWh * 1 h * 0.31€/kWh = 0.13€ (hora punta)
       0.45kWh * 1.5 h * 0.27€/kWh = 0.18€ (hora llana)
       0.45kWh * 0 h * 0.18€/kWh = 0€ (hora valle)
       El precio final de la colada es 0.31€.*/
       
        /*Inicializo Scanner y declaro las variables tipo double consumo, horas y preciokWh para su
        posterior uso.*/
        Scanner entrada = new Scanner(System.in);
        double consumo;
        double horas;
        double preciokWh;
        //Agrego variables para los distintos tipos de horarios.
        double punta;
        double llana;
        double valle;
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

    
   

