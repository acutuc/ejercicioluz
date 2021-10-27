
package ejercicio;

import java.util.Scanner;


public class ParteB {

   
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
       
        /*Inicializo Scanner y declaro la variable tipo double consumopara su
        posterior uso.*/
        Scanner entrada = new Scanner(System.in);
        double consumo;
        //Agrego variables para los distintos tipos de horarios.
        double horaPunta;
        double horaLlana;
        double horaValle;
        double precioPunta;
        double precioLlana;
        double precioValle;
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
                    //Solicitamos al usuario las horas según el tramo horario, y el precio de cada tramo.
                    do {
                        System.out.println("Introduzca cuántas horas ha estado encendido el aparato en horas valle (entre las 0h y 8h): ");
                        horaValle = entrada.nextDouble();
                        System.out.println("Precio kWh en horas valle (0,1 a 0,15: ");
                        precioValle = entrada.nextDouble();
                    } while ((horaValle <= 0 || horaValle > 24) && (precioValle <0.1 || precioValle > 0.15));
                    do {
                        System.out.println("Introduzca cuántas horas ha estado encendido el aparato en horas llana (entre las 08h y 10h, 14h y 18h, y 22h a 00h): ");
                        horaLlana = entrada.nextDouble();
                        System.out.println("Precio kWh en horas llana (0,15 a 0,30: ");
                        precioLlana = entrada.nextDouble();
                    } while ((horaLlana <= 0 || horaLlana > 24) && (precioLlana < 0.15 || precioLlana > 0.30));
                    do {
                        System.out.println("Introduzca cuántas horas ha estado encendido el aparato en horas punta (entre las 10h y 14h, y 18h a 22h): ");
                        horaPunta = entrada.nextDouble();
                        System.out.println("Precio kWh en horas punta (0,30 a 0,45: ");
                        precioPunta = entrada.nextDouble();
                    } while ((horaPunta <= 0 || horaPunta > 24) && (precioPunta < 0.30 || precioPunta > 0.45));
                    
                    /*Realizamos la operación para calcular el precio final del consumo del aparato,
                    guardándolo en nuevas variables según el tramo horario. Inicializo una nueva variable para convertir
                    vatios/hora a kilovatios/hora*/
                    final double CONVERSION = consumo / 1000;
                    double precioFinalLlana = (CONVERSION * horaValle * precioValle);
                    double precioFinalValle = (CONVERSION * horaLlana * precioLlana);
                    double precioFinalPunta = (CONVERSION * horaPunta * precioPunta);
                    double precioFinalFinalisimo = precioFinalLlana + precioFinalValle + precioFinalPunta;
                    System.out.printf("%nEl gasto final del aparato es de: %.2f", precioFinalFinalisimo);
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

    
   

