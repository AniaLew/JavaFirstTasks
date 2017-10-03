package firstpullrequest;

import java.util.Scanner;

public class MethodOverloading {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Introduce yourself.");

    System.out.print("What is your first name:");
    String firstName = scan.nextLine();

    System.out.print("What is your surname: ");
    String surname = scan.nextLine();

    System.out.print("How old are you: ");
    int age = scan.nextInt();
    scan.nextLine();

    System.out.print("What country do you live in: ");
    String country = scan.nextLine();

    scan.close();

    introductionOfPerson(firstName, surname);
    introductionOfPerson(firstName, surname, age);
    introductionOfPerson(firstName, surname, age, country);
  }

  public static void introductionOfPerson(String firstName, String surname) {
    System.out.println("Your name is " + firstName + " " + surname + ".");
  }

  public static void introductionOfPerson(String firstName, String surname, int age) {
    System.out.println("Your name is " + firstName + " " + surname + ". You are " + age + " old.");
  }

  public static void introductionOfPerson(String firstName, String surname, int age,
      String country) {
    System.out.println(
        "Your name is " + firstName + " " + surname + ". You are " + age + " old. You are from "
            + country + ".");
  }
}
