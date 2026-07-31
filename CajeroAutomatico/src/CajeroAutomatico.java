import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido al Cajero Automático");

        Scanner scanner = new Scanner(System.in);

        int pinSecreto = 1234;
        double saldo = 1000;
        int pinIngresado = 0;
        int numIntentos = 0;
        
        while (pinIngresado != pinSecreto && numIntentos < 3) {

            System.out.println("Ingrese su PIN:");
            pinIngresado = scanner.nextInt();


            if (pinIngresado == pinSecreto){
                String opcion;
                System.out.println("PIN correcto. Accediendo a su cuenta...");
                do {
                    System.out.println("Seleccione una opción:");
                    System.out.println("a. Consultar saldo");
                    System.out.println("b. Depositar dinero");
                    System.out.println("c. Retirar dinero");
                    System.out.println("d. Salir");

                    opcion = scanner.next();
                    switch (opcion){
                        case "a":
                            System.out.println("Su saldo es: " + saldo);
                            break;
                        case "b":
                            System.out.println("Ingrese la cantidad a depositar:");
                            double deposito = scanner.nextDouble();
                            saldo += deposito;
                            System.out.println("Depósito exitoso. Su nuevo saldo es: " + saldo);
                            break;
                        case "c":
                            System.out.println("Ingrese la cantidad a retirar:");
                            double retiro = scanner.nextDouble();
                            if (retiro <=saldo){
                                saldo -= retiro;
                                System.out.println("Retiro exitoso. Su nuevo saldo es: " + saldo);
                            } else {
                                System.out.println("Fondos insuficientes.");
                            }
                            break;
                        case "d":
                            System.out.println("Gracias por usar el Cajero Automático. ¡Hasta luego!");
                            break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (!opcion.equals("d"));
            }else{   
                System.out.println("PIN incorrecto. Intente nuevamente.");
                numIntentos++;
                System.out.println("Intentos restantes: " + (3 - numIntentos));
            }
            
        }

    }
}
