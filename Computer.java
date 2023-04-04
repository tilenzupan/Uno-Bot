public class Computer extends Player{
	private String[] colors = {"R","Y", "G", "B"};
    private int[][] counter = {//counts uno cards left. rows are numbers columns are colors
    {1, 1, 1, 1, 4},//0 and +4
    {2, 2, 2, 2, 4},//1 and wild card
    {2, 2, 2, 2, 0},//2
    {2, 2, 2, 2, 0},//3
    {2, 2, 2, 2, 0},//4
    {2, 2, 2, 2, 0},//5
    {2, 2, 2, 2, 0},//6
    {2, 2, 2, 2, 0},//7
    {2, 2, 2, 2, 0},//8
    {2, 2, 2, 2, 0},//9
    {2, 2, 2, 2, 0},//+2's
    {2, 2, 2, 2, 0},//skips
    {2, 2, 2, 2, 0}//reverses
    };
  
  public Computer(int n, Cards crd){
    super(n, crd);
  }
  public int[][] getCounter(){
    return counter;
  }
  
  public void updateCounter(String card){
    int column = getColumn(card);
    int row = getRow(card, column);
    counter[row][column] -= 1;
    printCounter();
  }
  private int getColumn(String card){
    for (int i =0; i < colors.length; i++){
      if (card.substring(0,1).equals(colors[i])){
        return i;
      }
    }
      return 4;
  }
  private int getRow(String card, int column){
    if (column == 4){
      if (card.charAt(0)=='+'){
        return 0;
      }else {
        return 1;
      }
    }else if (card.charAt(1)=='+'){
      return 10;
    }else if (card.charAt(1)=='s'){
      return 11;
    }else if (card.charAt(1)=='r'){
      return 12;
    }else{
      System.out.println(Integer.valueOf(card.substring(1,2)));
      return Integer.valueOf(card.substring(1,2));
    }
  }
  private void printCounter(){
    System.out.println("cards left are");
    for (int i = 0; i < counter.length; i++){
      for (int j = 0; j < counter[i].length; j++){
        System.out.print(counter[i][j] + " ");
      }
      System.out.println();
    }
  }
}