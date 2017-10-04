package ipvalidator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IpAddressValidatorTest {

  @Test
  public void shouldValidateIpAddress() throws Exception {
    //given
    Boolean actual = false;
    for (int i = 0; i < 255; i++) {
      String ip = i + "." + i + "." + i + "." + i;
      IpAddressValidator checker = new IpAddressValidator(ip);
      //when
      actual = checker.validateIpAddress();
      //then
      assertEquals(true, actual);
    }
  }

  @Test
  public void shouldPrintOutIpRegexGroups() throws Exception {
    String ip = "234.123.12.9";
    IpAddressValidator validator = new IpAddressValidator(ip);
    validator.printIpRegexGroups();
  }

}