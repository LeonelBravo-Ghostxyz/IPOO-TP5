package ej4;

public class Territorio {
    // << Atributos de Instancia >>
    Refugio[][] tablero;

    // << Constructor >>
    public Territorio(int nf, int nc){
        tablero = new Refugio[nf][nc];
    }

    // << Comandos >>
    public boolean establecerRefugio(Refugio r, int f, int c){
        boolean res = false;
            if(f>=0 && f<cantFilas() && c>=0 && c<cantColumnas()){
                tablero[f][c] = r;
                res = true;
            }

        return res;
    }

    // << Consultas >>
    public int cantFilas(){
        return tablero.length;
    }
    public int cantColumnas(){
        return tablero[0].length;
    }
    public int cantRefugios(){
        int cont = 0;

        for(int i=0;i<cantFilas();i++){
            for(int j=0;j<cantColumnas();j++){
                if(tablero[i][j] != null)cont++;
            }
        }

        return cont;
    }
    public int filaMasPoblada(){
        int filaMPoblada = 0;
        int cantFilaMasPoblada = 0;
        int cont = 0;

        for(int i=0; i<cantFilas(); i++){
            for(int j=0; j<cantColumnas(); j++){
                if(tablero[i][j]!=null)cont++;
            }
            if(cont > cantFilaMasPoblada){
                filaMPoblada = i;
                cantFilaMasPoblada = cont;
            }

            cont = 0;
        }

        return filaMPoblada;
    }
    public boolean maximoNRefugioHabitables(int f, int n){
        boolean res = true;
        int contHabitables = 0;

        if(f<0 || f>cantFilas())res = false;
        for(int i=0; i<cantColumnas()&& res && contHabitables <= n && cantColumnas()-n < n;i++){
            if(tablero[f][i].esHabitable())contHabitables++;
        }
        if(contHabitables > n)res = false;

        return res;
    }
    public int cantConDisponibilidadMayor(int m){
        int cont = 0;

        for(int i=0;i<cantFilas();i++){
            for(int j=0;j<cantColumnas();j++){
                if(tablero[i][j].disponibilidad() > m)cont++;
            }
        }
        return cont;
    }
    public boolean territorioEspejo(){
        boolean res = true;

        if(cantColumnas() % 2 == 0)res = false;
        else{
            for(int i=0;i<cantFilas() && res;i++){
                for(int j=0;j<cantColumnas()/2 && res;j++){
                    if(tablero[i][j] != null && tablero[i][j].equals(tablero[i][cantColumnas()-j]))res=false;
                }
            }
        }

        return res;
    }
    public ColeccionRefugios coleccionFila(){
        ColeccionRefugios newCollection = new ColeccionRefugios(cantFilas());
        int cont = 0;

        for(int i=0;i<cantFilas();i++){
            if(tablero[i][cont] != null){
                newCollection.insertarRefugio(tablero[i][cont]);
                cont = 0;
            }else{
                cont++;
            }
        }

        return newCollection;
    }
    public Territorio clone(){
        Territorio newTerritorio = new Territorio(cantFilas(), cantColumnas());
        for(int i=0;i<cantFilas();i++){
            for(int j=0;j<cantColumnas();j++){
                if(tablero[i][j] != null){
                    newTerritorio.establecerRefugio(tablero[i][j], i, j);
                }
            }
        }

        return newTerritorio;
    }
    
}