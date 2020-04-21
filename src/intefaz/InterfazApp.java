/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;


import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mundo.Casilla;
import mundo.NodoCasilla;
import mundo.Obstaculo;
import mundo.Tablero;

/**
 *
 * @author USER
 */
public class InterfazApp extends Application{
    private Stage alre;
    private Scene ventana;
    private StackPane orgNormal;//componentes necesarios para la creacion de una interfaz
    
    Label eticTitulo;
    Button btnJugar,btnReglasinfo,btnCerrar;
    VBox orgVertical;
    
    private Tablero tablero,tableroTest ;

    public InterfazApp() 
    {
        
        tablero = new Tablero();
        tableroTest = new Tablero();
        int x =100;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) 
            {
                
                NodoCasilla casilla = new NodoCasilla(new Casilla(x, i, j, "inputE", "OutputE", "InputS", "OutPutS",new Obstaculo(0, 0), "None#1", "None#2"));
                tableroTest.addCasilla(casilla);
                x--;
            }
        }
        tableroTest.printTablero();
  
        
        
        
        
        for (int i = 1; i <= 100; i++) {
            NodoCasilla casilla = new NodoCasilla(new Casilla(i, "inputE", "OutputE", "InputS", "OutPutS", "None#1", "None#2"));
            tablero.addCasilla(casilla);
        }
        
        System.out.println(tablero.getContador());
        tablero.printTablero();
    }
    

    
    public static void main(String[] args) 
    {
        
        launch(args);
    }

    @Override
    public void start(Stage stage) 
    {
        
        eticTitulo = new Label("Bienvenido a Snakes N'");//Titulo 
        eticTitulo.setStyle("");
        
        
        
        
        btnJugar = new Button("Jugar");//creacion de botones
        btnReglasinfo = new Button("Reglas/informacion");
        btnCerrar = new Button("Cerrar");
        
        //------------<< Asignacion de los eventos en los botones primarios
        
        btnJugar.setOnAction((t) -> {//entrada al juego
            
            Posicionamiento mip = new Posicionamiento(tableroTest);
            alre.close();
            Stage alretempo = new Stage();
            alretempo = stage;
            mip.start(alretempo);
            
            
            
        });
        btnReglasinfo.setOnAction((t) -> {//Informacion del juego y desarrolladores
            alre.close();
            Info interfaz = new Info();
            System.out.println("Ventana Creada");
            Stage stagesi = new Stage();
            stagesi = stage;
            interfaz.start(stagesi);
            
            
        });
        
        
        
        
        btnCerrar.setOnAction((t) -> {//evento para cerrar programa
            
            System.exit(0);
            
        });
        
        
        
        
        //------------>>
        
        
        orgVertical = new VBox(25);
        orgVertical.setAlignment(Pos.CENTER);
        orgVertical.getChildren().addAll(eticTitulo,btnJugar,btnReglasinfo,btnCerrar);//asiganacion del componente caja vertical
        
        orgNormal = new StackPane(orgVertical);
        orgNormal.setAlignment(Pos.CENTER);
        //------------<< Metodo para cambiar el fondo del juego
        Image  fonddesk = new Image("imagenes/FondoPag.jpg");
        BackgroundImage imagenf = new BackgroundImage(fonddesk, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background( imagenf);
        orgNormal.setBackground(fondo);
        //------------>>
        
        
        ventana = new Scene(orgNormal,250, 300);
        
        
        
        
        alre = stage;
        
 
        alre.setScene(ventana); //configuraciones del marco de la ventana
        alre.setResizable(false);
        
        
        
        alre.setTitle("Snakes N'");
        
        alre.show();
        
        
        
    }
    
}
