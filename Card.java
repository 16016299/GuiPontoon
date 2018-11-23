package PontoonGui;

public class Card {

    int value;

    public int getCard(){
        this.value = (int) (Math.random() * 9) + 1;
        return this.value;
    }
}