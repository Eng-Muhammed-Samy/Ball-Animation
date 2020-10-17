
package ballanimation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BallAnimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // add pane to showing a path and circle animate
        Pane root = new Pane();
        // add border to pane 
        root.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(4))));
        // add poly line to represent sine
        Polyline line = new Polyline();
        // draw sine path and add this point to line
        for(double point =0; point < 1000; point++){
         line.getPoints().add(point);
         
         int amp = 100 ; // amplitude
         int width = 200; // width op pulse 
         int vAl = 200 ;  // vertical alignment
         
         line.getPoints().add(amp*Math.sin(point/width*2*Math.PI)+vAl);
        }
        // make new path transation
        PathTransition pt = new PathTransition();
        //set duration
        pt.setDuration(Duration.millis(10000));
        // Add a path for the shape to go
        pt.setPath(line);
        // new circle and set radius 20 , and color blue
        Circle c = new Circle(20, Color.BLUE);
        c.setStroke(Color.DARKBLUE);
        c.setStrokeWidth(5);

        c.setSmooth(true);
        // edit the coordinates of circle
        c.setCenterX(30);
        c.setCenterY(500);
        // add node to path transation
        pt.setNode(c);
        // set cycle count --> infinity
        pt.setCycleCount(Timeline.INDEFINITE);
        //pt.setAutoReverse(True);
        pt.setAutoReverse(true);
        // y axis
        Line x = new Line(10,200,1050,200);
        Label xl = new Label("X");
        // edit the coordinates of x
        xl.setLayoutX(1050);
        xl.setLayoutY(215);
        // edit font size
        xl.setFont(new Font(20));
        // X axis
        Line y = new Line(500,20,500,400);
        Label yl = new Label("Y");
        // edit the coordinates of y
        yl.setLayoutX(515);
        yl.setLayoutY(20);
         // edit font size
        yl.setFont(new Font(20));
        // this lines used to draw arrows
        // draw arrow on x axis
        Line arowX1 = new Line(1040, 190, 1050, 200);
        Line arowX2 = new Line(1040, 210, 1050, 200);
         // draw arrow on y axis
        Line arowY1 = new Line(490, 30, 500, 20);
        Line arowY2 = new Line(510, 30, 500, 20);
        // add all nodes to pane
        root.getChildren().addAll(line,c, x, y,arowX1,arowX2,arowY1, arowY2, xl, yl);
        //add pane on scene
        Scene scene = new Scene(root, 1150, 450);
        // add action event type --> mouse event
        root.setOnMouseClicked((event) -> {
            // if left mouse clicked --> play the animation 
            if(event.getButton()== PRIMARY){
                pt.play();
                // if right mouse clicked --> puse the animation 
            }else if(event.getButton() == SECONDARY){
                pt.pause();
            }
        });
        // set name to application 
        primaryStage.setTitle("Ball Animation");
        //set scene to stage
        primaryStage.setScene(scene);
        primaryStage.show(); //show application
    }


    public static void main(String[] args) {
        launch(args);// start
    }
   
}
