
/**
 * replaces minus operator with _ sign to avoid conflict with negative numbers
 *
 * @Devansh
 * @1.0
 */
public class NegativeHandler
{
    public static String replaceMinus(String compute, int iter){
        if(iter <= compute.length()){
            if(iter == 1){
                return replaceMinus(compute, iter + 1);
            }
            else{
                String compare;
                compare = compute.charAt(iter - 1) + "";
                String before;
                before = compute.charAt(iter - 2) + "";
                boolean isNumber;
                isNumber = isNumber(before);
                if(compare.equals("-") && isNumber == true){
                    String previous;
                    previous = compute.substring(0, iter - 1);
                    String after;
                    after = compute.substring(iter, compute.length());
                    String newCompute;
                    newCompute = previous + "_" + after;
                    return replaceMinus(newCompute, iter + 1);
                }
                else{
                    return replaceMinus(compute, iter + 1);
                }
            }
        }
        else{
            return compute;
        }
    }
    
    public static boolean isNumber(String check){
        if(check.equals("0") || check.equals("1") || check.equals("2") || check.equals("3") || check.equals("4") || check.equals("5") || check.equals("6") || check.equals("7") ||check.equals("8") || check.equals("9") || check.equals(")")){
            return true;   
        }
        else{
            return false;
        }
    }
}
