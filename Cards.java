import java.util.*;

public class Cards{
      private ArrayList<String> deck = new ArrayList<>();
      private ArrayList<String> discard = new ArrayList<>();
      private String topCard;

      public Cards(){
        int randPos = 0;
        String tempCard;
        boolean valid = false;
        String[] colors = {"R","Y", "G", "B"};
        //creates deck-------------------------------------------------------------------------------------------------------------------------
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
    }


    public ArrayList<String> getDeck(){
        return deck;
    }
    public ArrayList<String> getDiscard(){
        return discard;
    }
    public String getTopCard(){
        return topCard;
    }
    public void discard(String card){
      discard.add(0,card);
      topCard = discard.get(0);
    }
    public boolean isValid(String card){
      if(card.indexOf("wild")>=0||card.indexOf("+4")>=0){
        return true;
      }else if (card.substring(0,1).equals(topCard.substring(0,1))){
        return true;
      }else if (card.substring(1,2).equals(topCard.substring(1,2))){
        return true;
      }else{
        System.out.println(topCard);
        return false;
      }
    }
    public String draw(){
      return deck.remove(0);
    }
    public boolean isSpecial(String str){
        boolean result = false;
        if (!(str.charAt(0) != '+' && Character.isDigit(str.charAt(1)))){
            result = true;
        }
        return result;
    }
}