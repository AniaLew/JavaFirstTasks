package fileprocessor;


import java.util.ArrayList;
import java.util.List;

public class NumbersProcessor {

  public List<String> processNumbers(List<String> linesFromFileContainingNumbers) {
    List<String> results = new ArrayList<>();
    for (String line : linesFromFileContainingNumbers) {
      results.add(processLine(line));
    }
    return results;
  }

  private String processLine(String line) {
    List<String> stringListOfNumbers = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    line = line.trim();
    for (String stringNumber : line.split("[\\s]+")) {
      stringListOfNumbers.add(stringNumber);
    }
    Long sum = 0L;
    for (String stringNumber : stringListOfNumbers) {
      Integer number = 0;
      if (!stringNumber.equals("")) {
        stringBuilder = stringBuilder.append(stringNumber + "+");
        number = Integer.valueOf(stringNumber);
      }
      sum = sum + number;
    }
    if (stringBuilder.length() != 0) {
      stringBuilder.delete(stringBuilder.lastIndexOf("+"), stringBuilder.lastIndexOf("+") + 1);
      stringBuilder.append(" = " + sum.toString());
    }
    return stringBuilder.toString();
  }
}


