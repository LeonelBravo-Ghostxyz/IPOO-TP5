package ej1;

public class TesterHistoricos {
    public static void main(String args[]){
        Historicos listaHistoricos = new Historicos(10);

        for (int i = 0; i < 9; i++) {
            Jugador newJ = new Jugador("Jugador "+(i+1));
            newJ.establecerGolesConvertidos(random(0,20));

            listaHistoricos.establecerJugador(newJ);
        }   // Note: Establecemos una Lista de historicos (de tamaño 10) con 9 jugadores, a los que se les asignará un valor aleatorio de goles

        System.out.println("==== toString() ====");
        System.out.println(listaHistoricos.toString());
        System.out.println(" ");
        System.out.println("==== Cantidad de Jugadores ====\nEsperado: 10\nObtenido: "+listaHistoricos.cantJugadores());
        System.out.println(" ");
        System.out.println("==== estaLlena ====\nEsperado: false\nObtenido: "+listaHistoricos.estaLlena());
        System.out.println(" ");
        System.out.println("==== Cant Posiciones ====\nEsperado: 10\nObtenido: "+listaHistoricos.cantPosiciones());
        System.out.println(" ");
        System.out.println("==== Cant Jugadores ====\nEsperado: 10\nObtenido: "+listaHistoricos.cantJugadores());
        System.out.println(" ");
        System.out.println("==== M Mayores ====\nObtenido: "+listaHistoricos.mMayores(3,5));
        System.out.println(" ");
        System.out.println("==== al menos M Mayores ====\nObtenido: "+listaHistoricos.alMenosMMayores(3,5));
        System.out.println(" ");
        System.out.println("==== Goleadores ====\nLos jugadores que superan los 6 goles son:\n"+listaHistoricos.goleadores(6).toString());

    }


    private static int random(int min,int max){
        int range = max - min + 1;
        int mathRandom = (int)(Math.random() * range) + min;

        return mathRandom;
    }
}
