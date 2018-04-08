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
public class ProducerConsumer {
    
    
    
    private static int bufferSize, numConsumers, numProducers, timeProducer, timeConsumer, min, max;
     public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setVisible(true);
        
        javax.swing.JButton btnStart = frame.getStartButton();
        
        btnStart.addActionListener((java.awt.event.ActionEvent evt) -> {
            start(frame);
        });
    }
     
    public static void start(GUI frame){
        int minRange = frame.getMinRange();
        int maxRange = frame.getMaxRange();
        int bufferSize = frame.getBufferSize();
        int consumers = frame.getConsumers();
        int producers = frame.getProducers();
        long producerTime = frame.getProducerTime();
        long consumerTime = frame.getConsumerTime();
        
        
        Buffer buffer = new Buffer(bufferSize);
        
        for(int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(buffer, "P"+i, min, max, timeProducer);
            producer.start();
        }
        
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer(buffer, timeConsumer, "C"+i);
            consumer.start();
        }
    }

   
    
}