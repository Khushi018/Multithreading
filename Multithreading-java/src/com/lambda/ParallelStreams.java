package com.lambda;



import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

//    parallel using multiple threads from the ForkJoinPool. This can improve performance
//    for large datasets on multi-core CPUs.
//    The collection is split into chunks (tasks).
//    Tasks are submitted to ForkJoinPool threads.
//    Each thread processes its chunk in parallel.
//    Partial results are combined.

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.parallelStream()  // parallel processing
                .mapToInt(n -> n * 2)
                .sum();
        System.out.println(sum);
    }
}
