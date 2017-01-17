package application;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class stripsController {
	Pane[][] logicBoard=new Pane[20][12];
	Furniture furniture= new Furniture(new Coordinates(3,3),new Coordinates(5,6),new Coordinates(3,3),new Coordinates(5,6));
	logicStrips logic = new logicStrips();
	
	
	
    @FXML
    private TextField x1;
    
    @FXML
    private TextField y4;

    @FXML
    private TextField x3;

    @FXML
    private TextField x4;
    
    @FXML
    private TextField y3;

    @FXML
    private TextField y2;
    
    @FXML
    private TextField y1;

    @FXML
    private TextField x2;

	@FXML
    private Button up,down,rotateleft,rotateright,moveright,moveleft,addFurniture;

    @FXML
    private GridPane board;

    @FXML
    void left(ActionEvent event)
    {
		logic.move(logicBoard,furniture,0,-1);
    }

    @FXML
    void right(ActionEvent event)
    {
		logic.move(logicBoard, furniture,0,1);
    }

    @FXML
    void up(ActionEvent event)
    {
		logic.move(logicBoard,furniture,-1,0);
    }

    @FXML
    void down(ActionEvent event)
    {
		logic.move(logicBoard,furniture,1,0);
    }

    @FXML
    void rotateleft(ActionEvent event)
    {
		logic.leftrotateFurniture(logicBoard,furniture);
    }
    
    @FXML
    void startFunction(ActionEvent event) {

    }

    @FXML
    void rotateright(ActionEvent event)
    {
		logic.rightrotateFurniture(logicBoard,furniture);
    }

    @FXML
    void addFurniture(ActionEvent event) {
    	
    	int ix1 = Integer.valueOf(x1.getText());
    	int ix2 = Integer.valueOf(x2.getText());
    	int iy1 = Integer.valueOf(y1.getText());
    	int iy2 = Integer.valueOf(y2.getText());
    	int ix3 = Integer.valueOf(x3.getText());
    	int ix4 = Integer.valueOf(x4.getText());
    	int iy3 = Integer.valueOf(y3.getText());
    	int iy4 = Integer.valueOf(y4.getText());
    	Furniture fur = new Furniture(new Coordinates(ix1,iy1),new Coordinates(ix2,iy2),new Coordinates(ix3,iy3),new Coordinates(ix4,iy4));
    	logic.furnitures.add(fur);
    	x1.setText("");
    	x2.setText("");
    	x3.setText("");
    	y4.setText("");
    	x4.setText("");
    	y1.setText("");
    	y2.setText("");
    	y3.setText("");
    	logic.handleFurniture(logicBoard,fur, "-fx-background-color:#2E64FE;");
    	//System.out.println(String.valueOf(logic.findDistance(new Coordinates(4,8), new Coordinates(7,10))));
    	//Popup pop=new Popup();
    	//pop.is
    	/*Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("Look, an Information Dialog");
    	alert.setContentText("I have a great meage for you!");

    	alert.showAndWait();*/
    }


    @FXML
    void initialize()
    {
    	for (int i = 0; i < 20;i++)
    	{
    		for (int j = 0;j < 12;j++)
    		{
    			Pane guiItem = new Pane ();
    			logicBoard[i][j] = guiItem;
    			board.add(guiItem, i, j);
    		}
    	}
    	logic.setWalls();
    	for(int i = furniture.upperLeft.x; i <= furniture.bottomRight.x ;i++)
    	{
    		for(int j = furniture.upperLeft.y; j <= furniture.bottomRight.y; j++)
    		{
    			logicBoard[i][j].setStyle("-fx-background-color:#dae753;");
    		}
    	}
    }
}
