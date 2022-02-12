
/**
 * Handles divison and multiplication
 *
 * @Devansh
 * @1.0
 */
public class DM
{
    //use syntax of O class, modify to allow for conditions
    public static double compute(String compute, int start){
        int checkDivide;
        int checkMultiply;
        checkDivide = Computation.getPosition(compute, "/", start);
        checkMultiply = Computation.getPosition(compute, "*", start);
        if(checkDivide != -1 && checkMultiply != -1){
            if(checkDivide < checkMultiply){
                String before;
                String after;
                String first;
                String second;
                first = Computation.getFirst(compute, checkDivide, checkDivide - 1);
                second = Computation.getSecond(compute, checkDivide, 1);
                String result;
                result = divide(first, second) + "";
                before = compute.substring(0, checkDivide - first.length());  
                after = compute.substring(checkDivide + second.length() + 1, compute.length());
                String newCompute;
                newCompute = before + result + after;
                return compute(newCompute, checkDivide);
            }
            else{
                String before;
                String after;
                String first;
                String second;
                first = Computation.getFirst(compute, checkMultiply, checkMultiply - 1);
                second = Computation.getSecond(compute, checkMultiply, 1);
                String result;
                result = multiply(first, second) + "";
                before = compute.substring(0, checkMultiply - first.length());  
                after = compute.substring(checkMultiply + second.length() + 1, compute.length());
                String newCompute;
                newCompute = before + result + after;
                return compute(newCompute, checkMultiply);
            }
        }
        else if(checkDivide != -1 && checkMultiply == -1){
            String before;
            String after;
            String first;
            String second;
            first = Computation.getFirst(compute, checkDivide, checkDivide - 1);
            second = Computation.getSecond(compute, checkDivide, 1);
            String result;
            result = divide(first, second) + "";
            before = compute.substring(0, checkDivide - first.length());  
            after = compute.substring(checkDivide + second.length() + 1, compute.length());
            String newCompute;
            newCompute = before + result + after;
            return compute(newCompute, checkDivide);
        }
        else if(checkMultiply != -1 && checkDivide == -1){
            String before;
            String after;
            String first;
            String second;
            first = Computation.getFirst(compute, checkMultiply, checkMultiply - 1);
            second = Computation.getSecond(compute, checkMultiply, 1);
            String result;
            result = multiply(first, second) + "";
            before = compute.substring(0, checkMultiply - first.length());  
            after = compute.substring(checkMultiply + second.length() + 1, compute.length());
            String newCompute;
            newCompute = before + result + after;
            return compute(newCompute, checkMultiply);
        }
        else{
            return AS.compute(compute, 0);
        }
    }
    //develop separate method for divide and multiply, but preserve order(left to right)

    public static double divide(String first, String second){
        return Double.parseDouble(first)/Double.parseDouble(second);
    }

    public static double multiply(String first, String second){
        return Double.parseDouble(first) * Double.parseDouble(second);
    }
}
