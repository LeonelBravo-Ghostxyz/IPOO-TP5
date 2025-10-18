package ej2;

public class ConsumoEdificio {
    // << Atributos de Instancia >>
    private MedicionServicios[] consumoXPiso;

    // << Constructor >>
    public ConsumoEdificio(int pisos){
        consumoXPiso = new MedicionServicios[pisos];
    }

    // << Comandos >>
    public boolean registrarConsumo(MedicionServicios m,int p){
        boolean res = false;
        if(m!=null && validPos(p)){ // Note: Evaluamos que sea una posicion valida
            consumoXPiso[p] = m;
            res = true;
        }
        return res;
    }
    public boolean eliminarConsumo(int p){
        boolean ret = false;
        if(validPos(p)){
            consumoXPiso[p] = null;
            ret = true;
        }

        return ret;
    }
    public void eliminarCeros(){
        int cont = 0;
        for(int i=0;i<consumoXPiso.length;i++){
            if(consumoXPiso[i] != null){
            if(consumoXPiso[i].obtenerAgua() == 0)cont++;
            if(consumoXPiso[i].obtenerElectricidad() == 0)cont++;
            if(consumoXPiso[i].obtenerGas() == 0)cont++;
            if(cont >= 2){
                cont = 0;
                consumoXPiso[i] = null;
            }
            }
        }
    }

    // << Consultas >>
    public int cantPosiciones(){
        return consumoXPiso.length;
    }
    public int cantPisos(){
        int cont = 0;
        for(int i=0;i<consumoXPiso.length;i++){
            if(consumoXPiso[i] != null)cont++;
        }
        return cont;
    }
    public MedicionServicios obtenerMedicionServicios(int p){
        return consumoXPiso[p];
    }
    public boolean hayMayorConsumo(int c){
        boolean res = false;

        for(int i=0;i<consumoXPiso.length && !res;i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c)res = true;
        }

        return res;
    }
    public int cuantasMayores(int c){
        int cont = 0;

        for(int i=0;i<consumoXPiso.length;i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c)cont++;
        }

        return cont;
    }
    public int primerPisoMayor(int c){
        int pos = -1;

        for(int i=0;i<consumoXPiso.length && pos == -1;i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c)pos = i;
        }

        return pos;
    }
    public int ultimoPisoMayor(int c){
        int pos = -1;

        for(int i=consumoXPiso.length-1;i>=0 && pos == -1;i--){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c)pos = i;
        }

        return pos;
    }
    public boolean nMayores(int c,int n){
        int cont = 0;
        boolean res = false;
        for(int i=0;i<consumoXPiso.length && cont<=n;i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c)cont++;
        }
        if(cont == n)res = true;

        return res;
    }
    public boolean todosMayores(int c){
        boolean res = true;
        for(int i=0;i<consumoXPiso.length && res;i++){
            if(consumoXPiso[i] == null){
                res = false;
            }else if(consumoXPiso[i].costoServicios() < c){
                res = false;
            }
        }

        return res;
    }
    public boolean todosMayores(MedicionServicios m){
        boolean res = true;
        int cont = 0;

        for(int i=0;i<consumoXPiso.length && res;i++){
            if(consumoXPiso[i]!=null){
                if(consumoXPiso[i].obtenerAgua() > m.obtenerAgua())cont++;
                if(consumoXPiso[i].obtenerElectricidad() > m.obtenerElectricidad())cont++;
                if(consumoXPiso[i].obtenerGas() > m.obtenerGas())cont++;

                if(cont != 3)res = false;
            }
        }

        return res;
    }

    public String toString(){
        String res = "";

        for(int i=0;i<consumoXPiso.length;i++){
            if(consumoXPiso[i] != null){
                res = res+"\nPiso "+i+" "+consumoXPiso[i];
            }else{
                res = res+"\nPiso "+i+" Vacío";
            }
        }

        return res;
    }

    // << Auxiliares >>
    private boolean validPos(int p){
        boolean res = false;
        if(p>=0 && p<consumoXPiso.length)res=true;
        return res;
    }
}
