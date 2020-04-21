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
public class Obstaculo 
{
   private int x, y;

    public Obstaculo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Obstaculo() 
    {
        
        x = 0;
        y =0;
                
    }
    public boolean itsObstaculo(){
        if(x==0){
            return true;
            
        }else{
        return false;
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
    
    
    
    
    
    
}
