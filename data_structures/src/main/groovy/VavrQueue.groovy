import io.vavr.Tuple2
import io.vavr.control.Option
import io.vavr.collection.Queue

// = Queue(1)
Queue<Integer> queue = Queue.of(1)
println queue

// = Some((1, Queue()))
Option<Tuple2<Integer, Queue<Integer>>> dequeued = queue.dequeueOption()
println dequeued

// = Some(1)
Option<Integer> element = dequeued.map{ it._1() }
println element

// = Some(Queue())
Option<Queue<Integer>> remaining = dequeued.map{ it._2() }
println remaining

Queue<Integer> queue2 = Queue.of(1, 2, 3)
Queue<Integer> queue3 = queue2.appendAll([4, 5, 6])
println queue3.front.asJava()
println queue3.rear.asJava()
println queue3
Tuple2<Integer, Queue<Integer>> tuple = queue3.dequeue()
Tuple2<Integer, Queue<Integer>> tuple2 = tuple._2().dequeue()
println tuple2._2()
println tuple2._2().front
println tuple2._2().rear
Tuple2<Integer, Queue<Integer>> tuple3 = tuple2._2().dequeue()
println tuple3._2()
println tuple3._2().front
println tuple3._2().rear
