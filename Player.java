import java.util.*;
public class Player {
    private ArrayList<String> cards = new ArrayList<>();
    private int playerNum;
    private Cards c;
    public Player(int n, Cards crd){
      playerNum = n;
      c=crd;
    }
    public void addCard(String card){
        cards.add(card);
    }
    public ArrayList<String> getCards(){
        return cards;
    }
    public int getPlayerNum(){
        return playerNum;
    }
    public void move(){
        Scanner reader = new Scanner(System.in);
        int cardToPlay=0;
        boolean valid = false;
        
        //ask player to make a move
        System.out.println("It is now player "+playerNum+"'s turn. Your cards are: ");
        System.out.println(cards);
        System.out.println("The card on the table is: "+c.getTopCard());
        while (!valid){//runs until player enters valid card
          System.out.println("Enter the card you want to play: ");
          cardToPlay = Integer.valueOf(reader.nextLine());
          if (cards.size() > cardToPlay && cardToPlay>=0){//if player wants to play a card
            if (c.isValid(cards.get(cardToPlay))){
              if (cards.get(cardToPlay).equals("wild") || cards.get(cardToPlay).equals("+4")){//add color to wild card
                boolean done = false;
                while (!done){
                  System.out.println("What color would you like to change to? (R/Y/G/B)");
                  String color = reader.nextLine();
                  if (color.equals("R")||color.equals("Y")||color.equals("G")|color.equals("B")){
                    c.discard(color + cards.remove(cardToPlay));
                    done = true;
                  }
                }
                valid = true;
              }else{
                c.discard(cards.remove(cardToPlay));
               valid = true;
              }
            }
          }else if (cardToPlay==-1){//if player wants to draw a card
            cards.add(c.draw());
            valid = true;
          }else{//if card is not valid
            System.out.println("that move is not valid. try again");
          }
        }
    }
}
