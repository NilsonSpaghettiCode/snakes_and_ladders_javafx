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
public class Reglas //Clase diseñada para aplicar reglas y comprension del juego
{
    private String reglas;

    public Reglas() 
    {
        reglas = "REGLAS DEL JUEGO\n" +
"1.Se juega entre dos o más personas en un tablero, pero para efectos del proyecto se manejarán solo dos jugadores.\n" +
"2.El tablero está numerado y dividido en 100 casilleros.\n" +
"3.Posee un número determinado de 3 serpientes y 3 escaleras que conectan, cada una, dos casilleros numerados.\n" +
"4.El movimiento se determina por medio de un número que digitará el usuario (Números entre 1 y 10).";
        
    }

    public Reglas(String reglas)
    {
        this.reglas = reglas;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    
    
    
    
    
    
    
}
