package task1;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.Flow;

public class tester extends Application
{
    public boolean isValid = false;

    public void start(Stage stage) throws Exception
    {
        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(root, 300, 300);

        HBox prompt = new HBox();
        Text ccNumPrompt = new Text("Please enter credit card number: ");
        TextField ccNumInput = new TextField();
        ccNumInput.setPrefColumnCount(20);
        prompt.getChildren().addAll(ccNumPrompt,ccNumInput);

        Button submit = new Button("Submit!");

        FlowPane output = new FlowPane();

        submit.setOnAction(actionEvent -> {
            output.getChildren().clear();
            isValid = validatorFunctions.isValid(Long.parseLong(ccNumInput.getCharacters().toString()));
            if (isValid)
            {
                System.out.println("card type => "+validatorFunctions.cardType);
                Image cardtype = new Image("/task1/"+validatorFunctions.cardType+".png");
                ImageView myImage = new ImageView(cardtype);
                myImage.setFitHeight(100);
                myImage.setFitWidth(100);
                myImage.setPreserveRatio(true);
                output.getChildren().addAll(new Text("Card number is VALID\t"),myImage);
            }
            else
            {
                output.getChildren().addAll(new Text("Card number is INVALID\t"));
            }
        });

        root.getChildren().addAll(prompt, submit, output);

        stage.setScene(myScene);
        stage.setTitle("Credit Card Validator");
        stage.show();
    }

    public static void main(String[] args)
    {
        System.out.println("initialized...");
        Application.launch(args);
    }
}
