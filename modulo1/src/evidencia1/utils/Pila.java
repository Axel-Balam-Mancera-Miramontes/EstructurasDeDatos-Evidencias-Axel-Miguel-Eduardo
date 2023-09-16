package evidencia1.utils;

import java.util.Optional;

public class Pila <E>{
    private ListaEnlazada<E> stack;

    public Pila(){
        stack = new ListaEnlazada<>();
    }

    public void push(E elmtToPush){
        stack.addFirst(elmtToPush);
    }

    public Optional<E> peek(){
        return stack.get(stack.getSize() - 1);
    }

    public Optional<E> pop(){
        Optional<E> popped = stack.get(0);
        stack.remove(popped.get());
        return popped;
    }

    public int getSize() {
        return stack.getSize();
    }

    public boolean isEmpty(){
        return !(stack.getSize() > 0);
    }

    public Pila<E> inverse() {
        Pila<E> inversed = new Pila<>();

        for(int i = stack.getSize() - 1; i >= 0; --i){
            inversed.push(stack.get(i).get());
        }

        return inversed;
    }

    public Pila<E> alternate(Pila<E> stackB){
        Pila<E> stackB2 = stackB.inverse();
        Pila<E> alternated = new Pila<>();


        /*
        while(stack.getSize() > 0 || stackB2.getSize() > 0){
            try{

            }
            catch{

            }
        }
        */

        return alternated;
    }
}
