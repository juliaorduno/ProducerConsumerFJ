/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author juliaorduno
 */
public class ProducerConsumer {
    
    private static int bufferSize, numConsumers, numProducers, min, max;
    private static long timeProducer, timeConsumer;
    private static GUI frame;
    private static Buffer buffer;
     
    public static void start(){
        min = frame.getMinRange();
        max = frame.getMaxRange();
        bufferSize = frame.getBufferSize();
        numConsumers = frame.getConsumers();
        numProducers = frame.getProducers();
        timeProducer = frame.getProducerTime();
        timeConsumer = frame.getConsumerTime();
        
        buffer = new Buffer(bufferSize);

        for(int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(buffer, "P"+i, min, max, timeProducer, frame);
            producer.start();
        }
        
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer(buffer, timeConsumer, "C"+i, frame);
            consumer.start();
        }
    }

    public static void main(String[] args) {
        frame = new GUI();
        frame.setVisible(true);
        
        JButton startButton = frame.getStartButton();
        
        startButton.addActionListener((ActionEvent e) -> {
            start();
            startButton.setEnabled(false);
        });
    }
    
}