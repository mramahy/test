package main;



import java.util.Stack;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Calc {

    public static void main(String[] args){
        System.out.print(evaluate("7 4 5 + * 3 - 10 /"));
    }

    public static double evaluate(String expr) {
        if(expr.isEmpty()){
            return 0;
        }

        String[] exprArray = expr.split(" ");
        if(!expr.contains("+")&& !expr.contains("*")&& !expr.contains("/")&& !expr.contains("-")){
            return Double.parseDouble(exprArray[exprArray.length-1]);
        }

        //load engine to calculate expression
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        boolean firstOperationOccurred = true;
        Stack<String> st = new Stack<>();
        Double result = new Double(0);
        for(int i=0;i<exprArray.length;i++){
            if(exprArray[i].matches("\\d+(\\.\\d+)?")) {
                st.push(exprArray[i]);
            }else{
                if(firstOperationOccurred){
                    String element1 = st.pop();
                    String element2 = st.pop();
                    try {
                        result =Double.parseDouble(engine.eval(element2+exprArray[i]+element1).toString());
                    } catch (ScriptException e) {
                        e.printStackTrace();
                        return result;
                    }
                    firstOperationOccurred = false;
                }else{
                    String element1 = st.pop();
                    try {
                        result =Double.parseDouble(engine.eval(result.toString()+exprArray[i]+element1).toString());
                    } catch (ScriptException e) {
                        e.printStackTrace();
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
