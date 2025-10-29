package ej5;

public class PolizasOrdenadas {
    // << Atributos de instancia >>
    private Poliza[] polOrd;
    private int n;

    // << Constructor >>
    public PolizasOrdenadas(int max){
        polOrd = new Poliza[max];
        n = 0;
    }

    // << Comandos >>
    public void insertar(Poliza pol){
        int numPol = pol.obtenerNroPoliza();
        boolean flag = true;

        for(int i=0;i<cantPolizas() && flag;i++){
            if(numPol < i){
                arrastrar(i);
                polOrd[i] = pol;
                flag = false;
            }
        }
    }
    public void actualizar(int d,int h, int p){
        for(int i=0;i<cantPolizas();i++){
            if(polOrd[i].obtenerCostoPoliza() > d && polOrd[i].obtenerCostoPoliza() < h){
                polOrd[i].actualizarPorcentaje(p);
            }
        }
    }
    public void copy(PolizasOrdenadas p){
        if(p.cantElementos() == cantElementos()){
            for(int i=0;i<cantPolizas();i++){
                polOrd[i] = p.obtenerPoliza(i) ;
            }
        }
    }

    // << Consultas >>
    public int cantPolizas(){
        return n;
    }
    public int cantElementos(){
        return polOrd.length;
    }
    public boolean estaLlena(){
        return (cantElementos() == cantPolizas());
    }
    public boolean existePoliza(int nro){
        boolean res = false;

        for(int i=0;i<cantPolizas() && !res;i++){
            if(polOrd[i].obtenerNroPoliza() == nro){
                res = true;
            }
        }

        return res;
    }
    public boolean existePoliza(Poliza p){
        boolean res = false;
        int low = 0;
        int high = cantPolizas();
        boolean flag = true;

        while(low <= high && flag){
            int middleIndex = (low + high)/2;
            Poliza middleIndexPoliza = polOrd[middleIndex];
            if(p.equals(middleIndexPoliza)){
                res = true;
                flag = false;
            }
            if(p.obtenerNroPoliza() < middleIndexPoliza.obtenerNroPoliza()){
                high = middleIndex -1;
            }
            if(p.obtenerNroPoliza() > middleIndexPoliza.obtenerNroPoliza()){
                high = middleIndex +1;
            }
        }

        return res;
    }
    public Poliza obtenerPoliza(int pos){
        Poliza res = null;
        if(pos>=0 && pos < cantPolizas()){
            res = polOrd[pos];
        }
        return res;
    }
    public PolizasOrdenadas intercalar(PolizasOrdenadas p){
        int reemplaza = -1; // -1: Objeto que recibe en mensaje. 1: Objeto enviada por parametro
        PolizasOrdenadas newPolizasOrdenadas = new PolizasOrdenadas(cantElementos());
        for(int i=0;i<cantPolizas();i++){
            for(int j=0;j<p.cantPolizas();j++){
                if(polOrd[i].obtenerNroPoliza() == p.obtenerPoliza(j).obtenerNroPoliza()){
                    newPolizasOrdenadas.insertar(polOrd[i]);
                }else{
                    if(reemplaza == -1){
                        newPolizasOrdenadas.insertar(polOrd[i]);
                        reemplaza = 1;
                    }else{
                        newPolizasOrdenadas.insertar(p.obtenerPoliza(j));
                        reemplaza = -1;
                    }
                }
            }
        }
        return newPolizasOrdenadas;
    }
    public boolean equals(PolizasOrdenadas p){
        boolean res = true;

        if(p == null || cantElementos() != p.cantElementos() || cantPolizas() != p.cantPolizas())res = false;
        for(int i=0;i<cantPolizas() && res;i++){
            for(int j=0;j<p.cantPolizas() && res;j++){
                if(polOrd[i] != p.obtenerPoliza(j))res = false;
            }
        }

        return res;
    }

    // << Auxiliares >>
    private void arrastrar(int p){
            // Note: el metodo arrastra elementos para dejar un nulo en la posicion "p"
        if(cantElementos() > p && p>=0){
            for(int i=cantPolizas()-1; i>=p;i--){
                polOrd[i+1] = polOrd[i];
            }
            polOrd[p] = null;
        }
    }
}
