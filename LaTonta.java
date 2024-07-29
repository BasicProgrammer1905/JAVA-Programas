import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LaTonta{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocalDateTime fechaactual = LocalDateTime.now();
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("ddMMyyyy");
        String fecha = fechaactual.format(formato1);
        String fechaCorrelativo = fechaactual.format(formato2);
        System.out.println("\nBienvenido al portal de ventas.\nFecha: "+fecha+"\n");
        boolean t = true;
        Ventas ventas = new Ventas();
        int n = 0;
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;

        System.out.println("Ingrese la capacidad máxima de las localidades:");
        int leroCapacidad = teclado.nextInt();
        int BVIP = leroCapacidad - l1;
        int PT = leroCapacidad - l2;
        int B3 = leroCapacidad - l3;

        while (t == true){
            System.out.println("\nPor favor, escoja una de las opciones:\n1.) Ver disponibilidad total.\n2.) Ver disponibilidad individual.\n3.) Registro de caja.\n4.) Reservar boletos.\n5.) Salir.");
            int opcion1 = teclado.nextInt();
            teclado.nextLine();

            if (opcion1 == 1){
                System.out.println("En Balcón VIP se han vendido "+l1+" boletos.\nEn Platea se han vendido "+l2+" boletos.\nEn Balcón 3 se han vendido "+l3+" boletos.\nQuedan "+(3*leroCapacidad - l1 - l2 - l3)+" boletos disponibles en el edificio.");
            }

            if (opcion1 == 2){
                System.out.println("Escoja la localidad que desee: Balcón VIP (1), Platea (2), Balcón 3 (3)");
                int opcion2 = teclado.nextInt();
                if (opcion2 == 1){
                    System.out.println("En Balcón VIP quedan "+BVIP+" boletos disponibles.");
                }
                if (opcion2 == 2){
                    System.out.println("En Platea quedan "+PT+" boletos disponibles.");
                }
                if (opcion2 == 3){
                    System.out.println("En Balcón 3 quedan "+B3+" boletos disponibles.");
                }
            }

            if (opcion1 == 3){
                System.out.println("Se ha vendido un total de Q"+(1800*l1+600*l2+300*l3)+".");
            }

            if (opcion1 == 4){
                if (leroCapacidad > 0){
                    System.out.println("Ingrese la localidad que desea:\nBalcón VIP: 1\nPlatea: 2\nBalcón 3: 3");
                    int leroPos = teclado.nextInt();
                    teclado.nextLine();
                    ventas.setLocalidad(leroCapacidad, leroPos);
    
                    n = n+1;
    
                    System.out.println("Ingrese su nombre:");
                    String leroNombre = teclado.nextLine();
                    System.out.println("Ingrese su correo:");
                    String leroEmail = teclado.nextLine();
                    System.out.println("Ingrese la cantidad de boletos deseada (si se excede de lo disponible, se le dará la mayor cantidad posible menor a 6). Disponibles: "+leroCapacidad);
                    int leroCant = teclado.nextInt();
                    
                    if (leroCant > 0 && leroCant < 7){
                        System.out.println("Ingrese su presupuesto máximo:");
                        float leroPresu_Max = teclado.nextFloat();
    
                        if (leroPos == 1 && BVIP >= 6){
                            if (leroPresu_Max >= 1800*leroCant){
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l1 = l1+leroCant;
                            }
    
                            if (leroPresu_Max < 1800*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }

                        if (leroPos == 2 && PT >= 6){
                            if (leroPresu_Max >= 600*leroCant){
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l2 = l2+leroCant;
                            }
    
                            if (leroPresu_Max < 1800*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }

                        if (leroPos == 3 && B3 >= 6){
                            if (leroPresu_Max >= 300*leroCant){
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l3 = l3+leroCant;
                            }
    
                            if (leroPresu_Max < 1800*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }

                        if (leroPos == 1 && BVIP < 6 && BVIP > 0){
                            if (leroPresu_Max >= 1800*leroCant){
                                leroCant = BVIP;
                                BVIP = 0;
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l1 = l1+leroCant;
                            }
    
                            if (leroPresu_Max < 1800*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }
    
                        if (leroPos == 2 && PT < 6 && PT > 0){
                            if (leroPresu_Max >= 600*leroCant){
                                leroCant = PT;
                                PT = 0;
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l2 = l2+leroCant;
                            }
    
                            if (leroPresu_Max < 600*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }
    
                        if (leroPos == 3 && B3 < 6 && B3 > 0){
                            if (leroPresu_Max >= 300*leroCant){
                                leroCant = B3;
                                B3 = 0;
                                String leroCorrelativo = ""+fechaCorrelativo+""+n;
                                ventas.setReservacion(leroNombre, leroEmail, leroCant, leroPresu_Max, leroCorrelativo, ventas.getLocalidad());
                                System.out.println("Compra exitosa.\nCorrelativo de compra: "+leroCorrelativo);
                                l3 = l3+leroCant;
                            }
    
                            if (leroPresu_Max < 300*leroCant){
                                System.out.println("El presupuesto máximo no es suficiente para comprar los boletos. Venda helados y vuelva pronto.");
                            }
                        }

                        if (leroPos == 1 && BVIP == 0){
                            System.out.println("Compra no válida. No hay boletos disponibles.");
                        }

                        if (leroPos == 2 && PT == 0){
                            System.out.println("Compra no válida. No hay boletos disponibles.");
                        }

                        if (leroPos == 3 && B3 == 0){
                            System.out.println("Compra no válida. No hay boletos disponibles.");
                        }
                    }
                    
                    else{
                        System.out.println("Lo siento, ha ingresado una cantidad de boletos no permitida. Intente de nuevo");
                        t = false;
                    }
                }

                else{
                    System.out.println("Número inválido. La capacidad debe ser mayor a cero.");
                }
            }

            if (opcion1 == 5){
                System.out.println("Muchas gracias por utilizar el programa.");
                System.exit(0);
            }
        }
    }
}