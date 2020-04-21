/*
 * To change this license header, choose License Headers in Project Properties. Licencia:
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author USER
 */
public class Tablero {//tablero o lista, es la clase dirigente de la aplicacion
    private NodoCasilla inicio;
    private NodoCasilla fin;
    private int contador;

    
     public Tablero() 
    {
        System.out.println("Lista tablero creado....");
        inicio = null;
        fin = null;
        contador=0;
        
    }
    //metodo para verificar si hay algun elemento en la lista
     public boolean isthere(){
         return inicio ==null; 
         
     }
     
     
     //metodo para añadir un objeto 
     public void addCasilla(NodoCasilla nwNodo){
         if(isthere()){//si no hay ningun objeto 
             inicio = nwNodo;
             fin = nwNodo;
             contador++;
         }else{//si ya existe algun elemento,objeto o algo dentro de la lista
             NodoCasilla tempo = new NodoCasilla();//Nodo temporal para realizar guerdado sin una reasignacion costante
             tempo = inicio;
             inicio = nwNodo;
             inicio.setAtras(fin);//Manera de volver un "ciclo la cadena"
             fin.setAtras(inicio);
             nwNodo.setSiguiente(tempo);
             nwNodo.setAtras(tempo.getAtras());
             contador++;

     }
         
         
         
         
     }
     
     
     
     public void printTablero()//Metodo Funcional para imprimir lista
     {
         
         NodoCasilla t2= inicio;//var temporal para almacenar e imprimir 

          for (int i = 1; i <= getContador(); i++) {//Metodo de imprension de lista mediante IdexInterno
             
              //sin remplazar el inicio de la lista
              System.out.println("Casilla #"+t2.getDato().getNumeroCasilla()+", los jugares que hay son:"+
                      t2.getDato().getpJugador1()+" y "+t2.getDato().getPjugador2()+" Escalera(E):"+t2.getDato().getpEscaleraint()+" Escalera(S):"+t2.getDato().getpEscaleraExit()+". sE:"+t2.getDato().getpSerpienteInt()+". Sf:"+t2.getDato().getpSerpienteBack());

              t2 = t2.getSiguiente();
         }
         
     }
     public Casilla buscarCasilla(int idexS)
     {
         NodoCasilla t3= inicio;
         
         for (int i = 1; i <= getContador(); i++) {
             if(t3.getDato().getNumeroCasilla()==idexS){
                
                 Casilla casilla = t3.getDato();
                 System.out.println("La casilla "+t3.getDato().getNumeroCasilla()+" se encontro");
                 return casilla;
             }else{
                 t3 = t3.getSiguiente();
                 
             }
             
         }
         return null;//Si no esta la casilla en la lista entonces el metodo no hara nada
     }
     
     
     public void modCasilla(int setXNodo,String player)//Funciona igual que el metodo buscar
     { 
         NodoCasilla t4= inicio;
         NodoCasilla t10 = inicio;
         NodoCasilla t11 = inicio;
         NodoCasilla t12 = inicio;
         if(player.equalsIgnoreCase("J1")){
         for (int i = 1; i <= getContador(); i++) //Busqueda por cada nodo en listado
         {
             if(t4.getDato().getNumeroCasilla()==setXNodo){
                 t4.getDato().setpJugador1(player);
                 
                 
             }else{
                 t4 = t4.getSiguiente();
             }
             
             
         }
         }
         if(player.equalsIgnoreCase("J2")){
             
             
             for (int i = 1; i <= getContador(); i++) //Busqueda por cada nodo en listado
         {
             if(t10.getDato().getNumeroCasilla()==setXNodo){
                 t10.getDato().setPjugador2(player);
                 
                 
             }else{
                 t10 = t10.getSiguiente();
                 
             }
             
         }
         }
             
             //caso de cambio a nulo
             if(player.equalsIgnoreCase("None#R")){
         for (int i = 1; i <= getContador(); i++) //Busqueda por cada nodo en listado
         {
             if(t11.getDato().getNumeroCasilla()==setXNodo){
                 t11.getDato().setpJugador1(player);
                 
                 
             }else{
                 t11 = t11.getSiguiente();
             }
             
             
         }
         }//cambio a nulo dos punto cero
             if(player.equalsIgnoreCase("None#RR")){
         for (int i = 1; i <= getContador(); i++) //Busqueda por cada nodo en listado
         {
             if(t12.getDato().getNumeroCasilla()==setXNodo){
                 t12.getDato().setPjugador2(player);
                 
                 
             }else{
                 t12 = t12.getSiguiente();
             }
             
             
         }
         }
             
             
         
         //Si no esta la casilla en la lista entonces el metodo no hara nada
         
         
     
     }
     public boolean itsWin(){//realizar metodo para verificar si hay ganador
         NodoCasilla t9 = inicio;
         for (int i = 0; i < getContador(); i++) {
             
             if(t9==fin){
                 
             }else{
                 t9 = t9.getSiguiente();
             }
             
         }

         if(t9.getDato().getpJugador1().equalsIgnoreCase("J1")||t9.getDato().getPjugador2().equalsIgnoreCase("J2")){
             System.out.println("El juego a terminado");
             
             return true;
         }else{
             System.out.println("No hay ningun jugador en la ultima casilla ganadora");
             return false;
         }
}
     public void setComponent(int index,int indexfin,String compentInput) // metodo bastante complejo asignacion de escaleras y serpientes por la inicial
     {
         NodoCasilla t5 = inicio;
         NodoCasilla t6 = inicio;
         NodoCasilla t7 = inicio;
         NodoCasilla t8 = inicio;
         if(compentInput.substring(0, 1).equalsIgnoreCase("E")){
         for (int i = 1; i <= getContador(); i++) 
         {
             if(index == t5.getDato().getNumeroCasilla())
             {
                 t5.getDato().setpEscaleraint(compentInput);
                 System.out.println("Componente establecido");

             }else{
                 System.out.println("No se encontro componente establecido");
                 t5 = t5.getSiguiente();
         }
             
             
         }
         
         for (int i = 1; i <= getContador(); i++) 
         {
             if(indexfin == t6.getDato().getNumeroCasilla())
             {
                 t6.getDato().setpEscaleraExit(compentInput+"f");
                 System.out.println("Componente establecido");
             }else{
                 System.out.println("No se encontro componente establecido");
                 t6 = t6.getSiguiente(); 
         } 
         }
         }
          //Serpientes--------------------------------------------------<<<<<<<<<
         if ((compentInput.substring(0, 1)).equalsIgnoreCase("S")) {
             for (int i = 1; i <= getContador(); i++) 
            {
             if(index == t7.getDato().getNumeroCasilla())
             {
                 t7.getDato().setpSerpienteInt(compentInput);
                 System.out.println("Componente establecido");

             }else{
                 System.out.println("No se encontro componente establecido");
                 t7 = t7.getSiguiente();
         }
            }
            for (int x = 1; x <= getContador(); x++) 
         {
             if(indexfin == t8.getDato().getNumeroCasilla())
             {
                 t8.getDato().setpSerpienteBack(compentInput+"f");
                 System.out.println("Serpiente establecido");

             }else{
                 System.out.println("No se encontro componente establecido");
                 t8 = t8.getSiguiente(); 
      
         }
             
             System.out.println("Es una serpiente xd aiuda");
             
         }
         }
         
     }
     public int getX(int casilla)
     {
         NodoCasilla t13 = inicio;
         int x =0;
         for (int i = 1; i <= 100; i++) {
             if(t13.getDato().getNumeroCasilla()==casilla){
                 x = t13.getDato().getX();
                 return x;
                 
             }  else{
                 t13 = t13.getSiguiente();
             }
             
             
         }
         return 0;
     }
     public int getY(int casilla)
     {
         NodoCasilla t14 = inicio;
         int y =0;
         for (int i = 1; i <= 100; i++) {
             
             if(t14.getDato().getNumeroCasilla()==casilla){
                 y = t14.getDato().getY();
                 return y;
                 
             }else{
                 t14 = t14.getSiguiente();
             }
         }
         return 0;
     }
     public void añadirobstaculo(Obstaculo casilla){
         NodoCasilla tempo = inicio;
         
         for (int i = 1; i <= getContador(); i++) {
             if (tempo.getDato().getNumeroCasilla()==casilla.getX()){
                 tempo.getDato().setObstaculo(casilla);
                 
             } else {
                 tempo = tempo.getSiguiente();
                 
             }
             
             
         }
         
     }
     
     /**
      * @return 
      * @param x Este metodo me recive si el numero de casilla para buscar el final del obstaculo
      * @return Este metodo me retorna valor final de ese obstaculo
      */
     public int itsObstaculo(int x){
         
         NodoCasilla tempo = inicio;
         for (int i = 1; i <= getContador(); i++) {
             if(tempo.getDato().getNumeroCasilla()==x){
                 
                     return tempo.getDato().getObstaculo().getY();
                     

                 
             }else{
                 tempo = tempo.getSiguiente();
             }
             
         }
         return 0;
         }
     
     public boolean isthereObstaculo(int x){
         NodoCasilla tempo = inicio;
         for (int i = 1; i <= getContador(); i++) {
             if(tempo.getDato().getNumeroCasilla()==x){
                 if(tempo.getDato().getObstaculo().getX() ==0&&tempo.getDato().getObstaculo().getY() ==0){
                     
                 
                 
                     return false;
                 }else{
                     return true;
                 }

                 
             }else{
                 tempo = tempo.getSiguiente();
             }
             
         }
         return false;
         
     }
     
     public void printObstaculos(){
         NodoCasilla tempof = inicio;
         for (int i = 1; i < getContador(); i++) {
             
             System.out.println("Obstaculos en X: "+tempof.getDato().getObstaculo().getX()+" Y: "+tempof.getDato().getObstaculo().getY());
             tempof = tempof.getSiguiente();
             
         }
         
         
     }
     

    public static void main(String[]args)
    {
       //Prueba de tablero y sus diferentes metodos
        Tablero lsT=new Tablero();
        
        for (int i = 1; i <= 10; i++) {
            
            lsT.addCasilla(new NodoCasilla(new Casilla(i, "Esca#1intput", "Esca#1output", "Serpiente#1input", "Serpiente#1output", "None#1", "None#2")));
        }
            
        
            
            
            
            
        
        
       
       
       
        
        
        
        

        
    }

    
    
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
