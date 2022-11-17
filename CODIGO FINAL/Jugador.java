package Modelo;

public class Jugador {
    private String nombre;
    private String posicion;
    private Equipo equipo;

    private String cancha;

    private boolean DT;

    private int goles;

    public Jugador(String nombre, String posicion, Equipo equipo, String cancha, boolean DT, int goles) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.cancha = cancha;
        this.DT = DT;
        this.goles = goles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public boolean getDT() {
        return DT;
    }

    public void setDT(boolean DT) {
        this.DT = DT;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }



    @Override
    public String toString() {
        return  nombre  +
                "," + posicion  +
                "," + equipo.getCode() +
                "," + cancha  +
                "," + DT +
                "," + goles;

    }

}
