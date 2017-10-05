package fileprocessor;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class NumbersProcessorTest {

  @Test
  @Parameters(method = "getParametersForProcessing")
  public void ShouldProcessNumbers(List<String> numbersListToProcess, List<String> expectedList)
      throws Exception {
    //given
    NumbersProcessor numbersProcessor = new NumbersProcessor();
    //when
    List<String> actualLines = numbersProcessor.processNumbers(numbersListToProcess);
    //then
    for (int i = 0; i < expectedList.size(); i++) {
      assertEquals(expectedList.get(i), actualLines.get(i));
    }
  }

  private Object[] getParametersForProcessing() {
    return new Object[]{
        new Object[]{Arrays.asList(""), Arrays.asList("")},
        new Object[]{Arrays.asList("     "), Arrays.asList("")},
        new Object[]{Arrays.asList("    1   2     "), Arrays.asList("1+2 = 3")},
        new Object[]{Arrays.asList("    1      2         3      "), Arrays.asList("1+2+3 = 6")},
        new Object[]{Arrays.asList("   1     2           3       4  "),
            Arrays.asList("1+2+3+4 = 10")},
        new Object[]{Arrays.asList("1 2   3   4  ",
            "1 2 3 4 5",
            "1                                                                          " +
                "                                                                           " +
                "                              2                                            " +
                "                            3                                              " +
                "                                                                           " +
                "                                                                           " +
                "                                                                           "),
            Arrays.asList("1+2+3+4 = 10", "1+2+3+4+5 = 15", "1+2+3 = 6")},
    };
  }
}

