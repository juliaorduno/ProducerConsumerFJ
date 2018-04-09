
package producerconsumer;

/**
 *
 * @author juliaorduno
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    private final Buffer buffer;
    private final long time;
    private final String id;
    private final GUI frame;
    
    Consumer(Buffer buffer, long time, String id, GUI frame) {
        this.buffer = buffer;
        this.time = time;
        this.id = id;
        this.frame = frame;
    }
    
    @Override
    public void run() {
        Operation product;
        
        while(true){
            try {
                product = this.buffer.consume();
                double result = product.getResult();
                String task = this.id + " consumed " + product.operationString() + " = " + result;
                this.frame.addDone(task);
                Thread.sleep(this.time);
                this.frame.removeTodo();
                this.frame.increaseTotalDone();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}