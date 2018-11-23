package Pontoon;

public class House {
    Card Card1 = new Card();
    Card Card2 = new Card();
    int housetotal;
    int card1 = Card1.getCard();
    int card2 = Card2.getCard();

    public int gethousetotal() {
        housetotal = card1 + card2;

        if (housetotal < 14) {
            Card Newcard = new Card();
            int newcard = Newcard.getCard();

            housetotal = housetotal + newcard;

        }
        return housetotal;
    }
}