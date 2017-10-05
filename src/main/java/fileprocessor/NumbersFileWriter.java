package fileprocessor;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NumbersFileWriter {

  public void writeNumbersToFile(String filePath, List<String> numbersList) throws IOException {
    try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filePath))) {
      for (String line : numbersList) {
        bufferWriter.write(line);
        bufferWriter.newLine();
      }
    }
  }
}
