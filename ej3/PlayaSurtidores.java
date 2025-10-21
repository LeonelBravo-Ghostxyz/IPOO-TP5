package ej3;

public class PlayaSurtidores {
 
    // << Atributos de Instancia >>
    private Surtidor[] tabla;

    // << Constructores >>
    public PlayaSurtidores(int n){
        tabla = new Surtidor[n];
    }
    public PlayaSurtidores(){
        tabla = new Surtidor[10];
    }

    // << Comandos >>
    public void establecerSurtidor(Surtidor s, int p){
        tabla[p] = s;
    }
    public void establecerSurtidor(Surtidor s){
        boolean changed = false;
        for(int i=0;i<tabla.length && !changed;i++){
            if(tabla[i] == null){
                tabla[i] = s;
                changed = true;
            }
        }
    }
    public void llenarDepositos(){
        for(int i=0;i<tabla.length;i++){
            if(tabla[i]!=null){
                tabla[i].llenarDepositoGasoil();
                tabla[i].llenarDepositoPremium();
                tabla[i].llenarDepositoSuper();
            }
        }
    }
    public void agrupaSurtidores() {
    int posVacia = 0;
    for (int i = 0; i < tabla.length; i++) {
        if (tabla[i] != null) {
            tabla[posVacia] = tabla[i];
            if (i != posVacia) {
                tabla[i] = null;
            }
            posVacia++;
        }
    }
}

    // << Consultas >>
    public int cantPosiciones(){
        return tabla.length;
    }
    public int cantSurtidores(){
        int cont = 0;
        for(int i=0;i<tabla.length;i++){
            if(tabla[i]!=null)cont++;
        }
        return cont;
    }
    public Surtidor obtenerSurtidor(int p){
        return tabla[p];
    }
    public int cantMaxCarga(){
        int cont=0;
        for(int i=0;i<tabla.length;i++){
            if(tabla[i] != null && tabla[i].depositosLlenos())cont++;
        }

        return cont;
    }
    public boolean mismosNulos(PlayaSurtidores ps){
        boolean res = true;

        if(tabla.length != ps.cantPosiciones())res=false;
        for(int i=0;i<tabla.length && res;i++){
            if(tabla[i]!=null && ps.obtenerSurtidor(i) == null || tabla[i]==null && ps.obtenerSurtidor(i)!=null)res=false;
        }

        return res;
    }
    public PlayaSurtidores clone(){
        PlayaSurtidores newPlaya = new PlayaSurtidores(cantPosiciones());

        for(int i=0;i<tabla.length;i++){
            newPlaya.establecerSurtidor(tabla[i], i);
        }

        return newPlaya;
    }
    public PlayaSurtidores nLigados(int n) {
    PlayaSurtidores res = null;
    int cantLigados = 0;
    boolean condicion = true; // Note: Flag para "seguir buscando" podria reemplazarse por un break
    int pos = -1; 

    for (int i = 0; i < tabla.length && condicion; i++) {
        
        if (tabla[i] != null) {
            if (pos == -1) {
                pos = i;
            }
            cantLigados++;
            
        } else {
            if (cantLigados >= n) {
                condicion = false; 
            } else {
                //Note: La racha no era válida, reiniciamos para buscar de nuevo
                cantLigados = 0;
                pos = -1;
            }
        }
    }
    if (cantLigados >= n) {
        res = new PlayaSurtidores(cantLigados);
        for (int i = 0; i < cantLigados; i++) {
            res.establecerSurtidor(tabla[pos + i], i); 
        }
    }

    return res;
}

public String toString(){
    String res = "Playa de Surtidores:\n";
    for(int i=0;i<tabla.length;i++){
        res += "Posicion " + i + ": ";
        if(tabla[i]!=null){
            res += tabla[i].toString() + "\n";
        } else {
            res += "Vacio\n";
        }
    }
    return res;
}

}