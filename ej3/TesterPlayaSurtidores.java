package ej3;

public class TesterPlayaSurtidores {
    public static void main(String[] args){
        PlayaSurtidores ps = new PlayaSurtidores(5);
        Surtidor s1 = new Surtidor();
        Surtidor s2 = new Surtidor();
        Surtidor s3 = new Surtidor();
        ps.establecerSurtidor(s1,0);
        ps.establecerSurtidor(s2);
        ps.establecerSurtidor(s3);

        PlayaSurtidores ps2 = ps.clone();
        System.out.println("\tEstado interno de ps2 (clon de ps):\n"+ ps2.toString());

        System.out.println("Cantidad de posiciones esperada: 5\n Cantidad de posiciones obtenida: " + ps.cantPosiciones());
        System.out.println("Cantidad de surtidores esperada: 3\n Cantidad de surtidores obtenida: " + ps.cantSurtidores());
        System.out.println("Cantidad maxima de carga esperada: 60000\n Cantidad maxima de carga obtenida: " + ps.cantMaxCarga());
        ps.llenarDepositos();
        System.out.println("Cantidad de litros de Gasoil esperada en el surtidor 2: 20000\n Cantidad de litros de Gasoil obtenida en el surtidor 2: " + ps.obtenerSurtidor(1).obtenerLitrosGasoil());
        ps.obtenerSurtidor(1).extraerGasoil(5000);
        System.out.println("Cantidad de litros de Gasoil esperada en el surtidor 2 despues de extraer 5000 litros: 15000\n Cantidad de litros de Gasoil obtenida en el surtidor 2 despues de extraer 5000 litros: " + ps.obtenerSurtidor(1).obtenerLitrosGasoil());
        ps.obtenerSurtidor(1).extraerGasoil(20000);
        System.out.println("Cantidad de litros de Gasoil esperada en el surtidor 2 despues de extraer 20000 litros: 0\n Cantidad de litros de Gasoil obtenida en el surtidor 2 despues de extraer 20000 litros: " + ps.obtenerSurtidor(1).obtenerLitrosGasoil());
        ps.agrupaSurtidores();
        System.out.println("Cantidad de surtidores esperada despues de agrupar: 3\n Cantidad de surtidores obtenida despues de agrupar: " + ps.cantSurtidores());
        System.out.println("Ps y Ps2 tienen mismos nulos? (true): " + ps.mismosNulos(ps2));
        System.out.println("PlayaSurtidores con al menos 2 ligados");
        PlayaSurtidores ps3 = ps.nLigados(2);
        System.out.println(ps3.toString());

    }
}
