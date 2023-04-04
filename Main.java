import java.util.*;

class Main{
    public static void main(String[] args) {
      //variables
      boolean valid = false, playing = true;
      Cards c = new Cards();
      Computer com = new Computer (2, c);//creates computer player
      createPlayer(com, c.getDeck());//gives the computer cards
      Player person = new Player (1, c);
      createPlayer(person, c.getDeck());

        //playing game------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("The game has started. ");
        while(!valid){//waits until valid card
          c.discard(c.getDeck().remove(0));
          if (!isSpecial(c.getTopCard())){
            valid = true;
          }
        }
        System.out.println("The card on top is "+c.getTopCard());
        while(playing){
            person.move();
            //playing = false;
            if (person.getCards().size()<=0 || com.getCards().size()<=0){
              playing = false;
            }
            com.move();
            if (person.getCards().size()<=0 || com.getCards().size()<=0){
              playing = false;
            }
        }
    }

    private static void createPlayer(Player p, ArrayList<String> de){//creates a player and gives them cards
      for (int i = 0; i< 7; i++){
        p.addCard(de.get(0));
        de.remove(0);
      }
    }

    private static void discard(String card,  ArrayList<String> de,  ArrayList<String> dis){
      dis.add(0,card);
    }
    private static boolean isValid(String card){
      return false;
    }
    private static String draw( ArrayList<String> de){
      return de.remove(0);
    }
    private static boolean isSpecial(String str){
        boolean result = false;
        if (!(str.charAt(0) != '+' && Character.isDigit(str.charAt(1)))){
            result = true;
        }
        return result;
    }
}