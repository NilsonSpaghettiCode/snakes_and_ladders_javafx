/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author USER
 */
public class NodoCasilla //Clase para dar a enterder que es un casilla y su funcionamiento
{
    private Casilla dato;
    private NodoCasilla siguiente;
    private NodoCasilla atras;

    public NodoCasilla(Casilla dato) 
    {
        atras = null;
        this.dato = dato;
        siguiente =null; 
        
    }

    public NodoCasilla() {
    }

    public Casilla getDato() {
        return dato;
    }

    public void setDato(Casilla dato) {
        this.dato = dato;
    }

    public NodoCasilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCasilla siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCasilla getAtras() {
        return atras;
    }

    public void setAtras(NodoCasilla atras) {
        this.atras = atras;
    }
    
    
    
    
    
    
    
    
    
}
