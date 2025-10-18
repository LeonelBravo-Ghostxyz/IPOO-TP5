package ej2;

public class TesterConsumoEdificio {
    public static void main(String args[]){
        System.out.println("==== Tester de la clase Consumo Edificio ============");

        ConsumoEdificio consumEd = new ConsumoEdificio(10);
        for(int i=0;i<9;i++){
            int agua = random(0, 20);
            int electricidad = random(0, 20);
            int gas = random(0, 20);

            if(i % 6 == 0){
                agua = 0;
                electricidad = 0;
                gas=20;
            }

            MedicionServicios piso = new MedicionServicios(gas,agua,electricidad);

            consumEd.registrarConsumo(piso, i);
        } // Note: Establecemos un array consumoEd (tamaño 10) que contendrá los consumos de 9 pisos

        MedicionServicios tdMayores = new MedicionServicios(2, 3, 4);
        System.out.println(consumEd.toString());
        System.out.println("");
        System.out.println("==== CantPosiciones ====");
        System.out.println("Esperado: 10\nObtenido: "+consumEd.cantPosiciones());
        System.out.println("");
        System.out.println("==== CantPisos ====");
        System.out.println("Esperado: 9\nObtenido: "+consumEd.cantPisos());
        System.out.println("");
        System.out.println("==== hayMayorConsumo ====");
        System.out.println("Esperando: true\nObtenido: "+consumEd.hayMayorConsumo(3));
        System.out.println("");
        System.out.println("==== cuantasMayores ====");
        System.out.println("Resultado: "+consumEd.cuantasMayores(7));
        System.out.println("");
        System.out.println("==== primerPisoMayor ====");
        System.out.println("Resultado: "+consumEd.primerPisoMayor(10));
        System.out.println("");
        System.out.println("==== ultimoPisoMayor ====");
        System.out.println("Resultado: "+consumEd.ultimoPisoMayor(10));
        System.out.println("");
        System.out.println("==== nMayores ====");
        System.out.println("Resultado: "+consumEd.nMayores(20, 2));
        System.out.println("");
        System.out.println("==== todosMayores (c) ====");
        System.out.println("Resultado: "+consumEd.todosMayores(10));
        System.out.println("");
        System.out.println("==== todosMayores (MedicionServicios) ====");
        System.out.println("Resultado: "+consumEd.todosMayores(tdMayores));
        System.out.println("");
        System.out.println("==== Eliminar Ceros ====");
        consumEd.eliminarCeros();
        System.out.print("Esperando que se eliminen los pisos con al menos 2 ceros en sus consumos (Obs: Tambien se elimina el 0 y 6)\nResultado: \n"+consumEd.toString());

    }

    private static int random(int min,int max){
        int range = max - min + 1;
        int mathRandom = (int)(Math.random() * range) + min;

        return mathRandom;
        }
}
