// Start of SRPN.java.
// ......................................................................................
// TABLE OF CONTENTS
// ......................................................................................
// A. Importing useful packages.
// B. Defining a public class for the Saturated Reverse Polish Notatation (SRPN).
//  B.1 Defining variable instances.
//  B.2 Creating a new Stack to store input strings.
//  B.3 Defining a processCommand (String s) method which processes the input strings
//  from the Main.java.
//    B.3.1 Creating an array that with all the "characters" of the input string as strings. 
//    B.3.2 Running through each element of the array and creating a stack.
//    B.3.2.1 Identifying if the input string is "+" operator.
//    B.3.2.2 Identifying if the input string is "-" operator.
//    B.3.2.3 Identifying if the input string is "*" operator.
//    B.3.2.4 Identifying if the input string is "/" operator.
//    B.3.2.5 Identifying if the input string is "^" operator.
//    B.3.2.6 Identifying if the input string is "%" operator.
//    B.3.2.7 Identifying if the input string is the character "d".
//    B.3.2.8 Identifying if the input string is the character "r".
//    Β.3.2.9 Identifying if the string is empty.
//    B.3.2.10 Identifying if the input string is "=" operator.
//    B.3.2.11 Identifying if the input string is one a letter.
//    B.3.2.12 Identifying if the input string is one of the remaining special characters.
//    B.3.2.13 (Finally) Pushing value on the top of the stack.
// C. Defining the methods which are used in section B.
//  C.1 Defining a methods that takes a string and converts to a double.
//  C.2 Defining a method for "+" calculations.
//  C.3 Defining a method for "-" calculations.
//  C.4 Defining a method for "*" calculations.
//  C.5 Defining a method for "/" calculations.
//  C.6 Defining a method for "^" calculations.
//  C.7 Defining a method for "*" calculations.
//  C.8 Exploding the input string into an array with multiple elements.
//  C.9 Defining a method "Ispow" used in Method C.6.
//  C.10 Defining a method for the stack "saturation".
//  C.11 Checking if the string contains a letter.
//  C.12 Checking if the string contains a number.
//  C.13 Method for "r" function.
//.....................................................................................

// A. Importing useful packages.
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// B. Defining a public class for the Saturated Reverse Polish Notatation (SRPN).
public class SRPN {
  // B.1 Defining variable instances.
  private int curToken = 0;
  private int newToken = 0;
  int minSRPN = -2145783648;
  int stkUpLimit = 22;
  int counter;

  // B.2 Creating a new Stack to store input strings as integers.
  private Stack <Integer> stk = new Stack <> ();

  // B.3 Defining a processCommand (String s) method which processes the input strings
  //from the Main.java.
  public void processCommand (String s) {

    // B.3.1 Creating an array where all the "characters" of the input string as strings.
    String [] strarray =  strExplode (s); // Please see Method C.8.

    // B.3.2 Running through each element of the array created above. and creating a stack.
    // Checking each item in the array in accordance with the following cases.
    // If array item equals to string, then it is transformed to integer and pushed in the stack.
    for (int i = 0; i < strarray.length; i++) { // Going trough each item of the array.
      s = strarray [i]; 

      // B.3.2.1 Identifying if the input string is "+" operator.
      if (s.equals ("+")) {
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operAdd (stk); // Please see Method C.2.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.2 Identifying if the input string is "-" operator.
      else if (s.equals ("-")) {
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operSub (stk); // Please see Method C.3.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.3 Identifying if the input string is "*" operator.
      else if (s.equals ("*")) {
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operMult(stk); // Please see Method C.4.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.4 Identifying if the input string is "/" operator.
      else if (s.equals ("/")) { 
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operDiv (stk); // Please see Method C.5.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.5 Identifying if the input string is "^" operator.
      else if (s.equals ("^")) {
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operPow (stk); // Please see Method C.6.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.6 Identifying if the input string is "%" operator.
      else if (s.equals ("%")) {
        if (stk.size () <= 1) { // Cheching if the stack is underflowed.
          System.out.println ("Stack underflow.");
        }
        else {
            newToken = operMod (stk); // Please see Method C.7.
            stk.push (newToken); // Pushing new integer value on top of the stack.
        }
      }

      // B.3.2.7 Identifying if the input string is the character "d".
      else if (s.equals ("d")) {
        // Using an if-else condition to check if the stack is empty and display "-2147483648".
        // This value not to be saved on the stack.
        if (stk.empty () == true) { // Cheching if the stack is empty.
          System.out.println (minSRPN); // If so, it prints minSRPN.
        }
        else {
          // Using toArray method of Stack class to form an array of the same elements
          // as that of our stack.
          Object [] dArray = stk.toArray ();
          // Using a for loop to print each item on the array.
          for (int j = 0; j < dArray.length; j++) {
            System.out.println (dArray [j]);
          }
        }
      }

      // B.3.2.8 Identifying if the input string is the character "r".
      // Not 100% sure how this calculator's functions works.
      // My best guess can be seen below.
      else if (s.equals ("r")) {
        // By tesing the given program, I think there are 22 different values for "r" character.
        if (stk.size () >= stkUpLimit) { // Cheching if the stack is overflowed.
          System.out.println ("Stack overflow."); 
        }
        else {
          counter = counter + 1; // Using a counter to count how many times r appears.
          String value = rFuncton (counter); // Please see Method C.13.
          curToken = Integer.parseInt (value); // Transform string to integer.
          stk.push (curToken); // Pushing new integer value on top of the stack.
        }
      }

      // Β.3.2.9 Identifying if the string is a " " (s)pace).
      else if (s.equals (" ")){ //Nothing happens.
      // I am quite sure there is a more efficient way to do that.
      }

      // B.3.2.10 Identifying if the input string is "=" operator.
      else if (s.equals ("=")) {
        if (stk.empty () == true) { // Checking if the stack is empty.
          System.out.println ("Stack empty.");
        }
        else {
          System.out.println (stk.peek ()); // Displaying top item on the stack.
        }
      }

      // B.3.2.11 Identifying if the input string is a letter.
      else if (isLetter (s)) { // Please see Method C.11.
        System.out.println ("Unrecognised operator or operand \""+s+"\"."); 
      }

      // B.3.2.12 Identifying if the input string is one of the remaining special characters.
      else if (!isLetter (s) && !isDig (s)) { // Please see Method C.11 & C.12.
        System.out.println ("Unrecognised operator or operand \""+s+"\".");
      }

      // B.3.2.13 Pushing digit on the top of the stack.
      else {
        if (stk.size () >= stkUpLimit) {
          System.out.println ("Stack overflow."); // Cheching if the stack is overflowed.
        }
        else {
          double value = toDouble (s); // Please see Method C.1.
          curToken = (int) isSat (value); // Please see Method C.10.
          stk.push (curToken); // Pushing new integer value on top of the stack.
      } }
    }
  }

// C. Defining the methods which are used in section B.

  // C.1 Defining a methods that takes a string and converts to a double.
  public double toDouble (String s) {
    double value = Double.parseDouble (s);
    return value;
  }

  // C.2 Defining a method for "+" calculations.
  public int operAdd (Stack stk) {
    double value = 0;
    double value1 = (int) stk.pop ();
    double value2 = (int) stk.pop ();
    double value3 = (int) (value2 + value1);
    value = isSat(value3); // Please see Method C.10.
    return (int) value;
  }

  // C.3 Defining a method for "-" calculations.
  public int operSub (Stack stk) {
    double value = 0;
    double value1 = (int) stk.pop ();
    double value2 = (int) stk.pop ();
    double value3 = (int) (value2 - value1);
    value = isSat (value3); // Please see Method C.10.
    return (int) value;
  }

  // C.4 Defining a method for "*" calculations.
  public int operMult (Stack stk) {
    double value = 0;
    double value1 = (int) stk.pop ();
    double value2 = (int) stk.pop ();
    double value3 = (int) (value2 * value1);
    value = isSat (value3); // Please see Method C.10.
    return (int) value;
  }

  // C.5 Defining a method for "/" calculations.
  public int operDiv (Stack stk) {
    if ( (int) stk.peek () == 0) {
      System.out.println ("Divide by 0.");
    }
    else {
      double value = 0;
      double value1 = (int) stk.pop ();
      double value2 = (int) stk.pop ();
      double value3 = (int) (value2 / value1);
      value = isSat (value3); // Please see Method C.10.
      return (int) value;
    }
    return 0;
  }

  // C.6 Defining a method for "^" calculations.
  public int operPow (Stack stk) {
    double value = 0;
    double value1 = (int) stk.pop ();
    double value2 = (int) stk.pop ();
    double value3 = isPow (value1, value2); // Please see Method C.9.
    value = isSat (value3); // Please see Method C.10.
    return (int) value;
  }

  // C.7 Defining a method for "*" calculations.
  public int operMod (Stack stk) {
    double value = 0;
    double value1 = (int) stk.pop ();
    double value2 = (int) stk.pop ();
    double value3 = (int) (value2 % value1);
    value = isSat (value3); // Please see Method C.10.
    return (int) value;
  }

  // C.8 Exploding the input string.
  // Each string character is stored in a string array list. 
  // Then it is converted to a string array and passed on the main program.
  public String [] strExplode (String s) {
    s += " "; // Adding a space at the end of the string.
    List <String> arr = new ArrayList <> (); // Creating a new string array list.
    StringBuilder sb = new StringBuilder (); // Creating a new string builder.
    for (char c : s.toCharArray ()) { // Running through each characher of the string.
      if (Character.isDigit (c) || (sb.length () == 0 && c == '-')) {
        sb.append(c);
      } 
      else if (Character.isLetter (c) && sb.length () == 0) {
          arr.add (Character.toString (c));
      }
      else {
        if (sb.length () == 0) {
          arr.add (Character.toString (c));
        }
        else {
          arr.add(sb.toString ());
          arr.add(Character.toString (c));
          sb = new StringBuilder ();
        }
      }
    }
    arr.remove (arr.size () -1); // Removing the last item (always a "") from the list.
    String [] arrPass = arr.toArray (new String [0]); // Converting string array list to an array.
    return arrPass; // Passing string array to the main program.
  }

  // C.9 Defining a method "Ispow" used in Method C.6.
  public double isPow (double value1, double value2) {
    double value = value2;
    if (value1 == 0) {
      value = 1;
    }
    while (value1 > 1) {
      value *= value2;
      value1--;
    }
    return value;
  }

  // C.10 Defining a method for the stack "saturation".
  // Using double type solves the "wrapping around" issue for me.
  public double isSat (double val) {
    double maxSRPN = 2145783647.0; // Max value.
    double minSRPN = -2145783648.0; // Min value.
    double value = 0.0;
    if (val > maxSRPN) {
      value = maxSRPN;
    }
    else if (val < minSRPN) {
      value = minSRPN;
    }
    else {
      value = val;
    }
    return value;
  }

  // C.11 Checking if the string contains a letter.
  boolean isLetter (String s) {
    if (s == null) { // Checks if the String is null.
      return false;
    }
    int len = s.length();
    for (int i = 0; i < len; i++) {
      // Checks whether the character is not a letter.
      // If it is not a letter ,it will return false.
      if ((Character.isLetter(s.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  // C.12 Checking if the string contains a number.
  boolean isDig (String s) {
    if (s == null) { // Checks if the String is null.
      return false;
    }
    int len = s.length ();
    for (int i = 0; i < len; i++) {
      // Checks whether the character is not a letter.
      // If it is not a letter ,it will return false.
      if ((Character.isDigit (s.charAt (i)) == false)) {
        return false;
      }
    }
    return true;
  }

  // C. 13 Method for "r" function.
  public String rFuncton (int counter) {
    // Creating a string list with all the items I found out in the given program.
    List <String> rList = Arrays.asList ("1804289383", "846930886", "1681692777", "1714636915", "1957747793", "424238335", "719885386", "1649760492", "596516649", "1189641421", "1025202362", "1350490027", "783368690", "1102520059", "2044897763", "1967513926", "1365180540", "1540383426", "304089172", "1303455736", "35005211", "521595368");
    String str = rList.get (counter - 1);
    return str; 
  }

}
// End of SRPN.java.
// ......................................................................................