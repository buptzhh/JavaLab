package Project1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingCar extends Application{
	@Override
	public void start(Stage primaryStage) {
		HBox hbox = new HBox();
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		TextField text3 = new TextField();
		TextField text4 = new TextField();
		hbox.getChildren().addAll(new Label("car1:"),text1,new Label("car2:"),text2,
				new Label("car3:"),text3,new Label("car4:"),text4);
		
		VBox vbox = new VBox();
		Image image_car = new Image("file:bin\\car\\car.png");
		Car car1 = new Car(image_car);
		Car car2 = new Car(image_car);
		Car car3 = new Car(image_car);
		Car car4 = new Car(image_car);
		vbox.getChildren().addAll(car1,new Line(0,0,800,0),
				car2,new Line(0,0,800,0),
				car3,new Line(0,0,800,0),
				car4,new Line(0,0,800,0));
		
		text1.setOnAction(e->car1.setSpeed(Double.valueOf((text1.getText()))));
		text2.setOnAction(e->car2.setSpeed(Double.valueOf((text2.getText()))));
		text3.setOnAction(e->car3.setSpeed(Double.valueOf((text3.getText()))));
		text4.setOnAction(e->car4.setSpeed(Double.valueOf((text4.getText()))));
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(hbox);
		borderpane.setCenter(vbox);
		
		Scene scene = new Scene(borderpane,800,400);
		scene.setFill(Color.WHITE);
		primaryStage.setTitle("ShowMyCar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

class Car extends Pane{
	private double speed = 10;
	private int height = 75;
	private int width = 150;
	private double location;
	private ImageView imageView;
	private Timeline animation;
	
	public Car(Image arg0) {
		super();
		imageView = new ImageView(arg0);
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
		getChildren().add(imageView);
		location = 0;
		animation = new Timeline(
				new KeyFrame(Duration.millis(10),e->moveCar()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		if(speed>=0) {
		this.speed = speed;
		}
	}
	public void moveCar() {
		if(location>800) {
			location = 0;
		}else {
			if(speed>0) {
				location += 10/speed;
			}
		}
		imageView.setX(location);
	}
}