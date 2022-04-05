/*
Fork is a process in which a task splits itself into smaller and independent sub-tasks which can be executed concurrently.

Join is a process in which a task join all the results of sub-tasks once the subtasks have finished executing, otherwise it keeps waiting.

ForkJoinPool
it is a special thread pool designed to work with fork-and-join task splitting.

RecursiveAction represents a task which does not return any value.

RecursiveTask represents a task which returns a value. */

public class ForkJoinRecursiveTask {

    public static void main(String[] args) {

        System.out.println(ForkJoinAdd.startForkJoinSum(1_000_000));
		
    }

}

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinAdd extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long threshold = 10_000;

    public ForkJoinAdd(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinAdd(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
	
	public static long startForkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinAdd(numbers);
        return new ForkJoinPool().invoke(task);
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if (length <= threshold) {
            return add();
        }

        ForkJoinAdd firstTask = new ForkJoinAdd(numbers, start, start + length / 2);
        firstTask.fork(); //start asynchronously

        ForkJoinAdd secondTask = new ForkJoinAdd(numbers, start + length / 2, end);

        Long secondTaskResult = secondTask.compute();
        Long firstTaskResult = firstTask.join();

        return firstTaskResult + secondTaskResult;

    }

    private long add() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }
}