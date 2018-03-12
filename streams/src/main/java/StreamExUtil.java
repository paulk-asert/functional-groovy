import one.util.streamex.StreamEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamExUtil {
    private static <T> StreamEx<List<T>> batches(StreamEx<T> input, int size, List<T> cur) {
        return input.headTail((head, tail) -> cur.size() >= size
                        ? batches(tail, size, Arrays.asList(head)).prepend(cur)
                        : batches(tail, size, StreamEx.of(cur).append(head).toList()),
                () -> Stream.of(cur));
    }

    public static <T> Function<StreamEx<T>, StreamEx<List<T>>> batches(int size) {
        return s -> batches(s, size, Collections.emptyList());
    }

    private static <T> StreamEx<List<T>> sliding(StreamEx<List<T>> input, int size) {
        return input.headTail((head, tail) -> head.size() == size ? sliding(
                tail.mapFirst(next -> StreamEx.of(head.subList(1, size), next).toFlatList(l -> l)), size).prepend(head)
                : sliding(tail.mapFirst(next -> StreamEx.of(head, next).toFlatList(l -> l)), size));
    }

    public static <T> Function<StreamEx<T>, StreamEx<List<T>>> sliding(int size) {
        return s -> sliding(s.map(Collections::singletonList), size);
    }
}
