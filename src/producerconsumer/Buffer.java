package producerconsumer;

import java.util.*;

/**
 *
 * @author juliaorduno
 */
public class Buffer {
    
    private Queue<Operation> buffer;
    private int size;
    
    Buffer(int size) {
        this.size = size;
        this.buffer = new LinkedList<>();
    }
    
    public synchronized Operation consume() throws InterruptedException {
        Operation product;
        
        while(this.buffer.isEmpty()){
            wait();
        }
        
        product = this.buffer.remove();
        notifyAll();
        return product;
    }
    
    public synchronized void produce(Operation product) throws InterruptedException {
        while(this.buffer.size() >= this.size){
            wait();
        }
        
        this.buffer.add(product);
        
        notifyAll();
    }

    
}

