package firstpullrequest;

public class MultiplicationTable {

  public static void main(String[] args) {
    int multiplicationTable[][] = new int[10][10];
    for (int i = 0; i < multiplicationTable.length; i++) {
      for (int j = 0; j < multiplicationTable.length; j++) {
        multiplicationTable[i][j] = (i + 1) * (j + 1);
      }
    }
    for (int i = 0; i < multiplicationTable.length; i++) {
      for (int j = 0; j < multiplicationTable.length; j++) {
        System.out.print(multiplicationTable[i][j] + ", ");
      }
      System.out.println();
    }

    System.out.println();
    String daysOfTheWeek[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
        "Saturday"};
    for (String str : daysOfTheWeek) {
      System.out.println(str);
    }
  }
}
