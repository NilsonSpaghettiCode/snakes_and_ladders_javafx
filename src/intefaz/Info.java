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
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mundo.Reglas;


public class Info extends Application
{
   private Stage alreInfor;
   private Scene ventanaInfor;
   private StackPane orgNormalI;
   
   private Label etiquetaTitulo;
   private Button btnReglas,btnInfo, btnAtras;
   private VBox orgVerticalI;
   
   private Alert notificacionReglas;
   private Alert notificacionInfo;
    
    
    
    
    
    @Override
    public void start(Stage stage) 
    {
        etiquetaTitulo = new Label("Reglas del juego");
        
        btnReglas = new Button("Reglas");//Creacion botones del interfaz  
        btnInfo = new Button("Informacion");
        btnAtras = new Button("Volver Atras");
        
        orgVerticalI = new VBox(50);//Creacion del contenedor de elementos de tipo vertical(VBox)
        orgVerticalI.setAlignment(Pos.CENTER);
        orgVerticalI.getChildren().addAll(etiquetaTitulo,btnReglas,btnInfo,btnAtras);//Linea para agregar elementos
        
        //-------<Creacion de eventos para los botones(Relacion de ventanas)
        btnReglas.setOnAction((t) -> 
        {
          notificacionReglas = new Alert(Alert.AlertType.INFORMATION);//Notificacion con las reglas
          notificacionReglas.setContentText(new Reglas().getReglas());
          notificacionReglas.show();
            
        });
        
        
        btnInfo.setOnAction((t) -> //--------Informacion
        {
           notificacionInfo = new Alert(Alert.AlertType.INFORMATION);
           notificacionInfo.setContentText("Desarrolladores del juego: Andres Lugo, Nilson Vargas");
           notificacionInfo.show();  
        });
        
        
        btnAtras.setOnAction((t) -> {
            alreInfor.close();
          InterfazApp iir = new InterfazApp();
          iir.start(stage);
            
            
        });
        
        orgNormalI = new StackPane();//Contenedor normal total
        orgNormalI.setAlignment(Pos.CENTER);
        orgNormalI.getChildren().add(orgVerticalI);
        
        ventanaInfor = new Scene(orgNormalI, 500,500);
        
        alreInfor = new Stage();
        alreInfor.setTitle("Reglas e información");
        alreInfor.sizeToScene();
        alreInfor.setScene(ventanaInfor);
        alreInfor.show();
        
        
        
        
        
        
        
                
        
        
        
        
        
        
        
    }
    
    
    
    
}
