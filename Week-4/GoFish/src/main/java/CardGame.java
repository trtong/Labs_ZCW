import java.util.ArrayList;

public abstract class CardGame implements Game {


    Deck deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> houseHand;

    public CardGame() {
        deck = new Deck();
        playerHand = new ArrayList<Card>();
        houseHand = new ArrayList<Card>();

    }

    public void dealHand(int howManyCards) {

        for (int i = 0; i < howManyCards; i++) {
            playerHand.add(deck.dealCard());
            houseHand.add(deck.dealCard());

        }

    }

    public Integer sumPlayer(){
        Integer count = 0;
        for (int i = 0; i < playerHand.size(); i ++){
            count+= playerHand.get(i).getValue().getSecondaryvalue();
            if(count > 21 && playerHand.contains("Ace")){
                count -= 10;
            }
        }
        return count;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getHouseHand() {
        return houseHand;
    }

}

