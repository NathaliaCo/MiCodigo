package Vista;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Gestion.*;
import Modelo.Equipo;
import Modelo.Jugador;

public class Menu {
    public void mostrarMenu() throws InterruptedException {
        gestorVariable gestor = new gestorVariable();
        gestorEquipos gestorE = new gestorEquipos();
        gestorPartida gestorP = new gestorPartida();
        gestorTablas gestorT = new gestorTablas();
        gestorCampeonato gestorC = new gestorCampeonato();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {

            ArrayList<Equipo> equipos = gestor.setEquipos();

            String promptEquipos = "";

            System.out.println("\nBienvenido al sistema de gestión de equipos para el campeonato de futbol AZTECA 2022");
            System.out.println("1. Gestionar equipos");
            System.out.println("2. Tabla de posiciones");
            System.out.println("3. Resultados de la jornada");
            System.out.println("4. Tabla de goleadores");
            System.out.println("5. Iniciar juego");
            System.out.println("6. Ingresar resultado");
            System.out.println("7. Simular campeonato");
            System.out.println("9. Salir");

            for(Equipo equipo : equipos) {
                if(equipo.isJugando()){
                    promptEquipos += equipo.getNombre() + " ";
                }
            }

            if(promptEquipos.length() > 0){
                System.out.println("\nEquipos jugando: " + promptEquipos);
            }


            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    gestorE.Iniciar();
                    break;
                case 2:
                    gestorT.tablaDePosiciones();
                    break;
                case 3:
                    if(gestorP.jornada.isEmpty()) {
                        System.out.println("No hay partidos jugados");
                    } else {
                        for(String partido : gestorP.jornada) {
                            System.out.println("\n" + partido);
                        }
                        TimeUnit.SECONDS.sleep(2);
                    }
                    break;
                case 4:
                    int opcionSubMenu = 0;
                    Scanner sc2 = new Scanner(System.in);
                    do{
                        System.out.println("\n1. Tabla de goleadores general");
                        System.out.println("2. Tabla de goleadores del último partido");
                        System.out.println("0. Volver al menú principal");

                        opcionSubMenu = sc2.nextInt();
                        switch (opcionSubMenu) {
                            case 1:
                                gestorT.tablaJugadores();
                                opcionSubMenu = 0;
                                break;
                            case 2:
                                if(gestorP.golesPartido.isEmpty()) {
                                    System.out.println("No hay partidos jugados");
                                    opcionSubMenu = 0;
                                } else {
                                    for(String partido : gestorP.golesPartido) {
                                        System.out.println("\n" + partido);
                                    }
                                    opcionSubMenu = 0;
                                    TimeUnit.SECONDS.sleep(2);
                                }
                                break;
                            default:
                                break;
                        }
                    }while (opcionSubMenu != 0);
                    break;
                case 5:
                    boolean jugando = false;
                    for(Equipo equipo : equipos) {
                        if (equipo.isJugando()) {
                            System.out.println("\nYa hay un partido en curso");
                            TimeUnit.SECONDS.sleep(2);
                            opcion = 0;
                            jugando = true;
                            break;
                        }
                    }
                    if(!jugando) {
                        gestorP.Inicio();
                    }
                    break;
                case 6:
                    boolean jugando2 = false;
                    for(Equipo equipo : equipos) {
                        if (equipo.isJugando()) {
                            opcion = 0;
                            jugando2 = true;
                        }
                    }
                    if(!jugando2) {
                        System.out.println("\nNo hay partidos en curso");
                        TimeUnit.SECONDS.sleep(2);
                    } else {
                        gestorP.ingresaResultados();
                    }
                    break;
                case 7:
                    gestorC.crearCampeonato();
                    break;
                case 9:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 9);
    }

}
