package fileprocessor;

import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    String filePath = "src/main/resources/PrimeNumbers.txt";
    String writtenFilePath = "src/main/resources/WrittenToFileSumOfPrimeNumbers.txt";
    List<String> processedLines = new FileProcessor(new NumbersProcessor(), new FileReader())
        .processFile(filePath);

    // processedLines.forEach(System.out::println);
    new NumbersFileWriter().writeNumbersToFile(writtenFilePath, processedLines);
    List<String> finalList = new FileReader().readFromFile(writtenFilePath);
    finalList.forEach(System.out::println);
  }
}
