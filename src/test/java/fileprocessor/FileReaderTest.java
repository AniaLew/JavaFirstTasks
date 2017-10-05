package fileprocessor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderTest {

  @Test
  public void shouldReadFromFile() throws Exception {
    //given
    String writtenFilePath = "src/main/resources/WrittenToFileSumOfPrimeNumbers.txt";

    //when
    List<String> actualList = new FileReader().readFromFile(writtenFilePath);

    //then
    assertEquals(readExpectedLinesFromFile(writtenFilePath), actualList);
  }

  private List<String> readExpectedLinesFromFile(String filePath) throws IOException {
    return Files.readAllLines(Paths.get(filePath));
  }
}