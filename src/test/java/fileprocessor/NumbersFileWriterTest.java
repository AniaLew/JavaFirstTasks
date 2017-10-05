package fileprocessor;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class NumbersFileWriterTest {

  @Test
  @Parameters(method = "parametersForWritingToFile")
  public void shouldWriteNumbersToFile(List<String> linesForWriting) throws Exception {
    //given
    String actualFilePath = "src/main/resources/WrittenToFileSumOfPrimeNumbers.txt";
    String expectedFilePath = "src/main/resources/FileToTestWritingToFile.txt";

    writeToFileForTesting(expectedFilePath, linesForWriting);
    List<String> expectedList = readExpectedLinesFromFile(expectedFilePath);

    NumbersFileWriter fileWriter = new NumbersFileWriter();

    //when
    fileWriter.writeNumbersToFile(actualFilePath, linesForWriting);
    List<String> actualList = readExpectedLinesFromFile(actualFilePath);

    //then
    assertEquals(expectedList.get(0), actualList.get(0));
  }

  private Object parametersForWritingToFile() {
    return new Object[]{
        new Object[]{Arrays.asList("")},
        new Object[]{Arrays.asList("2+3+5+7+11+13+17+19+23+29 = 129")},
        new Object[]{Arrays.asList("2+3+5+7+11+13+17+19+23+29 = 129",
            "31+37+41+43+47+53+59+61+67+71 = 510")},
        new Object[]{Arrays.asList("2+3+5+7+11+13+17+19+23+29 = 129",
            "31+37+41+43+47+53+59+61+67+71 = 510",
            "73+79+83+89+97+101+103+107+109+113 = 954",
            "127+131+137+139+149+151+157+163+167+173 = 1494",
            "179+181+191+193+197+199+211+223+227+229 = 2030",
            "233+239+241+251+257+263+269+271+277+281 = 2582",
            "283+293+307+311+313+317+331+337+347+349 = 3188",
            "353+359+367+373+379+383+389+397+401+409 = 3810")},
    };
  }

  private void writeToFileForTesting(String filePath, List<String> linesToWrite)
      throws IOException {
    Files.write(Paths.get(filePath), linesToWrite);
  }

  private List<String> readExpectedLinesFromFile(String filePath) throws IOException {
    return Files.readAllLines(Paths.get(filePath));
  }
}