package ej3;

public class Surtidor {
    // << Atributos de Clase >>
    private static final int maxCarga = 20000;

    // << Atributos de Instancia >>
    private int cantGasoil,cantSuper,cantPremium;

    // << Constructor >>
    public Surtidor(){
        cantGasoil=maxCarga; cantSuper=maxCarga ;cantPremium = maxCarga;
    }

    // << Comandos >>
    public void llenarDepositoGasoil(){
        cantGasoil = maxCarga;
    }
    public void llenarDepositoSuper(){
        cantSuper = maxCarga;
    }
    public void llenarDepositoPremium(){
        cantPremium = maxCarga;
    }
    public void extraerGasoil(int litros){
        if(cantGasoil > litros){
            cantGasoil = cantGasoil - litros;
        }else{
            cantGasoil = 0;
        }
    }
    public void extraerSuper(int litros){
        if(cantSuper > litros){
            cantSuper = cantSuper - litros;
        }else{
            cantSuper = 0;
        }
    }
    public void extraerPremium(int litros){
        if(cantPremium > litros){
            cantPremium = cantPremium - litros;
        }else{
            cantPremium = 0;
        }
    }

    // << Consultas >>
    public int obtenerMaximaCarga(){
        return maxCarga;
    }
    public int obtenerLitrosGasoil(){
        return cantGasoil;
    }
    public int obtenerLitrosSuper(){
        return cantSuper;
    }
    public int obtenerLitrosPremium(){
        return cantPremium;
    }
    public boolean depositosLlenos(){
        if(cantGasoil == maxCarga && cantPremium == maxCarga && cantSuper == maxCarga){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        return "Surtidor[ Gasoil: " + cantGasoil + " , Super: " + cantSuper + " , Premium: " + cantPremium + " ]";
    }

}