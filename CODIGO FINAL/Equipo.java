package Modelo;

public class Equipo {
    private String nombre;
    private int partidos;
    private int victorias;
    private int derrotas;
    private int empates;
    private int golesFavor;
    private int golesContra;
    private int puntos;

    private boolean jugando;

    private int code;

    public Equipo(String nombre, int partidos, int victorias, int derrotas, int empates, int golesFavor, int golesContra, int puntos, boolean jugando, int code) {
        this.nombre = nombre;
        this.partidos = partidos;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.puntos = puntos;
        this.jugando = jugando;
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return  nombre +
                "," + partidos +
                "," + victorias +
                "," + derrotas +
                "," + empates +
                "," + golesFavor +
                "," + golesContra +
                "," + puntos +
                "," + jugando +
                "," + code;
    }
}
