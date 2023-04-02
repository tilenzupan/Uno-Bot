import java.util.*;
public class Player {
    private ArrayList<String> cards = new ArrayList<>();
    public Player(){
      
    }
    public void addCard(String card){
        cards.add(card);
    }
    public ArrayList<String> getCards(){
        return cards;
    }
}
