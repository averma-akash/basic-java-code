/*
What is BlockingQueue? How to implement producer-consumer problem by using BlockingQueue?

BlockingQueue is an interface that has been included along with a number of other concurrent Utility classes such as ConcurrentHashMap, Counting Semaphore, CopyOnWriteArrayList, and so on. When a thread try to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. Also, when a thread try to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.

Producter-Consumer Problem

Producer and Consumer are two separate threads which share a same bounded Queue. The role of producer to produce elements and push to the queue. The producer halts producing if the queue is full and resumes producing when the size of queue is not full. The consumer consumes the element from the queue. The consumers halt consuming if the size of queue is 0 (empty) and resumes consuming once the queue has an element.

The problem can be approached using various techniques

Using wait() and notifyAll()
Using BlockingQueue
Using sempahores
*/

public class ProducerConsumerBlockingQueue {

  static int MAX_SIZE = 5;
  static BlockingQueue queue = new LinkedBlockingQueue(MAX_SIZE);

  public static void main(String[] args) {

    Producer producer = new Producer();
    Consumer consumer = new Consumer();
    producer.start();
    consumer.start();
  }

  static class Producer extends Thread {
    Random random = new Random();

    public void run() {
      while (true) {
        int element = random.nextInt(MAX_SIZE);
        try {
          queue.put(element);
        } catch (InterruptedException e) {
        }
      }
    }
  }

  static class Consumer extends Thread {
    public void run() {
      while (true) {
        try {
          System.out.println("Consumed " + queue.take());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
/*
Output

Producer 2
Producer 3
Consumed 2
Consumed 3
Producer 0
Producer 4
Consumed 0
Here, The Producer start producing objects and pushing it to the Queue. Once the queue is full, the producer will wait until consumer consumes it and it will start producing again. Similar behavior is displayed by consumer. where the consumer waits until there is a single element in queue. It will resume consumer once the queue has element.
*/