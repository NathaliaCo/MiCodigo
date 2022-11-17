package Gestion;

import Modelo.Equipo;
import Modelo.Jugador;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class gestorCampeonato {
    gestorVariable gestor = new gestorVariable();
    ArrayList<Equipo> equipos = gestor.setEquipos();
    ArrayList<Jugador> jugadores = gestor.setJugadores(equipos);

    //create a random championship with 6 teams
    public void crearCampeonato() throws InterruptedException {
        ArrayList<Equipo> equiposCampeonato = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            equiposCampeonato.add(equipos.get(i));
        }
        for (Equipo equipo : equiposCampeonato) {
            equipo.setJugando(true);
        }
        Random random = new Random();

        Equipo equipo1 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo1);
        Equipo equipo2 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo2);
        Equipo equipo3 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo3);
        Equipo equipo4 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo4);
        Equipo equipo5 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo5);
        Equipo equipo6 = equiposCampeonato.get(random.nextInt(equiposCampeonato.size()));
        equiposCampeonato.remove(equipo6);

        Equipo perdedor1 = null;
        Equipo perdedor2 = null;

        System.out.println("\nCampeonato creado");
        System.out.println("Equipos: " +
                equipo1.getNombre() + ", " +
                equipo2.getNombre() + ", " +
                equipo3.getNombre() + ", " +
                equipo4.getNombre() + ", " +
                equipo5.getNombre() + ", " +
                equipo6.getNombre());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nIniciando campeonato...");

        //equipo1 vs equipo2
        System.out.println("\nPartido 1: " + equipo1.getNombre() + " vs " + equipo2.getNombre());
        Equipo ganador1 = partido(equipo1, equipo2);
        System.out.println("\nGanó : " + ganador1.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //equipo3 vs equipo4
        System.out.println("\nPartido 2: " + equipo3.getNombre() + " vs " + equipo4.getNombre());
        Equipo ganador2 = partido(equipo3, equipo4);
        System.out.println("\nGanó : " + ganador2.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //equipo5 vs ganador1
        System.out.println("\nPartido 3: " + equipo5.getNombre() + " vs " + ganador1.getNombre());
        Equipo ganador3 = partido(equipo5, ganador1);
        if(ganador3.equals(equipo5)){
            perdedor1 = ganador1;
        } else {
            perdedor1 = equipo5;
        }
        System.out.println("\nGanó : " + ganador3.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //equipo6 vs ganador2
        System.out.println("\nPartido 4: " + equipo6.getNombre() + " vs " + ganador2.getNombre());
        Equipo ganador4 = partido(equipo6, ganador2);
        if(ganador4.equals(equipo6)){
            perdedor2 = ganador2;
        } else {
            perdedor2 = equipo6;
        }
        System.out.println("\nGanó : " + ganador4.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //ganador3 vs ganador4
        System.out.println("\nPartido 5: " + ganador3.getNombre() + " vs " + ganador4.getNombre());
        Equipo ganador5 = partido(ganador3, ganador4);
        System.out.println("\nGanó : " + ganador5.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //perdedor1 vs perdedor2
        System.out.println("\nPartido 6: " + perdedor1.getNombre() + " vs " + perdedor2.getNombre());
        Equipo ganador6 = partido(perdedor1, perdedor2);
        System.out.println("\nGanó : " + ganador6.getNombre());
        TimeUnit.SECONDS.sleep(2);

        //create a flashy message for the winner
        System.out.println("El ganador del campeonato es: " + ganador5.getNombre());
        System.out.println("Felicitaciones " + ganador5.getNombre() + "!");
        System.out.println("-----------------------------------------");
        TimeUnit.SECONDS.sleep(3);


    }

    private Equipo partido(Equipo equipo1, Equipo equipo2) {
        Random random = new Random();
        int golesEquipo1 = random.nextInt(5);
        int golesEquipo2 = random.nextInt(5);

        while (golesEquipo1 == golesEquipo2) {
            golesEquipo1 = random.nextInt(5);
            golesEquipo2 = random.nextInt(5);
        }

        if (golesEquipo1 > golesEquipo2) {
            System.out.println("El equipo " + equipo1.getNombre() + " ganó por " + golesEquipo1 + " a " + golesEquipo2);
            return equipo1;
        } else if (golesEquipo1 < golesEquipo2) {
            System.out.println("El equipo " + equipo2.getNombre() + " ganó por " + golesEquipo2 + " a " + golesEquipo1);
            return equipo2;
        }
        return null;
    }
}
