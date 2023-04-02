import java.util.Scanner; //for terminal input

class Main {
  public static void main(String[] args) {
    String[] colors = {"R","Y", "G", "B"};
    boolean playing = true;
    CardCounter deck = new CardCounter();
    Game uno = new Game();
    Player computer = new Player();
    uno.createPlayer(computer);
    Player person = new Player();
    uno.createPlayer(person);


    while (playing){

      playing = false;
    }
  }
}