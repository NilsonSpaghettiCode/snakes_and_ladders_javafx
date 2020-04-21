/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;


public class Casilla //Clase Base(Class Casilla), es la dependencia del juego sin esta el juego no sirve
{
    private int numeroCasilla, x,y;
       
    private String pEscaleraint, pEscaleraExit;
    private String pSerpienteInt,pSerpienteBack;
    
    private Obstaculo obstaculo;
    
    private String pJugador1, Pjugador2;   

    public Casilla() 
    {
        setpEscaleraint("InputE"); //InputE = entrada de una escalera
        setpEscaleraExit("OutputE");//OutPut = salida de una escalera
        
        setpSerpienteInt("InputS");
        setpSerpienteBack("OutputS");
        
        
        setpJugador1("SinJugador!1");
        setPjugador2("SinJugador!2");
        
        
        
    }

    public Casilla(int numeroCasilla, int x, int y, String pEscaleraint, String pEscaleraExit, String pSerpienteInt, String pSerpienteBack, Obstaculo obstaculo, String pJugador1, String Pjugador2) {
        this.numeroCasilla = numeroCasilla;
        this.x = x;
        this.y = y;
        this.pEscaleraint = pEscaleraint;
        this.pEscaleraExit = pEscaleraExit;
        this.pSerpienteInt = pSerpienteInt;
        this.pSerpienteBack = pSerpienteBack;
        this.obstaculo = obstaculo;
        this.pJugador1 = pJugador1;
        this.Pjugador2 = Pjugador2;
    }
    
    
    

    public Casilla(int numeroCasilla, String pEscaleraint, String pEscaleraExit, String pSerpienteInt, String pSerpienteBack, String pJugador1, String Pjugador2) {
        this.numeroCasilla = numeroCasilla;
        this.pEscaleraint = pEscaleraint;
        this.pEscaleraExit = pEscaleraExit;
        this.pSerpienteInt = pSerpienteInt;
        this.pSerpienteBack = pSerpienteBack;
        this.pJugador1 = pJugador1;
        this.Pjugador2 = Pjugador2;
    }

    public Casilla(int numeroCasilla, int x, int y, String pEscaleraint, String pEscaleraExit, String pSerpienteInt, String pSerpienteBack, String pJugador1, String Pjugador2) {
        this.numeroCasilla = numeroCasilla;
        this.x = x;
        this.y = y;
        this.pEscaleraint = pEscaleraint;
        this.pEscaleraExit = pEscaleraExit;
        this.pSerpienteInt = pSerpienteInt;
        this.pSerpienteBack = pSerpienteBack;
        this.pJugador1 = pJugador1;
        this.Pjugador2 = Pjugador2;
    }

    public Casilla(int numeroCasilla, int x, int y) {
        this.numeroCasilla = numeroCasilla;
        this.x = x;
        this.y = y;
    }

    public Casilla(int numeroCasilla, int x, int y, Obstaculo obstaculo) {
        this.numeroCasilla = numeroCasilla;
        this.x = x;
        this.y = y;
        this.obstaculo = obstaculo;
    }
    
    
    
    
    
    
    
    public static void main(String[]args){
       
        Obstaculo obstaculo = new Obstaculo(1, 8);
        Casilla test = new Casilla(1, 0, 0, obstaculo);
        Casilla test2 = new Casilla(2, 0, 0, null);
        Casilla test3 = new Casilla(3, 0, 0, null);
        Casilla test4 = new Casilla(4, 0, 0, null);
        Casilla test5 = new Casilla(5, 0, 0, null);
        test.setpJugador1("J1");
        if(test.getObstaculo().itsObstaculo()){
            test.getObstaculo().getX();
            test.getObstaculo().getY();
  
        }
        
        
        
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
    
    
    
    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public void setNumeroCasilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }

    public String getpEscaleraint() {
        return pEscaleraint;
    }

    public void setpEscaleraint(String pEscaleraint) {
        this.pEscaleraint = pEscaleraint;
    }

    public String getpEscaleraExit() {
        return pEscaleraExit;
    }

    public void setpEscaleraExit(String pEscaleraExit) {
        this.pEscaleraExit = pEscaleraExit;
    }

    public String getpSerpienteInt() {
        return pSerpienteInt;
    }

    public void setpSerpienteInt(String pSerpienteInt) {
        this.pSerpienteInt = pSerpienteInt;
    }

    public String getpSerpienteBack() {
        return pSerpienteBack;
    }

    public void setpSerpienteBack(String pSerpienteBack) {
        this.pSerpienteBack = pSerpienteBack;
    }

    public String getpJugador1() {
        return pJugador1;
    }

    public void setpJugador1(String pJugador1) {
        this.pJugador1 = pJugador1;
    }

    public String getPjugador2() {
        return Pjugador2;
    }

    public void setPjugador2(String Pjugador2) {
        this.Pjugador2 = Pjugador2;
    }

    public Obstaculo getObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }
    

    
    
    
    
}

/*
    Tres escaleras tres serpientes = e1=e2=e3; s1,s2,s3;
En la busqueda o posicionamiento de escaleras  la asignacion 
para una escalera sera por entrada y salida con la letra e mas el numero de casilla
es decir e1 = entrada, salida = e1. 

*/
