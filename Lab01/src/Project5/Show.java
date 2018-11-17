package Project5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Show extends Application{
	@Override
	public void start(Stage primaryStage) {
		HBox top = new HBox(60);
		Button find_a_solution = new Button("find a solution");
		Button refresh = new Button("Refresh");
		
		TextField text1 = new TextField("Hello");
		top.getChildren().addAll(find_a_solution,text1,refresh);
		
		Card card = new Card();
		
		HBox bottom = new HBox(56);
		Label label = new Label("Enter a experssion");
		label.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,15));
		TextField text2 = new TextField("Hello");
		Button verify = new Button("Verify");
		bottom.getChildren().addAll(label,text2,verify);
		
		BorderPane borderPane = new BorderPane();
		//borderPane.setAlignment(top,Pos.CENTER);
		borderPane.setTop(top);
		borderPane.setCenter(card);
		borderPane.setBottom(bottom);
		
		refresh.setOnAction(e->card.refresh());
		find_a_solution.setOnAction(e->text1.setText(card.findSolution()));
		verify.setOnAction(e->text2.setText(card.verify(text2.getText())));
		
		Scene scene = new Scene(borderPane,440,200);
		primaryStage.setTitle("24 Point Card Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
