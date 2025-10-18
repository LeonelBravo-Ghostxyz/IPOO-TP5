package ej2;

public class MedicionServicios {
    // << Atributos de Instancia >>
    private int gas,agua,electricidad;

    // << Constructor >>
    public MedicionServicios(int g,int a,int e){
        if(g >= 0 && a >= 0 && e >= 0){
            gas = g; agua = a; electricidad = e;
        }else{
            gas = 3; agua = 4; electricidad = 5;
        }
    }

    // << Comandos >>
    public void establecerGas(int g){
        if(g > 0){
            gas = g;
        }
    }
    public void establecerAgua(int a){
        if(a > 0){
            agua = a;
        }
    }
    public void establecerElectricidad(int e){
        if(e > 0){
            electricidad = e;
        }
    }

    // << Consultas >>
    public int obtenerGas(){
        return gas;
    }
    public int obtenerAgua(){
        return agua;
    }
    public int obtenerElectricidad(){
        return electricidad;
    }
    public float costoServicios(){
        return (gas*1.5f+agua*0.5f+electricidad*2);
    }
    public String toString(){
        return"\n\tGas: "+obtenerGas()+"\n\tAgua: "+obtenerAgua()+"\n\tElectricidad: "+obtenerElectricidad();
    }
    
}
