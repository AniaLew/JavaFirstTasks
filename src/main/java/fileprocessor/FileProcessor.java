package fileprocessor;

import java.io.FileNotFoundException;
import java.util.List;

public class FileProcessor {

  private final NumbersProcessor processor;
  private final FileReader fileReader;

  FileProcessor(NumbersProcessor processor, FileReader fileReader) {
    this.processor = processor;
    this.fileReader = fileReader;
  }

  public List<String> processFile(String filePath) throws FileNotFoundException {
    List<String> linesFromFile = fileReader.readFromFile(filePath);
    return processor.processNumbers(linesFromFile);
  }
}
