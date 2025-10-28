package ej4;

public class Refugio {
    // << Atributo de Clase >>
    private static final int capacidadAlacena = 20;
    private static final int cantidadCamas = 10;

    // << Atributos de Instancia >>
    private int alimentos,bebidas,camas;

    // << Constructor >>
    public Refugio(int a, int b, int c){
        if(a > capacidadAlacena && b > capacidadAlacena){
            alimentos = capacidadAlacena / 2;
            bebidas = capacidadAlacena / 2;
        }else{
            alimentos = a;
            bebidas = b;
        }
        if(c > cantidadCamas){
            camas = cantidadCamas;
        }else{
            camas = c;
        }
    }

    // << Comandos >>
    public void consumirAlimento(){
        if(alimentos > 0){
            alimentos = alimentos -1;
        }
    }

    public void consumirBebida(){
        if(bebidas > 0){
            bebidas = bebidas -1;
        }
    }

    public boolean ocuparCama(){
        if(camas > 0 && camas < cantidadCamas){
            camas = camas + 1;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean desocuparCama(){
        if(camas > 0 && camas <= cantidadCamas){
            camas = camas - 1;
            return true;
        }else{
            return false;
        }
    }

    public boolean reponerAlimentos(int n){
        if(n > 0 && capacidadAlacena >= (bebidas+alimentos+n)){
            alimentos = alimentos + n;
            return true;
        }else{
            return false;
        }
    }

    public boolean reponerBebidas(int n){
        if(n > 0 && (alimentos+bebidas+n) <= capacidadAlacena){
            bebidas = bebidas + n;
            return true;
        }else{
            return false;
        }
    }

    // << Consultas >>
    public int obtenerAlimentos(){
        return alimentos;
    }

    public int obtenerBebidas(){
        return bebidas;
    }

    public int obtenerCamas(){
        return camas;
    }

    public int obtenerCapacidadAlacena(){
        return capacidadAlacena;
    }

    public boolean esHabitable(){
        if(alimentos > 0 || camas < cantidadCamas || bebidas > 0){
            return true;
        }else{
            return false;
        }
    }
        public int disponibilidad(){
        if(camas < cantidadCamas){
            return cantidadCamas - camas; //Soy un pelotudo y dsp de 1h solucione el error logico de mierda
        }else return 0;
    }
    public int diasSupervivencia(){
        if(bebidas <= alimentos)return bebidas;
        else return alimentos;
    }
    public boolean mayorAlimentos(Refugio r){
        if(r != null && this.alimentos > r.obtenerAlimentos()){
            return true;
        }else{
            return false;
        }
    }
    public boolean equals(Refugio r){
        if(r != null && this.alimentos == r.obtenerAlimentos() && this.bebidas == r.obtenerBebidas() && this.camas == r.obtenerCamas()){
            return true;
        }else{
            return false;
        }
    }
    public Refugio clone(){
       Refugio nuevoRefugio = new Refugio(this.alimentos, this.bebidas, this.camas);
       return nuevoRefugio;
    }
    public String toString(){
        return ("Alimentos: "+alimentos+" Bebidas: "+bebidas+" Camas: "+camas);
    }


}