package task1;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Flow;

public class tester extends Application
{
    public boolean isValid = false;

    public void init() throws Exception
    {
        super.init();
    }

    public void start(Stage stage) throws Exception
    {
        GridPane root = new GridPane();

        root.setMinSize(400, 200);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(root, 300, 300);

        Text ccNumPrompt = new Text("Credit Card Number ");
        TextField ccNumInput = new TextField();
        ccNumInput.setPrefColumnCount(20);



        Button submit = new Button("Submit!");

        FlowPane output = new FlowPane();

        submit.setOnAction(actionEvent -> {
            output.getChildren().clear();
            try{
                isValid = validatorFunctions.isValid(Long.parseLong(ccNumInput.getCharacters().toString()));
                if (isValid)
                {
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
            } catch (NumberFormatException err)
            {
                Text error = new Text("You have not entered a credit card number!");
                error.setFill(Color.RED);
                output.getChildren().addAll(new Text("You have not entered a credit card number!"));
            }
        });

        root.add(ccNumPrompt,0,0);
        root.add(ccNumInput,1,0);
        root.add(submit,1,1);
        root.add(output,2,2);

        stage.setScene(myScene);
        stage.setTitle("Credit Card Validator");
        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
