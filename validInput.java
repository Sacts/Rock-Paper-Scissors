import java.util.*;


public class validInput {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);// Creates a new scanner Object
        String input = myObj.nextLine(); // Takes input from the user
        boolean finalAnswer = isValid(input); //Checks if input is valid by calling function 'isValid'
        if (finalAnswer){
            System.out.println("VALID"); // Prints "VALID" if function returns true
        } else {
            System.out.println("INVALID"); // Prints "INVALID" if function returns false
        }
    }

    public static Boolean isValid(String inputString){

        if (inputString.length() == 1){ // Checks if the inputString is a Character
            char inputChar = inputString.charAt(0); // Stores input Character into a variable
            return inputChar == 'R' || inputChar == 'S' || inputChar == 'P'; // checks if character is valid
        }

        if (inputString.isEmpty()){ // Checks if input string is empty
            return false;
        }

        if (inputString.charAt(0) == ')' ){  // Checks if input string starts with ")"
            return false;
        }

        for (int i = 0; i < inputString.length(); i++){ // This loops through the input string
            char temp = inputString.charAt(i);
            if (temp != 'R' && temp != 'S' && temp != 'P' && temp != '(' && temp != ')' && temp != '&'){
                return false; // This checks if the input string contains an invalid character
            }
        }

        if (inputString.replaceAll(" ", "").equals(inputString)){ // Checks for space in input string
            Stack<Character> stack = new Stack<>(); // initializes a stack
            Character temp = 'R'; // This initializes a temporary variable to replace output of game
            for (char charInput : inputString.toCharArray()) { // Loops through the input string
                if (charInput == ')' && stack.size() >= 4) { // Checks if input has ')' and 4 characters before
                    stack.pop(); // pops the last character in the stack(supposedly either R,P,S)
                    char t1 = stack.pop();// pops second last character which is supposed to be a '&'
                    stack.pop(); // pops third last character in the stack(supposedly either R,P,S)
                    char t2 = stack.pop();// pops fourth last character which is supposed to be a '('
                    if (t1 == '&' && t2 == '(') { // Checks if valid game hand for example (R&P)
                        stack.push(temp); // replaces a game hand for example (R&P) with temp(R)
                    } else {
                        return false;
                    }
                } else {
                    stack.push(charInput); // Pushes input character onto stack if not closing bracket
                }
            }
            stack.pop(); // Pops last element of stack remaining
            return stack.isEmpty(); // returns true if stack is empty
        } else {
            return false;
        }
        }

}
