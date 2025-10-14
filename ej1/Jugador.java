package ej1;

public class Jugador {
    /* Atributos de Instancia */
    private String nombre;
    private int nroCamiseta,posicion,golesConvertidos,partidosJugados;

    /* Constructor */
    public Jugador(String nom){
        nombre = nom;
    }

    /* Comandos */
    public void establecerNroCamiseta(int n){
        nroCamiseta = n;
    }
    public void establecerPosicion(int n){
        posicion = n;
    }
    public void establecerGolesConvertidos(int n){
        golesConvertidos = n;
    }
    public void establecerPartidosJugados(int n){
        partidosJugados = n;
    }
    public void aumentarGoles(int n){
        golesConvertidos = golesConvertidos++;
    }
    public void aumentarUnPartido(){
        partidosJugados = partidosJugados++;
    }

    /* Consultas */
    public String obtenerNombre(){
        return nombre;
    }
    public int obtenerNroCamiseta(){
        return nroCamiseta;
    }
    public int obtenerPosicion(){
        return posicion;
    }
    public int obtenerGolesConvertidos(){
        return golesConvertidos;
    }
    public int obtenerPartidosJugados(){
        return partidosJugados;
    }
    public int promedioGolesXPartido(){
        return golesConvertidos/partidosJugados;
    }
    public boolean masGoles(Jugador j){
        if(this.golesConvertidos > j.golesConvertidos)return true;
        else return false;
    }
    public Jugador jugConMasGoles(Jugador j){
        if(this.golesConvertidos > j.golesConvertidos)return this;
        else return j;
    }
    public String toString(){
        return "Nombre: "+this.nombre+" NroCamiseta: "+this.nroCamiseta+" Posicion: "+this.posicion+" Goles Convertidos: "+this.golesConvertidos+" Partidos Jugados: "+this.partidosJugados+" Promedio Gol/Partido: "+this.promedioGolesXPartido();
    }
    public Jugador clone(){
        Jugador j = new Jugador(this.nombre);
        j.establecerGolesConvertidos(this.golesConvertidos);
        j.establecerNroCamiseta(this.nroCamiseta);
        j.establecerPartidosJugados(this.partidosJugados);
        j.establecerPosicion(this.posicion);
        return j;
    }
    public boolean equals(Jugador j){
        if(this.nombre == j.nombre && this.nroCamiseta == j.nroCamiseta && this.posicion == j.posicion && this.golesConvertidos == j.golesConvertidos && this.partidosJugados == j.partidosJugados)return true;
        else return false;
    }
}