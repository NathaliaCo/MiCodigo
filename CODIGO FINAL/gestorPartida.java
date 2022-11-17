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

public class gestorPartida {
    gestorVariable gestor = new gestorVariable();
    ArrayList<Equipo> equipos = gestor.setEquipos();
    ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);
    public ArrayList<String> jornada = new ArrayList<>();
    public ArrayList<String> golesPartido = new ArrayList<>();


    String ruta = "src/Archivo/Equipos";

    gestorEquipos gestorE = new gestorEquipos();
    public void Inicio() {
        Scanner sc = new Scanner(System.in);
        Equipo equipo1 = null;
        Equipo equipo2 = null;
        String opcion = "";

        System.out.println("\nDiga el primer equipo a jugar");
        opcion = sc.nextLine();
        equipo1 = getEquipos(opcion);

        System.out.println("\nDiga el segundo equipo a jugar");
        opcion = sc.nextLine();
        equipo2 = getEquipos(opcion);

        this.iniciaPartido(equipo1, equipo2);
    }

    private Equipo getEquipos(String opcion) {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        Equipo equipoR = null;
        do {
            for (Equipo equipo : equipos) {
                if (equipo.getNombre().equalsIgnoreCase(opcion)) {
                    System.out.println("\n--------------------------------");
                    System.out.println("El equipo " + equipo.getNombre() + " ha sido seleccionado");
                    encontrado = true;
                    equipoR = equipo;
                }
            }
            if (!encontrado) {
                System.out.println("El equipo no existe, intente de nuevo");
                opcion = sc.nextLine();
            }
        } while (!encontrado);
        return equipoR;
    }
    private void iniciaPartido(Equipo equipo1, Equipo equipo2) {
        
        equipo1.setJugando(true);
        equipo2.setJugando(true);

        this.reemplazarArchivoEquipo();

    }

    public void ingresaResultados() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int goles = 0;
        int holderGoles1 = 0;
        int holderGolesC2 = 0;
        ArrayList<String> goleadores = new ArrayList<>();
        ArrayList<String> tipoGol = new ArrayList<>();
        ArrayList<Integer> minutos = new ArrayList<>();
        Equipo equipo1 = null;
        Equipo equipo2 = null;
        String opción = "";
        int cont = 0;
        int contEquipos = 0;
        this.golesPartido.clear();
        boolean encontrado = false;
        int minutosGol = 0;

        for(Equipo equipo : equipos){
            if(equipo.isJugando()){
                contEquipos++;
            }
        }

        if(contEquipos == 1){
            System.out.println("Solo hay un equipo en juego, por favor cambie el estado de un equipo en el gestor");
            TimeUnit.SECONDS.sleep(2);
            return;
        }

        for (Equipo equipo : equipos) {
            if(equipo.isJugando()){
                cont++;
                equipo.setJugando(false);
                System.out.println("Ingrese los goles del equipo " + equipo.getNombre());
                goles = sc.nextInt();
                goleadores.clear();
                tipoGol.clear();
                minutos.clear();
                encontrado = false;
                equipo.setGolesFavor(equipo.getGolesFavor() + goles);
                equipo.setPartidos(equipo.getPartidos() + 1);

                for(int i = 0; i < goles; i++){
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del goleador");
                    opción = sc.nextLine();

                    for(Jugador jugador : jugadores){
                        if(jugador.getNombre().equalsIgnoreCase(opción) && jugador.getEquipo().getNombre().equalsIgnoreCase(equipo.getNombre())){
                            goleadores.add(jugador.getNombre());
                            encontrado = true;
                        }
                    }
                    if(!encontrado){
                        System.out.println("El jugador no existe, intente de nuevo");
                        equipo.setJugando(true);
                        return;
                    }
                    System.out.println("Ingrese el tipo de gol");
                    opción = sc.nextLine();

                    while (!opción.equalsIgnoreCase("penal") && !opción.equalsIgnoreCase("jugada") && !opción.equalsIgnoreCase("cabeza") && !opción.equalsIgnoreCase("tiro libre")) {
                        System.out.println("El tipo de gol no existe, intente de nuevo");
                        opción = sc.nextLine();
                    }
                    opción = opción.substring(0, 1).toUpperCase() + opción.substring(1).toLowerCase();
                    tipoGol.add(opción);


                    System.out.println("Ingrese el minuto en el que se hizo el gol");
                    minutosGol = sc.nextInt();
                    while (minutosGol < 0 || minutosGol > 95) {
                        System.out.println("El minuto no es valido, intente de nuevo");
                        minutosGol = sc.nextInt();
                    }
                    minutos.add(minutosGol);
                }

                for(int i = 0; i < goles; i++){
                    for(Jugador jugador : jugadores){
                        if(jugador.getNombre().equalsIgnoreCase(goleadores.get(i)) && (jugador.getEquipo().getCode()==equipo.getCode())){
                            jugador.setGoles(jugador.getGoles() + 1);
                            this.golesPartido.add("Nombre: " + jugador.getNombre() + " | Equipo: " + equipo.getNombre() + " | Tipo de Gol: " + tipoGol.get(i) + " | Minuto: " + minutos.get(i).toString());
                        }
                    }
                }
                if(cont == 1){
                    equipo1 = equipo;
                    holderGoles1 = goles;
                }else{
                    equipo2 = equipo;
                    holderGolesC2 = goles;
                }
            }
        }

        assert equipo1 != null;
        assert equipo2 != null;
        equipo1.setGolesContra(equipo1.getGolesContra() + holderGolesC2);
        equipo2.setGolesContra(equipo2.getGolesContra() + holderGoles1);

        jornada.add(equipo1.getNombre() + " " + holderGoles1 + " - " + holderGolesC2 + " " + equipo2.getNombre());

        if(holderGoles1 > holderGolesC2){
            equipo1.setPuntos(equipo1.getPuntos() + 3);
            equipo1.setVictorias(equipo1.getVictorias() + 1);
            equipo2.setDerrotas(equipo2.getDerrotas() + 1);
        } else if(holderGoles1 < holderGolesC2){
            equipo2.setPuntos(equipo2.getPuntos() + 3);
            equipo2.setVictorias(equipo2.getVictorias() + 1);
            equipo1.setDerrotas(equipo1.getDerrotas() + 1);
        } else{
            equipo1.setPuntos(equipo1.getPuntos() + 1);
            equipo2.setPuntos(equipo2.getPuntos() + 1);
            equipo1.setEmpates(equipo1.getEmpates() + 1);
            equipo2.setEmpates(equipo2.getEmpates() + 1);
        }

            if(cont == 2){
                this.reemplazarArchivoEquipo();
                this.reemplazarArchivoJugador();
            }
    }



    private void reemplazarArchivoEquipo() {
        try {
            File file = new File(ruta);
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

    private void reemplazarArchivoJugador() {
        try {
            File file = new File("src/Archivo/Jugadores");
            FileWriter fr = new FileWriter(file,false);
            PrintWriter pw = new PrintWriter(fr);
            for(Jugador jugador : jugadores) {
                pw.println(jugador);
            }
            pw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reemplazando archivo");
        }
    }
}

