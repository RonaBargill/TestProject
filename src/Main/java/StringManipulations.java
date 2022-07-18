import java.util.Stack;

public class StringManipulations {
    static Stack<Character> operations = new Stack<>();
    static Stack<Integer> elements = new Stack<>();
    public static int findMathExpressionFromString(String s){
        operations = new Stack<>();
        elements = new Stack<>();
        int nextElement;
        int res;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                    break;
                case ')':
                    res = calcFromStacks();
                    elements.push(res);
                    break;
                case'+':
                case '-':
                    operations.push(c);
                    break;
                case '*':
                case '/':
                case '^':
                    // pop last element and execute the expression
                    if(s.charAt(i+1) != '(') {
                        nextElement = Character.getNumericValue(s.charAt(i+1));
                        int lastElem = elements.pop();
                        res = operationOnElements(lastElem, nextElement, c);
                        elements.push(res);
                        i++;
                    }
                    else{
                        operations.push(c);
                    }
                    break;
                default:
                    elements.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        if(elements.size() == 1)  return elements.pop();
        else if (elements.size() == 2){
            return calcFromStacks();
        }
        else return 0;
    }
    private static int operationOnElements(int elem1, int elem2, char operation){
        switch(operation){
            case '*':
                return elem1*elem2;
            case '^':
                return elem1^elem2;
            case '/':
                return elem1/elem2;
            case '+':
                return elem1+elem2;
            case '-':
                return elem1-elem2;
            default:
                return 0;
        }
    }
    private static int calcFromStacks(){
        int elem1 = elements.pop();
        int elem2 = elements.pop();
        char op = operations.pop();
        return operationOnElements(elem1, elem2, op);
    }
}
