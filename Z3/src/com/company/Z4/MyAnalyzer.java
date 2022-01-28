package com.company.Z4;

import com.company.Z1.ArrayQueue;
import com.company.Z1.EmptyQueueException;
import com.company.Z1.FullQueueException;
import com.company.Z1.IQueue;
import com.company.Z2.DynamicStack;
import com.company.Z2.EmptyStackException;
import com.company.Z2.FullStackException;
import com.company.Z2.IStack;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class MyAnalyzer {
    private static class Operator {
        final char _ch;

        public Operator(char ch) {
            _ch = ch;
        }

        int getPriority() {
            if (_ch == '*' || _ch == '/') return 2;
            if (_ch == '+' || _ch == '-') return 1;
            return 0;
        }

        @Override
        public String toString() {
            return "" + _ch;
        }
    }

    private static class LeftBracket {
        @Override
        public String toString() {
            return "(";
        }
    }

    // na razie mamy tylko implementacje stosu i kolejki
    // o ograniczonej pojemności
    public final int MAX_NUMBER_OF_TOKENS = 100;

    public IQueue<Object> analize(String inputStr) {

        StreamTokenizer st = new StreamTokenizer(new StringReader(inputStr));
        st.ordinaryChar('/'); // traktuj ‘/’ jako zwykły znak
        st.ordinaryChar('-'); // traktuj ‘-’ jako zwykły znak
        IQueue<Object> queue = new ArrayQueue<>(MAX_NUMBER_OF_TOKENS);
        IStack<Object> stack = new DynamicStack<>(MAX_NUMBER_OF_TOKENS);

        try {
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    queue.enqueue(st.nval);
                }
                else if (st.ttype == '(') stack.push(new LeftBracket());
                else if (st.ttype == ')') {
                    Object elem;
                    do {
                        elem = stack.pop();
                        if (!(elem instanceof MyAnalyzer.LeftBracket)) queue.enqueue(elem);
                    } while (!(elem instanceof MyAnalyzer.LeftBracket));
                }

                else // Operator
                {
                    MyAnalyzer.Operator oper1 = new Operator((char) st.ttype);
                    int priorityOper1 = oper1.getPriority();
                    Object topElem;
                    while (!stack.isEmpty() &&
                            ((topElem = stack.top()) instanceof MyAnalyzer.Operator) &&
                            ((MyAnalyzer.Operator) topElem).getPriority() >= priorityOper1) {
                        queue.enqueue(stack.pop());
                    }
                    stack.push(oper1);
                }
            }
            // na koniec przerzucenie elementów ze stosu na koniec kolejki
            while (!stack.isEmpty()) {
                queue.enqueue(stack.pop());
            }
        } catch (IOException | FullQueueException | EmptyStackException | FullStackException | EmptyQueueException e) {
            e.printStackTrace();
        }
        return queue;
    }

    public String toRPNString(IQueue<Object> queue){
        StringBuilder buffer = new StringBuilder();
        IQueue<Object> copyQueue= new ArrayQueue<>(100);
        try {
            while(!queue.isEmpty()){
                Object elem;
                elem = queue.dequeue();
                buffer.append(elem).append(" ");
                copyQueue.enqueue(elem);
            }
            while(!copyQueue.isEmpty())
                queue.enqueue(copyQueue.dequeue());
        } catch (EmptyQueueException | FullQueueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    public float result(String input) throws EmptyStackException {

        String[] tokens = input.split(" ");
        DynamicStack <Float> dynamicStack = new DynamicStack<>(10);
        float a, b;

        for (String s :
                tokens) {
            switch (s) {
                case "+" -> {
                    a = dynamicStack.pop();
                    b = dynamicStack.pop();
                    dynamicStack.push(b + a);
                }
                case "-" -> {
                    a = dynamicStack.pop();
                    b = dynamicStack.pop();
                    dynamicStack.push(b - a);
                }
                case "*" -> {
                    a = dynamicStack.pop();
                    b = dynamicStack.pop();
                    dynamicStack.push(b * a);
                }
                case "/" -> {
                    a = dynamicStack.pop();
                    b = dynamicStack.pop();
                    dynamicStack.push(b / a);
                }
                default -> dynamicStack.push(Float.parseFloat(s));
            }

        }

        return dynamicStack.pop();
    }

}
