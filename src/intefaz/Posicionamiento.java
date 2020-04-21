/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mundo.Obstaculo;
import mundo.Tablero;

/**
 *
 * @author USER
 */
public class Posicionamiento extends Application //Clase que permite almacenar datos de la posicion 
{
    private Stage alreP;
    private Scene ventanaP;
    private StackPane orgNormalP;
    
    private Label etiquetaTitle, etiquetaSerOEs, numberStart,numberEnd;
    private ComboBox<String> orgMain; //recolectores de datos de posicionamiento
    private ComboBox<Integer>end,starter;
    private Button btnPosicionar;
    
    private GridPane orgGrilla;
    private VBox orgVertical, orgVertical1,orgVertical2, orgVertical3,orgVertical4;
    
    private Alert notificacion;
    
    //Datos numericos enteros de aumento
    private int contador;
    private int iniciosN,finalesN[];
    private Tablero tablero;
    
    
    

    public Posicionamiento(Tablero tableroRShi) //Tablero por relacion
    {
         tablero = tableroRShi;
         System.out.println("Tablero Recogido");
        contador =0;
        
    }
    
    
    
    @Override
    public void start(Stage stage)  
    {
       etiquetaTitle = new Label("Porfavor escoja la posicion de las escaleras y las serpientes");
       
       etiquetaSerOEs = new Label("Seleccione:");//etiquetas para el ComboBox
       numberStart= new Label("Inicio del componente escogido:");
       numberEnd = new Label("Fin del componente escogido:");
               
       
       
       orgMain = new ComboBox();//ComboBox para selecionar componente a guardad posicion
       end = new ComboBox();
       starter = new ComboBox();
       
       //--------<< Elementos para las comboBox
       orgMain.getItems().addAll("Escaleras");
       
        for (int i = 1; i <=100; i++) {//Asignacion de numeros de escaleras
            end.getItems().add(i);
        }
           
        for (int i = 1; i <= 100; i++) {
            starter.getItems().add(i);
        }
       
       //-------->> 
       
       
       btnPosicionar = new Button("Posicionar");
       
       
       //--------<< Eventos del Boton posicionar
       
       btnPosicionar.setOnAction((t) -> {
           
           
           
           
           System.out.println("El valor escogido es "+ orgMain.getValue());
           System.out.println("El inicio del comoponete "+ orgMain.getValue()+" es de "+ starter.getValue());
           System.out.println("El fin del comoponete "+ orgMain.getValue()+" es de "+ end.getValue());
           contador++;
           System.out.println("El contador va en "+ contador);
           
           
               
           if(contador ==1){// Base para todo el juego de asignacion de escaleras //primera escalera inicio, fin
               
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
               
              
            
               
               
           }
           if(contador ==2){// Base para todo el juego de asignacion de escaleras //Segunda escalera inicio, fin
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
              
              
               
           }
           if(contador ==3){// Base para todo el juego de asignacion de escaleras //Tercera escalera inicio, fin
               
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
               orgMain.getItems().clear();
               orgMain.getItems().add("Serpiente");
               
               
           }
           if(contador ==4){//asignacion de serpientes// Primera serpiente inicio, fin
               
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
              
               
               
           }
           if(contador ==5){// segunda serpiente inicio, fin
               
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
           }
           
           if(contador ==6){// Tercera serpiente inicio, fin
               
               Obstaculo momento = new Obstaculo(starter.getValue(), end.getValue());
               tablero.añadirobstaculo(momento);
               
               System.out.println("Ya se agregaron las tres escaleras y las tres serpientes");
               
               Game juego = new Game(tablero);
               Stage stageTempoMib = new Stage();
               stageTempoMib = stage;
               juego.start(stageTempoMib);
               
               
               
           } 
           
       });
       
       
       
       //-------->>
       
       orgVertical1 = new VBox(0);//asignacion de la organizacion del comboBox con etiqueta
       orgVertical1.getChildren().addAll(etiquetaSerOEs,orgMain);
       
       orgVertical2 = new VBox(0);
       orgVertical2.getChildren().addAll(numberStart,starter);//Resalta primero la entrada de la escalera
       
       orgVertical3 = new VBox(0);
       orgVertical3.getChildren().addAll(numberEnd,end);
       
       
       orgGrilla = new GridPane();//Organizacion por rejilas (Asignacin de objetos)
       orgGrilla.setAlignment(Pos.CENTER);//posicionamiento de los elementos en el centro
       orgGrilla.setGridLinesVisible(false);
       orgGrilla.setVgap(30);//espacio de grilas verticalmente 
       orgGrilla.setHgap(30);//espacio de grilas Horizontalmente
       orgGrilla.add(orgVertical1, 0, 0);
       orgGrilla.add(orgVertical2, 0, 1);
       orgGrilla.add(orgVertical3, 1, 1);
       
       orgVertical = new VBox(30);
       orgVertical.setAlignment(Pos.CENTER);
       orgVertical.getChildren().addAll(etiquetaTitle,orgGrilla,btnPosicionar);
       
       orgNormalP = new StackPane();
       orgNormalP.getChildren().add(orgVertical);
       
       ventanaP = new Scene(orgNormalP,400,280);
       
       alreP = new Stage();
       alreP = stage;
       alreP.setScene(ventanaP);
       alreP.setTitle("Menu de seleccion");
       alreP.show();

        
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    
}
