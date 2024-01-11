*** Observable ****

observer design pattern is useful when you are interested in the state of an Object and want to get notified whenever there is any change. In the observer pattern, the Object that watches the state of another Object is called observer, and the Object that is being watched is called subject.

Java provides an built-in platform for implementing the observer pattern through the java.util.Observable class and java.util.Observer interface. 

**** Strategy ****
Strategy pattern is used when we have multiple algorithms for a specific task, and the client decides the actual implementation be used at runtime. A strategy pattern is also known as a policy pattern. We define multiple algorithms and let client applications pass the algorithm to be used as a parameter.

One of the best examples of this pattern is the Collections.sort() method that takes the Comparator parameter. Based on the different implementations of comparator interfaces, the objects are getting sorted in different ways.