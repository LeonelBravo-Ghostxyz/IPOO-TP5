package ej1;

public class Historicos {
    // Atributos de Instancia
    private Jugador[] jugadoresHistoricos;
    private int cant;

    // Constructor
    public Historicos(int n){
        jugadoresHistoricos = new Jugador[n];
        cant = 0;
    }

    // Comandos
    public void establecerJugador(Jugador j){
        jugadoresHistoricos[cant] = j;
        cant++;
    }

    public void ordenar(){
        for (int i = 0; i < cant-1; i++) {
            for (int j = 0; j < cant-i-1; j++) {
                String actual = jugadoresHistoricos[j].obtenerNombre();
                String adyacente = jugadoresHistoricos[j+1].obtenerNombre();
                if(actual.compareToIgnoreCase(adyacente) > 0){
                    Jugador aux = jugadoresHistoricos[j];
                    jugadoresHistoricos[j] = jugadoresHistoricos[j+1];
                    jugadoresHistoricos[j+1] = aux;
                }
            }
        }
    }

    // Consultas
    public boolean estaLlena(){
        return cant == cantPosiciones();
    }
    public int cantPosiciones(){
        return jugadoresHistoricos.length;
    }
    public int cantJugadores(){
        return cant;
    }
    public Jugador obtenerJugador(int p){
        return jugadoresHistoricos[p];
    }
    public boolean mMayores(int g, int m){
        boolean cumple = false;
        int cont = 0;
        if(m < cant){
            for (int i = 0; i < cantJugadores() && cont<=m; i++) {
            if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g){
                cont++;
            }
        }
    }
        if(cont == m)cumple = true;
        return cumple;
    }
    public boolean alMenosMMayores(int g,int m){
        boolean cumple = false;
        int cont = 0;
        if(m < cant){
            for (int i = 0; i < cantJugadores() && cont<m && !cumple; i++) {
            if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g){
                cont++;
            }
            if(cont >= m)cumple = true;
        }
    }

        return cumple;
    }
    public Historicos goleadores(int g){
    int cont = 0;
    for (int i = 0; i < cantJugadores(); i++) {
        if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g)
            cont++;
    }
    
    Historicos newHistoricos = new Historicos(cont);
    
    for (int i = 0; i < cantJugadores(); i++) { 
        if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g)
            newHistoricos.establecerJugador(jugadoresHistoricos[i]);
    }

    return newHistoricos;
}

    public String toString(){
        String retorno = "";

        for (int i = 0; i < cant; i++) {
            retorno = retorno+this.obtenerJugador(i).obtenerNombre()+" - GC: "+this.obtenerJugador(i).obtenerGolesConvertidos()+"\n";
        }

        return retorno;
    }
}
