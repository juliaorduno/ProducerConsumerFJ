/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author juliaorduno
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    private final Buffer buffer;
    private final Random random;
    private final int min;
    private final int max;
    private final long time;
    private final String id;
    private final GUI frame;
    
    public Producer(Buffer buffer, String id, int min, int max, long time, GUI frame) {
        this.buffer = buffer;
        this.random = new Random();
        this.id = id;
        this.min = min;
        this.max = max;
        this.time = time;
        this.frame = frame;
    }
    
    private int randomGenerator(){
        return this.random.nextInt(this.max) + this.min + 1;
    }
    
    private Operation setRandomOperation(){
        String symbols = "+-*/";
        char symbol = symbols.charAt(this.random.nextInt(4));
        int value1, value2;
        value1 = this.randomGenerator();
        value2 = this.randomGenerator();
        
        return new Operation(value1, value2, symbol);
    }
    
    @Override
    public void run() {
        while(true){
            Operation product = setRandomOperation();
            try {
                this.buffer.produce(product);
                String task = this.id + " produced " + product.operationString();
                this.frame.addTodo(task);
                Thread.sleep(this.time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
