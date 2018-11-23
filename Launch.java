package Pontoon;

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
    Card Newcard = new Card();
    int newcard;
    Text displayYourCards = new Text();

    GridPane grid = new GridPane();
    int draw = 2;
    int total;
    int house;
    String newText;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pontoon");

        System.out.println("game start");
        House P2 = new House();

        int playertotal = 0;
        house = P2.gethousetotal();

        Card Card1 = new Card();
        Card Card2 = new Card();

        int card1 = Card1.getCard();
        int card2 = Card2.getCard();
        int draws = 2;
        total = card1 + card2;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid, 500, 500);

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



        yesBtn.setOnAction(Event ->
        {
            Text displayNewCard = new Text();
            newcard = Newcard.getCard();
            newText = "your new card is a "+newcard;
            displayNewCard.setText(newText);
            grid.add(displayNewCard,0, draw);
            draw++;
            total = total +newcard;


        });

        noBtn.setOnAction(Event ->
        {
            Text displayTotals = new Text();
            newText = "you have "+total+" and house has "+house;
            displayTotals.setText(newText);
            draw++;
            grid.add(displayTotals, 0, draw);

            Text displayWinner = new Text();

            if(total > 21){
                if(house < 22) {
                    newText = "youre bust, house wins";
                }
                else if(house > 21) {
                    newText = "youre both bust, its a draw";
                }
            }

            if(total < 22) {
                if(house > 21) {
                    newText = "house is bust, you win";
                }
                else if(house < 22) {
                    if(total > house) {
                        newText = "you win";
                    }
                    else if(house > total) {
                        newText = "you loose";
                    }
                    else {
                        newText = "its a draw";
                    }

                }
            }
            displayWinner.setText(newText);
            draw++;
            grid.add(displayWinner, 0, draw);

        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public int newTotal(int totalHolder,int newCardHolder){
        totalHolder = totalHolder + newCardHolder;
        return totalHolder;
    }
}