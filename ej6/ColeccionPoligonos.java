package ej6;

public class ColeccionPoligonos {
    // << Atributos de Instancia >>
    private Poligono[] cp;
    private int n;

    // << Constructor >>
    public ColeccionPoligonos(int max){
        cp = new Poligono[max];
        n = 0;
    }

    // << Comandos >>
    public void insertar(Poligono p){
        if(p != null && !estaLlena()){
            cp[cantPoligonos()] = p;
            n++;
        }
    }
    public void eliminar(Poligono p){
        boolean changed = false;
        if(p != null){
            for(int i=0;i<cantPoligonos() && !changed;i++){
                if(cp[i] == p){
                    cp[i] = cp[cantPoligonos()-1];
                    cp[cantPoligonos()-1] = null;
                    n--;
                    changed = true;
                }
            }
        }
    }
    public void eliminarPoligonosNLados(int n){
        for(int i=0;i<cantPoligonos();i++){
            if(cp[i].cantPuntos() == n){
                eliminar(cp[i]);
            }
        }
    }

    // << Consultas >>
    public int cantPoligonos(){
        return n;
    }
    public boolean estaLlena(){
        return (n == cp.length);
    }
    public boolean existePoligono(Poligono pol){
        boolean res = false;
        if(pol != null){
            for(int i=0;i<cantPoligonos() && !res;i++){
            if(pol.equals(cp[i]))res = true;
        }
        }

        return res;
    }
    public int contarPoligonosPunto(Punto p){
        int cont = 0;
        if(p != null){
            for(int i = 0; i<cantPoligonos();i++){
                if(cp[i].existePunto(p))cont++;
            }
        }

        return cont;
    }
}
