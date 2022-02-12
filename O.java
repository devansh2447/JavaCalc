
/**
 * Handles exponents in equation
 *
 * @Devansh
 * @1.0
 */
//complete, DO NOT ALTER
public class O
{
    //Computation
    public static double compute(String compute, int start){
        int position;
        position = Computation.getPosition(compute, "^", start);
        if(position != - 1){
            String first;
            String second;
            double firstTerm;
            double secondTerm;
            first = Computation.getFirst(compute, position, position - 1);
            second = Computation.getSecond(compute, position, 1);
            firstTerm = Double.parseDouble(first);
            secondTerm = Double.parseDouble(second);
            String result;
            result = Math.pow(firstTerm, secondTerm) + "";
            String before;
            before = compute.substring(0, position - first.length());
            String after;
            after = compute.substring(position + second.length() + 1, compute.length());
            String newCompute;
            newCompute = before + result + after;
            return compute(newCompute, position - first.length());
        }
        else{
           return DM.compute(compute, 0); 
        }
    }
}
