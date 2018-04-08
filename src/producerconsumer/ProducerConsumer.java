/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.awt.event.ActionEvent;

/**
 *
 * @author juliaorduno
 */
public class ProducerConsumer {
    
    private static int bufferSize, numConsumers, numProducers, timeProducer, timeConsumer, min, max;
    private static GUI frame;
    private static Buffer buffer;
    
    public static void start(){
        bufferSize = 1;
        numProducers = 5;
        numConsumers = 5;
        min = 5;
        max = 50;
        timeProducer = 1000;
        timeConsumer = 1000;
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
        
        frame.getStartButton().addActionListener((ActionEvent e) -> {
            start();
        });
    }
    
}