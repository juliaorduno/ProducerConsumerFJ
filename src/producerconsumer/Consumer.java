
package producerconsumer;

/**
 *
 * @author juliaorduno
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    private Buffer buffer;
    private int time;
    private String id;
    
    Consumer(Buffer buffer, int time, String id) {
        this.buffer = buffer;
        this.time = time;
        this.id = id;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer: " + this.id);
        Operation product;
        
        while(true){
            try {
                product = this.buffer.consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}