package PontoonGui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launch extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pontoon");

        System.out.println("game start");
        Player P1 = new Player();
        House P2 = new House();

        int playertotal = 0;
        int house = P2.gethousetotal();

        Card Card1 = new Card();
        Card Card2 = new Card();
        int card1 = Card1.getCard();
        int card2 = Card2.getCard();
        int total;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid, 500, 500);

        Text displayYourCards = new Text();
        String text = "your have drawn a "+card1+" and a "+card2+", would you like to draw another card?";
        displayYourCards.setText(text);
        displayYourCards.setX(500);
        displayYourCards.setY(10);
        grid.add(displayYourCards,0,0);

        Button yesBtn = new Button("Yes");
        HBox hbYBtn = new HBox(10);
        hbYBtn.getChildren().add(yesBtn);
        grid.add(yesBtn,0,1);

        Button noBtn = new Button("no");
        HBox hbNBtn = new HBox(10);
        hbYBtn.getChildren().add(noBtn);
        grid.add(noBtn,1,1);

        Text displayNewCard = new Text();

        yesBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public int handle(ActionEvent event) {
                Card Newcard = new Card();
                int newcard = Newcard.getCard();
                String newText = "your new card is a " + newcard;
                displayNewCard.setText(newText);
                total = total + newcard;
                return total;
            }
        });


        System.out.println("you have "+playertotal+" and house has "+house);

        if(playertotal > 21){
            if(house < 22) {
                System.out.println("youre bust, house wins");
            }
            else if(house > 21) {
                System.out.println("youre both bust, its a draw");
            }
        }

        if(playertotal < 22) {
            if(house > 21) {
                System.out.println("house is bust, you win");
            }
            else if(house < 22) {
                if(playertotal > house) {
                    System.out.println("you win");
                }
                else if(house > playertotal) {
                    System.out.println("you loose");
                }
                else {
                    System.out.println("its a draw");
                }

            }
        }
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
