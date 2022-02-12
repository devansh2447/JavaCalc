import java.io.*;
import java.util.*;

/**
 * interface for calculator
 *
 * @Devansh
 * @1.0
 */
public class JavaCalcInterface
{
    //minor interface operations
    public static void print(String print, int newLine){
        System.out.print(print);
        if(newLine == 1){
            newLine();
        }
    }

    public static void newLine(){
        System.out.println("");
    }

    //main ui
    public static void mainInterface(boolean isFirstTime) throws IOException, FileNotFoundException {
        if(isFirstTime == true){
            processFile("C:\\Users\\devan\\Coding\\init.txt");
        }
        Scanner input = new Scanner(System.in);
        newLine();
        print("Please enter your input here, with no spaces", 1);
        newLine();
        String initial;
        initial = input.nextLine();
        String finalSend;
        finalSend = NegativeHandler.replaceMinus(initial, 1);
        String result;
        result = B.solveBrackets(finalSend, B.bracketPairCount(finalSend, "(", ")", 1, 0)) + "";
        newLine();
        print(initial + " = " + result, 1);
        Scanner check = new Scanner(System.in);
        newLine();
        print("Press y if you want to continue or press any other letter to exit", 1);
        newLine();
        String continueCheck;
        continueCheck = check.nextLine();
        if(continueCheck.equals("y") || continueCheck.equals("Y")){
            newLine();
            mainInterface(false);
        }
        else{
            System.exit(0);
        }
    }

    public static void processFile (String filename)
    throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader (filename);
        BufferedReader in = new BufferedReader (fileReader);
        while (true) {
            String s = in.readLine();
            if (s == null) break;
            System.out.println (s);
        }
    }   
}
