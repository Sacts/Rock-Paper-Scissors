import java.util.*;


public class RPSGame {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Creates a new scanner object
        String input = myObj.nextLine(); // Takes input from the user
        System.out.println(RpsChecker(input)); // Calls functions and outputs answer
    }

    public static char RpsChecker(String inputString){
        Stack<Character> stack = new Stack<>(); // Initializes a stack
        for (char inputChar : inputString.toCharArray()) { // Loops through input string
            if (inputChar == ')' && stack.size() >= 4) { // Checks stack size and if input char is closing bracket
                char t1 = stack.pop(); // Stores game variable (R, P, S)
                stack.pop();
                char t3 = stack.pop(); // Stores game variable (R, P, S)
                stack.pop();
                stack.push(gameOutput(t1,t3)); // Checks Output of game variables and replaces game hand with output
            } else {
                stack.push(inputChar); // pushes a char onto the stack
            }
        }
        return stack.firstElement(); // Returns the last element of the stack which is final answer
    }

    // This function takes in two game variables(R, P, S) and outputs the correct answer for them
    public static char gameOutput(char t1, char t2){
        if ((t1 == 'S')  && (t2 == 'P')){
            return 'S';
        } else if ((t1 == 'P')  && (t2 == 'S')){
            return 'S';
        } else if ((t1 == 'R')  && (t2 == 'S')){
            return 'R';
        } else if ((t1 == 'S')  && (t2 == 'R')){
            return 'R';
        } else if ((t1 == 'R')  && (t2 == 'P')){
            return 'P';
        } else if ((t1 == 'P')  && (t2 == 'R')){
            return 'P';
        } else if ((t1 == 'P')  && (t2 == 'P')){
            return 'P';
        } else if ((t1 == 'S')  && (t2 == 'S')){
            return 'S';
        } else {
            return 'R';
        }
    }

}
