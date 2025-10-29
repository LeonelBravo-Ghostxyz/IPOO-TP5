package ej5;

public class Poliza {

    // << Atributos de Instancia >> 
    private int nroPoliza;
    private float incendio,robo;
    private boolean activa;

    // << Constructores >>
public Poliza(int np){
    nroPoliza = np; activa = true;
};
public Poliza(int np, float i, float r){
    nroPoliza = np; incendio = i; robo = r; activa = true;
};

    // << Comandos >>
public void establecerIncendio(float m){
    incendio = m;
};
public void establecerRobo(float m){
    robo = m;
};
public void actualizarPorcentaje(int p){
    if(activa){ 
        /* Valores de p 0%-100% => 0-100 (en int) */
        incendio = incendio * ((float)(100+p)/100); /* sumo 100 a p para mantener el valor de incendio < resultado haciendo asi que siempre se incremente */
        robo = robo * ((float)(100+p)/100);
    }
};
public void activar(){
    activa = true;
}
public void desactivar(){
    activa = false;
}

    // << Consultas >>
public int obtenerNroPoliza(){
    return nroPoliza;
}
public float obtenerIncendio(){
    return incendio;
}
public float obtenerRobo(){
    return robo;
}
public float obtenerCostoPoliza(){
    return robo+incendio;
}
public boolean estaActiva(){
    return activa;
}

}