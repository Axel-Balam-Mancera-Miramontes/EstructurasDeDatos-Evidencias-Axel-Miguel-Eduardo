package evidencia1.utils;

import java.util.Optional;

public class Cola <E>{
    private ListaEnlazada<E> queue;

    public Cola(){
        queue = new ListaEnlazada<>();
    }

    public void push(E elmtToPush){
        queue.add(elmtToPush);
    }

    public Optional<E> pop(){
        Optional<E> popped = queue.get(0);
        queue.remove(popped.get());
        return popped;
    }

    public Optional<E> peek(){
        return queue.get(0);
    }

    public int size() {
        return queue.getSize();
    }

    public boolean isEmpty(){
        return !(queue.getSize() > 0);
    }

    public Cola<E> inverse(){
        if(!this.isEmpty()) {
            Cola<E> inversedQueue = this;
            Pila<E> auxStack = new Pila<>();
            int i;

            while (!inversedQueue.isEmpty()) {
                auxStack.push(inversedQueue.pop().get());
            }

            while (!auxStack.isEmpty()) {
                inversedQueue.push(auxStack.pop().get());
            }

            return inversedQueue;
        }

        return this;
    }

}
