package Gestion;

import Modelo.Equipo;
import Modelo.Jugador;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class gestorTablas {

    gestorVariable gestor = new gestorVariable();
    ArrayList<Equipo> equipos = gestor.setEquipos();
    ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);

    public void tablaDePosiciones() throws InterruptedException {

        ArrayList<Equipo> equipos = gestor.setEquipos();

// crea tabla con equipos y puntos //
        ArrayList<Equipo> tabla = new ArrayList<>();
        for (Equipo equipo : equipos) {
            Equipo e = new Equipo(equipo.getNombre(), equipo.getPartidos(), equipo.getVictorias(), equipo.getDerrotas(), equipo.getEmpates(), equipo.getGolesFavor(), equipo.getGolesContra(), equipo.getPuntos(), equipo.isJugando(), equipo.getCode());
            tabla.add(e);
        }


        for (int i = 0; i < tabla.size(); i++) {
            for (int j = 0; j < tabla.size() - 1; j++) {
                if (tabla.get(j).getPuntos() < tabla.get(j + 1).getPuntos()) {
                    Equipo aux = tabla.get(j);
                    tabla.set(j, tabla.get(j + 1));
                    tabla.set(j + 1, aux);
                }
            }
        }

        //print the table
        System.out.println("\nTabla de posiciones");
        System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s%-11s%-11s%n", "Equipo", "Partidos", "Victorias", "Derrotas", "Empates", "GF", "GC", "Puntos");
        for (Equipo equipo : tabla) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s%-11s%-11s%n", equipo.getNombre(), equipo.getPartidos(), equipo.getVictorias(), equipo.getDerrotas(), equipo.getEmpates(), equipo.getGolesFavor(), equipo.getGolesContra(), equipo.getPuntos());
        }
        TimeUnit.SECONDS.sleep(2);
    }

    public void tablaJugadores() {

        ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);

        ArrayList<Jugador> tablaJugadores = new ArrayList<>();

        for(Jugador jugador : jugadores) {
            Jugador j = new Jugador(jugador.getNombre(), jugador.getPosicion(), jugador.getEquipo(), jugador.getCancha(), jugador.getDT(), jugador.getGoles());
            tablaJugadores.add(j);
        }

        for (int i = 0; i < tablaJugadores.size(); i++) {
            for (int j = 0; j < tablaJugadores.size() - 1; j++) {
                if (tablaJugadores.get(j).getGoles() < tablaJugadores.get(j + 1).getGoles()) {
                    Jugador aux = tablaJugadores.get(j);
                    tablaJugadores.set(j, tablaJugadores.get(j + 1));
                    tablaJugadores.set(j + 1, aux);
                }
            }
        }

        System.out.println("\nTabla de goleadores");
        System.out.printf("%-15s%-11s%-11s%-11s%n", "Jugador", "Equipo", "Posicion", "Goles");
        for (Jugador jugador : tablaJugadores) {
            if(jugador.getGoles() > 0){
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.printf("%-15s%-11s%-11s%-11s%n", jugador.getNombre(),jugador.getEquipo().getNombre() ,jugador.getPosicion() , jugador.getGoles());
            }
        }

    }
}
