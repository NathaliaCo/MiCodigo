package Gestion;

import Modelo.Equipo;
import Modelo.Jugador;
import Vista.Menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class gestorVariable {
    public void iniciar() throws InterruptedException {
        setJugadores(setEquipos());
        Menu menu = new Menu();
        menu.mostrarMenu();
    }

    public ArrayList<Equipo> setEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<>();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader("src/Archivo/Equipos");
            br = new BufferedReader(file);
            while ((registro = br.readLine()) != null) {
                String[] datos = registro.split(",");
                Equipo equipo = new Equipo(datos[0],
                        Integer.parseInt(datos[1]),
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]),
                        Integer.parseInt(datos[7]),
                        Boolean.parseBoolean(datos[8]),
                        Integer.parseInt(datos[9]));
                equipos.add(equipo);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo archivo");
        }
        return equipos;
    }

    public ArrayList<Jugador> setJugadores(ArrayList<Equipo> equipos) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader("src/Archivo/Jugadores");
            br = new BufferedReader(file);
            while ((registro = br.readLine()) != null) {
                String[] datos = registro.split(",");
                Jugador jugador = new Jugador(datos[0], datos[1], equipos.get(Integer.parseInt(datos[2])), datos[3], Boolean.getBoolean(datos[4]), Integer.parseInt(datos[5]));
                jugadores.add(jugador);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo archivo");
        }
        return jugadores;
    }

}
