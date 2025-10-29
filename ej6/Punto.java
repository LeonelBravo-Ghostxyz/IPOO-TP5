package ej6;

public class Punto {
    // << Atributos de Instancia >>
    private int x,y;

    // << Constructor >>
    public Punto(int coord,int ord){
        x = coord;
        y = ord;
    }

    // << Comandos >>
    public void establecerX(int coord){
        if(coord >= 0)x=coord;
    }
    public void establecerY(int ord){
        if(ord >= 0)y=ord;
    }
    public void copy(Punto p){

    }
    // << Consultas >>
    public int obtenerX(){
        return x;
    }
    public int obtenerY(){
        return y;
    }
    public Punto clone(){
        return new Punto(x, y);
    }
    public boolean equals(Punto p){
        return (x == p.obtenerX() && y == p.obtenerY());
    }
    public double distancia(Punto p){
        double deltaY = Math.pow(y - p.obtenerY(),2);
        double deltaX = Math.pow(x-p.obtenerX(),2);
        return Math.sqrt(deltaX+deltaY);
    }


}
