import java.util.*;

public class Game{
    private ArrayList<String> deck = new ArrayList();
    private ArrayList<String> discard = new ArrayList();
    private String[] colors = {"R","Y", "G", "B"};

    public Game(){
      int randPos = 0;
      String tempCard;
        for (int i = 0; i < 4; i++){ //runs for each color
          for (int k = 0; k < 10; k++){//runs for each number
            randPos = (int)(Math.random()*deck.size());
            tempCard = colors[i] + k;
            deck.add(randPos, tempCard);
          }
          for (int k = 1; k < 10; k++){//runs for each number except 0
            randPos = (int)(Math.random()*deck.size());
            tempCard = colors[i] + k;
            deck.add(randPos, tempCard);
          }
          for (int k = 0; k < 2; k++){//adds +2 cards
            randPos = (int)(Math.random()*deck.size());
            tempCard = colors[i]+"+2";
            deck.add(randPos, tempCard);
          }
          for (int k = 0; k < 2; k++){//adds skip cards
            randPos = (int)(Math.random()*deck.size());
            tempCard = colors[i]+"skip";
            deck.add(randPos, tempCard);
          }
          for (int k = 0; k < 2; k++){//adds reverse cards
            randPos = (int)(Math.random()*deck.size());
            tempCard = colors[i]+"reverse";
            deck.add(randPos, tempCard);
          }
        }
        for (int k = 0; k < 4; k++){//adds +4 cards
          randPos = (int)(Math.random()*deck.size());
          tempCard = "+4";
          deck.add(randPos, tempCard);
        }
        for (int k = 0; k < 4; k++){//adds wild cards
          randPos = (int)(Math.random()*deck.size());
          tempCard = "wild";
          deck.add(randPos, tempCard);
        }

        System.out.println("The game has started. ");
        System.out.println(deck);
        System.out.println(deck.size());
    }

    public void createPlayer(Player p){//creates a player and gives them cards
      for (int i = 0; i< 7; i++){
        p.addCard(deck.get(0));
        deck.remove(0);
      }
    }
}