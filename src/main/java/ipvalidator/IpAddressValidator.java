package ipvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator {

  private final Matcher matcher;
  private static final String IP_ADDRESS_PATTERN =
      "\\b(((0?((0?|([1-9])))\\d)|(1\\d\\d)|(2(([0-4]\\d)|([5][0-5]))))\\.){3}"
          + "((0?((0?|([1-9])))\\d)|(1\\d\\d)|(2(([0-4]\\d)|([5][0-5]))))\\b";

  public IpAddressValidator(String ip) {
    final Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN, Pattern.MULTILINE);
    this.matcher = pattern.matcher(ip);
  }

  public boolean validateIpAddress() {
    return matcher.matches();
  }

  public void printIpRegexGroups() {
    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));
      for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
      }
    }
  }

}

