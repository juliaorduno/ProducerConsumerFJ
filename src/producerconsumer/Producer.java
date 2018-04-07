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
    private Buffer buffer;
    private Random random;
    private int min, max, time;
    private String id;
    
    public Producer(Buffer buffer, String id, int min, int max, int time) {
        this.buffer = buffer;
        this.random = new Random();
        this.id = id;
        this.min = min;
        this.max = max;
        this.time = time;
    }
    
    private int randomGenerator(){
        //CHECK CALCULATION PLZ
        return this.random.nextInt(this.max) + this.min;
    }
    
    private Operation setRandomOperation(){
        String symbols = "+-*/";
        char symbol = symbols.charAt(this.random.nextInt(4));
        int value1, value2;
        // HARDCODED
        value1 = this.randomGenerator();
        value2 = this.randomGenerator();
        
        return new Operation(value1, value2, symbol);
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer: " + this.id);
        
        Operation product = setRandomOperation();
        try {
            this.buffer.produce(product);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
