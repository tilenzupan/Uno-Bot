import java.util.*; //for terminal input

class Main {
  public static CardCounter deck = new CardCounter();
  private static Game uno = new Game();
  public static void main(String[] args) {
    String[] colors = {"R","Y", "G", "B"};
    boolean playing = true;
    Player computer = new Player();
    uno.createPlayer(computer);
    Player person = new Player();
    uno.createPlayer(person);


    while (playing){
      playerMove(person);
      //playing = false;
      if (person.getCards().size()<=0 || computer.getCards().size()<=0){
        playing = false;
      }
      makeMove(computer);
      if (person.getCards().size()<=0 || computer.getCards().size()<=0){
        playing = false;
      }
    }
  }
  public static void playerMove(Player p){
    Scanner reader = new Scanner(System.in);
    int cardToPlay=0;
    boolean valid = false;
    System.out.println("It is now your turn. Your cards are: ");
    System.out.println(p.getCards());
    System.out.println("The card on the table is: "+uno.getDiscard().get(0));
    while (!valid){
      System.out.println("Enter the card you want to play: ");
      cardToPlay = reader.nextInt();
      if (p.getCards().size()< cardToPlay){
        if (uno.isValid(p.getCards().get(cardToPlay))){
          uno.discard(p.playCard(cardToPlay));
          valid = true;
        }
      }else if (cardToPlay==-1){
        p.addCard(uno.draw());
        valid = true;
      }
    }
  }
  public static void makeMove(Player c){

  }
}