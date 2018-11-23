package Pontoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaunchTest {

    @Test
    public void testTotal(){
        Launch launch = new Launch();
        int card1 = 4, card2 = 5;

        int y = launch.newTotal(card1, card2);

        assertEquals(9, y);

    }

}