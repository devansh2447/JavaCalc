
/**
 * Solves brackets and sends end result for final Computation
 *
 * @Devansh
 * @1.0
 */
//class complete, DO NOT ALTER
public class B
{
    //gets the contents of a specified bracket pair
    //complete, DO NOT ALTER
    public static String bracketPair(String compute, int start){
        if(compute.indexOf("(", start) == -1 && compute.indexOf(")", start) == -1){
            return compute;
        }
        else{
            String solve;
            solve = Computation.init(compute.substring(compute.indexOf("(", start) + 1, compute.indexOf(")", start))) + "";
            String newCompute;
            String before;
            String after;
            before = compute.substring(0, compute.indexOf("(", start));
            after = compute.substring(compute.indexOf(")", start) + 1, compute.length());
            newCompute = before + solve + after;
            int newStart;
            newStart = newCompute.indexOf("(", start) - 1;
            return bracketPair(newCompute, newStart);
        }
    }

    //counts total complete pairs of brackets in string
    //complete, DO NOT ALTER
    public static int bracketPairCount(String compute, String check1, String check2, int recurse, int forReturn){
        //invoke with recurse = 1 and forReturn = 0
        if(recurse <= compute.length()){
            String compare;
            compare = compute.charAt(recurse - 1) + "";
            if(compare.equals(check1) || compare.equals(check2)){
                return bracketPairCount(compute, check1, check2, recurse + 1, forReturn + 1);
            }
            else{
                return bracketPairCount(compute, check1, check2, recurse + 1, forReturn);
            }
        }
        else{
            return forReturn/2;
        }
    }

    //solves brackets
    //complete, DO NOT ALTER
    public static double solveBrackets(String compute, int recurse){
        //recurse goes backwards, find number of brackets from bracketPairCount method and use that to invoke
        if(recurse > 0){
            String solve;
            solve = bracketPair(compute, 0);
            return solveBrackets(solve, recurse - 1);
        }
        else{
            compute = bracketPair(compute, 0);
            double result;
            result = Computation.init(compute);
            return result;
        }
    }
}
