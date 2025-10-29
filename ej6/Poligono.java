package ej6;

public class Poligono {
    // << Atributos de Instancia >>
    private Punto[] pol;
    private int n;

    // << Constructores >>
    public Poligono(int max){
        pol = new Punto[max];
        n = 0;
    }

    // << Comandos >>
    public void insertar(Punto p){
        if(p != null && !estaLlena()){
            pol[cantPuntos()] = p;
            n++;
        }
    }
    public void eliminar(Punto p){
        boolean flag = false;
        if(p != null){
            for(int i=0;i<cantPuntos() && !flag;i++){
                if(pol[i].equals(p)){
                    pol[i] = pol[cantPuntos()-1];
                    pol[cantPuntos()-1] = null;
                    n--;
                }
            }
        }
    }


    // << Consultas >>
    public int cantPuntos(){
        return n;
    }
    public boolean estaLlena(){
        return (cantPuntos() == pol.length);
    }
    public Punto obtenerPunto(int p){
        return pol[p-1];
    }
    public boolean existePunto(Punto p){
        boolean res = false;

        for(int i=0;i<cantPuntos() && !res;i++){
            if(pol[i] != null && pol[i].equals(p))res = true;
        }

        return res;
    }
    public double perimetro(){
        double perimetroTotal = 0;

        for(int i=0;i<cantPuntos()-1;i++){
            if(pol[i] != null && pol[i+1] != null){
                perimetroTotal = perimetroTotal + pol[i].distancia(pol[i+1]);
            }
        }

        return perimetroTotal;
    }
    public boolean equals(Poligono p){
        boolean res = true;
        if(p != null && cantPuntos() == p.cantPuntos()){
        for(int i=0;i<cantPuntos() && res;i++){
            if(!pol[i].equals(p.obtenerPunto(i)))res = false;
        }

        }else{
            res = false;
        }

        return res;
    }
}
