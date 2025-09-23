import java.util.*;
import java.util.stream.*;

public class StreamApiCheatSheet {

    // 1. Stream Creation
    public static void creationExamples() {
        System.out.println("---- Stream Creation ----");
        List<String> list = Arrays.asList("A", "B", "C");
        list.stream().forEach(System.out::println);

        String[] arr = {"X", "Y", "Z"};
        Arrays.stream(arr).forEach(System.out::println);

        Stream.of(1, 2, 3, 4).forEach(System.out::println);

        Stream.iterate(0, n -> n + 1).limit(5).forEach(System.out::println);

        IntStream.range(1, 5).forEach(System.out::println);
    }

    // 2. Intermediate Operations
    public static void intermediateExamples() {
        System.out.println("\n---- Intermediate Ops ----");
        List<Integer> nums = Arrays.asList(5, 2, 2, 7, 1, 9);

        nums.stream().filter(n -> n > 3).forEach(System.out::println);

        nums.stream().distinct().forEach(System.out::println);

        nums.stream().limit(3).forEach(System.out::println);

        nums.stream().skip(2).forEach(System.out::println);

        nums.stream().map(n -> n * n).forEach(System.out::println);

        List<List<String>> nested = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
        nested.stream().flatMap(l -> l.stream()).forEach(System.out::println);

        nums.stream().sorted().forEach(System.out::println);

        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        nums.stream().peek(System.out::println).count();
    }

    // 3. Terminal Operations
    public static void terminalExamples() {
        System.out.println("\n---- Terminal Ops ----");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        words.stream().forEach(System.out::println);

        int sum = Arrays.asList(1, 2, 3, 4, 5).stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        List<String> upper = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Upper: " + upper);

        Object[] arr = words.stream().toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("Any match (starts with a): " + words.stream().anyMatch(w -> w.startsWith("a")));
        System.out.println("All match (len > 3): " + words.stream().allMatch(w -> w.length() > 3));
        System.out.println("None match (xyz): " + words.stream().noneMatch(w -> w.equals("xyz")));

        System.out.println("Find first: " + words.stream().findFirst().get());
        System.out.println("Find any: " + words.stream().findAny().get());

        System.out.println("Count: " + words.stream().count());
    }

    // 4. Primitive Streams
    public static void primitiveExamples() {
        System.out.println("\n---- Primitive Streams ----");
        IntStream.range(1, 6).forEach(System.out::print);
        System.out.println();

        int sum = IntStream.rangeClosed(1, 5).sum();
        System.out.println("Sum: " + sum);

        double avg = IntStream.of(2, 4, 6, 8).average().getAsDouble();
        System.out.println("Avg: " + avg);

        IntStream.range(1, 4).boxed().forEach(System.out::println);
    }

    // 5. Parallel Streams
    public static void parallelExamples() {
        System.out.println("\n---- Parallel Streams ----");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        nums.parallelStream().forEach(n -> {
            System.out.println(Thread.currentThread().getName() + " -> " + n);
        });
    }

    public static void main(String[] args) {
        creationExamples();
        intermediateExamples();
        terminalExamples();
        primitiveExamples();
        parallelExamples();
    }
}
