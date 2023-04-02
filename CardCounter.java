public class CardCounter{
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
  
  public CardCounter(){

  }
  public int[][] getCounter(){
    return counter;
  }
  
  public void updateCounter(String card){
    
  }
}