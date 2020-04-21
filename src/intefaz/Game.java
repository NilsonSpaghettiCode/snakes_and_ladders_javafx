/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import mundo.Tablero;

/**
 *
 * @author USER
 */
public class Game extends Application
{
    private Stage alreFg;
    private Scene ventanaFg;
    private StackPane orgNormalFg;
    
    private Label etiquetaTituloFg,etiquetaTurno;
    private GridPane tablero;
    private Circle J1,J2;
    
    private ComboBox <Integer>cajaThingsJ1, cajaThingsJ2;
    private Button btnJ1,btnJ2;
    
    private VBox orgVertical1, orgVertical2, orgVertical3;
    private HBox orgHorizontal1;
    
    private Tablero mainTablero;
    private int contable1,contable2;
    private int contableA,contableB;
    
    

    public Game(Tablero relation) 
    {
        System.out.println("Tablero recogido");
        
        mainTablero  = relation;
        System.out.println(mainTablero.getContador());
        mainTablero.printTablero();
        mainTablero.printObstaculos();
        System.out.println("Obstaculo en Y "+mainTablero.itsObstaculo(1));
        System.out.println("Obstaculo en Y "+mainTablero.itsObstaculo(2));
        System.out.println("Obstaculo en Y "+mainTablero.itsObstaculo(3));
        
        System.out.println(mainTablero.isthereObstaculo(1));
        System.out.println(mainTablero.isthereObstaculo(2));
        System.out.println(mainTablero.isthereObstaculo(3));
        
        
        
        contable1 = 0;
        contableA = 0;
        contableB = 0;
        contable2 = 0;
        
        
    }
         

    
    
    
    @Override
    public void start(Stage stage) 
    {
        etiquetaTituloFg = new Label("Snakes n'");
        etiquetaTurno = new Label("Es turno es de");
        
        tablero = new GridPane();
        
        int p =1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle re = new Rectangle(50, 50,Color.BEIGE);
                tablero.add(re, i, j);
                
                
            }
          
        }
            int y = 0;
            int x = 1;
            for (int i = 9; i >= 0; i--) {//---------<<Numeracion del tablero

              for(int j = 9; j >= 0; j--){
              HBox test = new HBox(0);
              test.setAlignment(Pos.CENTER);
              test.getChildren().add(new Label(Integer.toString(x)));
              tablero.add(test, j, i);
              x++; 
            }
            y++;
        }
        
        
        
        tablero.setAlignment(Pos.CENTER);
        tablero.setGridLinesVisible(true);
        
        
        
        J1 = new Circle(24, Color.RED);//Fichas para los Jugadores(Jugador 1)
        J2 = new Circle(18,Color.BLUE);//Jugador 2
        
        tablero.add(J1, 10, 10);//Columnas por filas
        tablero.add(J2, 10, 9);
        
        
        
        cajaThingsJ1 = new ComboBox();//configuracion ComboBox
        
        for (int i = 1; i <= 10; i++) {
            cajaThingsJ1.getItems().add(i);
        }
        

        cajaThingsJ2 = new ComboBox();
        
        for (int i = 1; i <= 10; i++) {
            cajaThingsJ2.getItems().add(i);
        }
        
        btnJ1 = new Button("Jugador #1");
        btnJ2 = new Button("Jugador #2");
        
        //---------------------------------<<Eventos Botones
        
        btnJ1.setOnAction((t) -> {//Boton de jugador numero 1
            
            if(cajaThingsJ1.getValue()==null){
                
            }else{
            
                contable2 = contable2+cajaThingsJ1.getValue();
            System.out.println("El valor en el que esta la ficha es"+contable2);//En caso de meter un valor no posible
            
            System.out.println("El valor en el que esta la ficha es"+contable2);
            try{
                if(mainTablero.isthereObstaculo(contable2)){
                    mainTablero.itsObstaculo(contable2);
                    int obsta = mainTablero.itsObstaculo(contable2);
                    System.out.println("Obstaculo en"+contable2+". Casilla final del obstaculo "+obsta);
                    contable2 = obsta;
                   int row = mainTablero.getX(contable2);
                   int collumn = mainTablero.getY(contable2);
                    System.out.println("Fila "+row+" Columna"+collumn);
                    tablero.setColumnIndex(J1, collumn);
                    tablero.setRowIndex(J1, row);
                    
                    orgVertical2.setVisible(false);
                    orgVertical3.setVisible(true);
                }
                
                int row = mainTablero.getX(contable2);
                int collumn = mainTablero.getY(contable2);
                
                tablero.setColumnIndex(J1, collumn);
                tablero.setRowIndex(J1, row);
                
                System.out.println("Sin obstaculo Fila "+row+" Columna"+collumn);
                
                orgVertical2.setVisible(false);
                orgVertical3.setVisible(true);
                
                if(row ==0&&collumn==0){
                    Alert alertaganador = new Alert(Alert.AlertType.CONFIRMATION);
                    alertaganador.setContentText("El ganador es el jugador 1(J1). Esta aplicacion se cerrada en cinco segundos(5S)");
                    alertaganador.show();
                    try {
                        Thread.sleep(5000);
                        System.exit(0);
                    } catch (Exception e) {
                    }
    
                }
                
              
            }

            catch(NullPointerException e){
                e.printStackTrace();
                Alert alertaTempo = new Alert(Alert.AlertType.ERROR);
                alertaTempo.setContentText("Error ilogico al mover ficha ");
                alertaTempo.show();
              
            }
            
            }
        });
        
        
        
        
        
        
        
        btnJ2.setOnAction((t) -> {//Boton de jugador numero 2--------------------------------------------------------------------------->>
            contable1 = contable1+cajaThingsJ2.getValue();
            System.out.println("El valor en el que esta la ficha es"+contable1);
            try{
                if(mainTablero.isthereObstaculo(contable1)){
                    mainTablero.itsObstaculo(contable1);
                    int obsta = mainTablero.itsObstaculo(contable1);
                    System.out.println("Obstaculo en"+contable1+". Casilla final del obstaculo "+obsta);
                    contable1 = obsta;
                   int row = mainTablero.getX(contable1);
                   int collumn = mainTablero.getY(contable1);
                    System.out.println("Fila "+row+" Columna"+collumn);
                    tablero.setColumnIndex(J2, collumn);
                    tablero.setRowIndex(J2, row);
                    
                    orgVertical2.setVisible(true);
                    orgVertical3.setVisible(false);
                    
                }
                
                int row = mainTablero.getX(contable1);
                int collumn = mainTablero.getY(contable1);
                
                tablero.setColumnIndex(J2, collumn);
                tablero.setRowIndex(J2, row);
                System.out.println("Sin obstaculo Fila "+row+" Columna"+collumn);
                orgVertical2.setVisible(true);
                orgVertical3.setVisible(false);
                
                if(row ==0&&collumn==0){
                    Alert alertaganador = new Alert(Alert.AlertType.CONFIRMATION);
                    alertaganador.setContentText("El ganador es el jugador Dos(J2). Esta aplicacion se cerrada en cinco segundos(5S)");
                    alertaganador.show();
                    try {
                        Thread.sleep(5000);
                        System.exit(0);
                    } catch (Exception e) {
                    }
    
                }
                
              
            }

            catch(NullPointerException e){
                e.printStackTrace();
                Alert alertaTempo = new Alert(Alert.AlertType.ERROR);
                alertaTempo.setContentText("Error ilogico al mover ficha ");
                alertaTempo.show();
              
            }
            
        });
        
        
        
        
         //--------------------------------->>
        
        orgVertical2 = new VBox(10);
        orgVertical2.setAlignment(Pos.CENTER);
        orgVertical2.getChildren().addAll(cajaThingsJ1,btnJ1);//Asignacion para el jugador 1
        
        orgVertical3 = new VBox(10);
        orgVertical3.setAlignment(Pos.CENTER);
        orgVertical3.getChildren().addAll(cajaThingsJ2,btnJ2);
        orgVertical3.setVisible(false);
        
        
        
        orgHorizontal1 = new HBox(30);
        orgHorizontal1.setAlignment(Pos.CENTER);
        orgHorizontal1.getChildren().addAll(orgVertical2,etiquetaTurno,orgVertical3);
        
        orgVertical1 = new VBox(20);
        orgVertical1.setAlignment(Pos.CENTER);
        orgVertical1.getChildren().addAll(etiquetaTituloFg,tablero,orgHorizontal1);
        
        orgNormalFg = new StackPane();
        orgNormalFg.setAlignment(Pos.CENTER);
        orgNormalFg.getChildren().add(orgVertical1);
        
        ventanaFg = new Scene(orgNormalFg,1200,750);
        
        alreFg = new Stage();
        alreFg = stage;
        alreFg.setScene(ventanaFg);
        alreFg.setTitle("Snakes N'");
        alreFg.show();
        
        
        
        
        
        
        
        
        
        
    }
        
    
    
    
    
    
    
    
}
