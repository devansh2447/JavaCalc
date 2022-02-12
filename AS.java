
/**
 * Handles addition and subtraction
 *
 * @Devansh
 * @1.0
 */
public class AS
{
    //use syntax of O class, modify to allow for conditions
    public static double compute(String compute, int start){
        int checkSubtract;
        int checkAdd;
        checkSubtract = Computation.getPosition(compute, "_", start);
        checkAdd = Computation.getPosition(compute, "+", start);
        if(checkSubtract != -1 && checkAdd != -1){
            if(checkSubtract < checkAdd){
                String before;
                String after;
                String first;
                String second;
                first = Computation.getFirst(compute, checkSubtract, checkSubtract - 1);
                second = Computation.getSecond(compute, checkSubtract, 1);
                String result;
                result = subtract(first, second) + "";
                before = compute.substring(0, checkSubtract - first.length());  
                after = compute.substring(checkSubtract + second.length() + 1, compute.length());
                String newCompute;
                newCompute = before + result + after;
                return compute(newCompute, checkSubtract);
            }
            else{
                String before;
                String after;
                String first;
                String second;
                first = Computation.getFirst(compute, checkAdd, checkAdd - 1);
                second = Computation.getSecond(compute, checkAdd, 1);
                String result;
                result = add(first, second) + "";
                before = compute.substring(0, checkAdd - first.length());  
                after = compute.substring(checkAdd + second.length() + 1, compute.length());
                String newCompute;
                newCompute = before + result + after;
                return compute(newCompute, checkAdd);
            }
        }
        else if(checkSubtract != -1 && checkAdd == -1){
            String before;
            String after;
            String first;
            String second;
            first = Computation.getFirst(compute, checkSubtract, checkSubtract - 1);
            second = Computation.getSecond(compute, checkSubtract, 1);
            String result;
            result = subtract(first, second) + "";
            before = compute.substring(0, checkSubtract - first.length());  
            after = compute.substring(checkSubtract + second.length() + 1, compute.length());
            String newCompute;
            newCompute = before + result + after;
            return compute(newCompute, checkSubtract);
        }
        else if(checkAdd != -1 && checkSubtract == -1){
            String before;
            String after;
            String first;
            String second;
            first = Computation.getFirst(compute, checkAdd, checkAdd - 1);
            second = Computation.getSecond(compute, checkAdd, 1);
            String result;
            result = add(first, second) + "";
            before = compute.substring(0, checkAdd - first.length());  
            after = compute.substring(checkAdd + second.length() + 1, compute.length());
            String newCompute;
            newCompute = before + result + after;
            return compute(newCompute, checkAdd);
        }
        else{
            return Double.parseDouble(compute);
        }
    }
    //develop separate method for subtract and add, but preserve order(left to right)

    public static double subtract(String first, String second){
        return Double.parseDouble(first) - Double.parseDouble(second);
    }

    public static double add(String first, String second){
        return Double.parseDouble(first) + Double.parseDouble(second);
    }
}
