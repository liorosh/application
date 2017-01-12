package application;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class stripsController {
	Pane[][] logicBoard=new Pane[20][12];
	Furniture furniture= new Furniture(new Coordinates(3,3),new Coordinates(6,7));
	logicStrips logic = new logicStrips();
	ArrayList <Wall> walls= new ArrayList<Wall>();
	@FXML
    private Button up,down,rotateleft,rotateright,moveright,moveleft;

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
    void rotateright(ActionEvent event)
    {
		logic.rightrotateFurniture(logicBoard,furniture);
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

    	for(int i = furniture.upperLeft.x; i < furniture.bottomRight.x ;i++)
    	{
    		for(int j = furniture.upperLeft.y; j < furniture.bottomRight.y; j++)
    		{
    			logicBoard[i][j].setStyle("-fx-background-color:#dae753;");
    		}
    	}
    }
}