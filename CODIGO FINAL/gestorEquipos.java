package Gestion;

import Modelo.Equipo;
import Modelo.Jugador;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class gestorEquipos {
    gestorVariable gestor = new gestorVariable();
    ArrayList<Equipo> equipos = gestor.setEquipos();
    ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);

    String ruta = "src/Archivo/Jugadores";

    public void Iniciar() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n============================================");
            System.out.println("Seleccione el equipo que desea gestionar");
            System.out.println("1. Argentina");
            System.out.println("2. Bolivia");
            System.out.println("3. Brasil");
            System.out.println("4. Colombia");
            System.out.println("5. Chile");
            System.out.println("6. Venezuela");
            System.out.println("9. Volver");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    this.menu(equipos.get(0));
                    break;
                case 2:
                    this.menu(equipos.get(1));
                    break;
                case 3:
                    this.menu(equipos.get(2));
                    break;
                case 4:
                    this.menu(equipos.get(3));
                    break;
                case 5:
                    this.menu(equipos.get(4));
                    break;
                case 6:
                    this.menu(equipos.get(5));
                    break;
            }
        }while (opcion !=9);


    }

    private void menu(Equipo equipo) throws InterruptedException {
        ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\nGestor de equipo: " + equipo.getNombre());
            System.out.println("1. Ver jugadores");
            System.out.println("2. Cambiar de posición a un jugador");
            System.out.println("3. Ingresa un nuevo jugador");
            System.out.println("4. Sustituir un jugador");
            System.out.println("5. Escoger capitán");
            System.out.println("6. Cambiar estado");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    for (Jugador jugador : jugadores) {
                        if (jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                            System.out.printf("Nombre: %s | Posición: %s%n", jugador.getNombre(), jugador.getPosicion());
                        }
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Diga el nombre del jugador a cambiar de posición");
                    String nombre = sc.nextLine();
                    boolean encontrado = false;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                            System.out.println("Ingrese la nueva posición del jugador");
                            nombre = sc.nextLine();
                            while(!nombre.equalsIgnoreCase("arquero")
                                    && !nombre.equalsIgnoreCase("defensa")
                                    && !nombre.equalsIgnoreCase("lateral")
                                    && !nombre.equalsIgnoreCase("delantero")
                                    && !nombre.equalsIgnoreCase("centro campista")){
                                System.out.println("Ingrese una posición válida");
                                nombre = sc.nextLine();
                            }
                            nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
                            jugador.setPosicion(nombre);
                            this.reemplazarArchivo(jugadores);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n[Jugador no encontrado]");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    break;
                case 3:
                    int cont = 0;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                            cont++;
                        }
                    }
                    if (cont < 17) {
                        this.nuevoJugador(equipo);
                    } else {
                        System.out.println("\n[El equipo ya tiene 17 jugadores]");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Diga el nombre del jugador a sustituir");
                    nombre = sc.nextLine();
                    encontrado = false;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                            this.sustituirJugador(equipo, jugador);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n[Jugador no encontrado]");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    break;
                case 5:
                    this.cambiarCapitan(equipo);
                    break;
                case 6:
                    if(equipo.isJugando()) {
                        equipo.setJugando(false);
                        this.reemplazarArchivoEquipo();
                    }else{
                        equipo.setJugando(true);
                        this.reemplazarArchivoEquipo();
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private void cambiarCapitan(Equipo equipo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Diga el nombre del jugador a escoger como capitán");
        String nombre = sc.nextLine();
        boolean encontrado = false;

        for(Jugador jugadorV : jugadores){
            if((jugadorV.getDT()) && jugadorV.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())){
                jugadorV.setDT(false);
            }
        }

        for (Jugador jugadorN : jugadores) {
            if (jugadorN.getNombre().equalsIgnoreCase(nombre) && jugadorN.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                jugadorN.setDT(true);
                this.reemplazarArchivo(jugadores);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\n[Jugador no encontrado]");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private void sustituirJugador(Equipo equipo, Jugador jugadorV) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Diga el nombre del jugador que reemplazará a " + jugadorV.getNombre());
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (Jugador jugadorN : jugadores) {
            if (jugadorN.getNombre().equalsIgnoreCase(nombre) && jugadorN.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                if(jugadorV.getCancha().equalsIgnoreCase("Cancha")){
                    jugadorN.setCancha("Cancha");
                    jugadorV.setCancha("Banca");
                }else if(jugadorV.getCancha().equalsIgnoreCase("Banca")){
                    jugadorN.setCancha("Banca");
                    jugadorV.setCancha("Cancha");
                }
                this.reemplazarArchivo(jugadores);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\n[Jugador no encontrado]");
            TimeUnit.SECONDS.sleep(1);
        }

    }

    private void reemplazarArchivo(ArrayList<Jugador> jugadores) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file,false);
            PrintWriter pw = new PrintWriter(fr);
            for(Jugador jugador:jugadores) {
                pw.println(jugador);
            }
            pw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reemplazando archivo");
        }
    }

    private void nuevoJugador(Equipo equipo){
        Scanner sc = new Scanner(System.in);
        int contB = 0;
        int contC = 0;

        System.out.println("Ingrese el nombre del jugador");

        String nombreJugador = sc.nextLine();
        nombreJugador = nombreJugador.toUpperCase();

        for(Jugador jugador:jugadores){
            if(jugador.getNombre().equalsIgnoreCase(nombreJugador) && jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())){
                System.out.println("\n[El jugador ya existe]");
                return;
            }
        }

        System.out.println("Ingrese la posición del jugador");
        String posicion = sc.nextLine();
        posicion = posicion.substring(0, 1).toUpperCase() + posicion.substring(1).toLowerCase();

        for(Jugador jugador:jugadores) {
            if (jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())) {
                if (jugador.getCancha().equalsIgnoreCase("Banca")) {
                    contB++;
                } else {
                    contC++;
                }
            }
        }

        if(contC < 11) {
            Jugador jugadorN = new Jugador(nombreJugador, posicion, equipo, "Cancha", false, 0);
            jugadores.add(jugadorN);
        } else if (contB < 6) {
            Jugador jugadorN = new Jugador(nombreJugador, posicion, equipo, "Banca", false, 0);
            jugadores.add(jugadorN);
        }

        this.reemplazarArchivo(jugadores);

    }

    private void reemplazarArchivoEquipo() {
        try {
            File file = new File("src/Archivo/Equipos");
            FileWriter fr = new FileWriter(file,false);
            PrintWriter pw = new PrintWriter(fr);
            for(Equipo equipo : equipos) {
                pw.println(equipo);
            }
            pw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reemplazando archivo");
        }
    }
}
