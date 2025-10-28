package ej4;

public class ColeccionRefugios {
    // << Atributos de Instancia >>
    private Refugio[] col;
    private int cant;

    // << Constructor >>
    public ColeccionRefugios(int n){
        col = new Refugio[n];
        cant = 0;
    }

    // << Comandos >>
    public void insertarRefugio(Refugio r){
        if(cant != col.length){
            col[cant] = r;
            cant++;
        }
    }
    public void  eliminarEscasaSupervivencia(){
        for(int i=0;i<cant;i++){
            if(col[i].diasSupervivencia() <= 1){
                for(int j=i;j<cant-1;j++){
                    col[j] = col[j+1];
                }
                col[cant] = null;
                cant--;
                i--;
            }
        }
    }

    // << Consultas>>
    public int tamañoColeccion(){
        return col.length;
    }
    public int cantRefugios(){
        return cant;
    }
    public boolean estaLlena(){
        return (cant==col.length);
    }
    public Refugio obtenerRefugio(int pos){
        Refugio res = null;
        if(pos >=0 && cant <pos){
            res = col[pos];
        }

        return res;
    }
    public boolean hayNSeguidosHabitables(int n){
        boolean res = true;
        int cont = 0;

        if(n>cant)res = false;
        for(int i=0;i<cant-1 && res && cont<n;i++){
            if(col[i].esHabitable()){
                cont++;
            }else{
                cont=0;
            }
            
            if(n>=cant-(i+1)+cont)res=false;
        }
        if(cont < n)res = false;
        return res;
    }
    public boolean equals(ColeccionRefugios c){
        boolean res = true;

        if(cant != c.cantRefugios() || col.length != c.tamañoColeccion())res = false;
        for(int i=0;i<cant && res;i++){
            if(!col[i].equals(c.obtenerRefugio(i)))res = false;
        }
        
        return res;
    }

}
