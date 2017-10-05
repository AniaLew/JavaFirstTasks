package fileprocessor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

public class FileProcessorTest {

  @Test
  public void shouldProcessFile() throws Exception {
    //given
    final FileReader fileReader = mock(FileReader.class);
    final NumbersProcessor numbersProcessor = mock(NumbersProcessor.class);

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    final String filePath = "src/main/resources/PrimeNumbers.txt";
    final List<String> inputNumbers = Arrays.asList("1  2    3");

    when(fileReader.readFromFile(filePath)).thenReturn(inputNumbers);
    when(numbersProcessor.processNumbers(inputNumbers)).thenReturn(Arrays.asList("1+2+3"));

    FileProcessor fileProcessor = new FileProcessor(numbersProcessor, fileReader);

    //when
    List<String> processedLines = fileProcessor.processFile(filePath);

    //then
    assertEquals("1+2+3", processedLines.get(0));
    verify(fileReader).readFromFile(captor.capture());
    verify(numbersProcessor, timeout(1)).processNumbers(inputNumbers);

    verifyNoMoreInteractions(fileReader, numbersProcessor);

    String actualPath = captor.getValue();
    assertEquals(filePath, actualPath);
  }
}