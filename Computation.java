
/**
 * Initializes arithmetic operations and provides methods for getting equations from string containing provided by user
 *
 * @Devansh
 * @1.0
 */
//complete, DO NOT ALTER
public class Computation
{
    //develop methods to complete operations
    //use character comparision to get int/double for computations- write in one method for universal use
    public static double init(String compute){
        return O.compute(compute, 0);
    }
    
    //gets first term
    public static String getFirst(String compute, int position, int recurse){
        //recurse = position - 1, position = position of operand as per charAt
        if(recurse > 0){
            String compare;
            compare = compute.charAt(recurse) + "";
            if(compare.equals("1") || compare.equals("2") || compare.equals("3") || compare.equals("4") || compare.equals("5") || compare.equals("6") || compare.equals("7") || compare.equals("8") || compare.equals("9") || compare.equals("0") || compare.equals(".") || compare.equals(",") || compare.equals("-") ){
                return getFirst(compute, position, recurse - 1);
            }
            else{
               return compute.substring(recurse + 1, position); 
            }
        }
        else{
            return compute.substring(0, position);
        }
    }
    
    //gets second term
    public static String getSecond(String compute, int position, int recurse){
        //invoke with recurse = 1, position = position of operand as per charAt
        if(position + recurse < compute.length()){
            String compare;
            compare = compute.charAt(position + recurse) + "";
            if(compare.equals("1") || compare.equals("2") || compare.equals("3") || compare.equals("4") || compare.equals("5") || compare.equals("6") || compare.equals("7") || compare.equals("8") || compare.equals("9") || compare.equals("0") || compare.equals(".") || compare.equals(",") || compare.equals("-")){
                return getSecond(compute, position, recurse + 1);
            }
            else{
               return compute.substring(position + 1, position + recurse); 
            }
        }
        else{
            return compute.substring(position + 1, compute.length());
        }
    }
    
    //gets position
    public static int getPosition(String compute, String check, int start){
        //invoke with start = char position from which checking is to be started
        return compute.indexOf(check, start);
    }
}
