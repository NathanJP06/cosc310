After running "BenchmarkDriver", here are the results printed in the terminal: 

### RESULTS
```
Java ADT Benchmark (nanoTime).
Warmup ops: 15000, Measure ops: 60000, Trials: 7

Sanity checks: OK

== Stack: ArrayListStack ==
  Workload1 bulk push+pop                 median:       6.37 ns/op   checksum: 449985000
  Workload2 mixed steady-state            median:      23.31 ns/op   checksum: -1055495428

== Stack: DLinkedListStack ==
  Workload1 bulk push+pop                 median:      13.75 ns/op   checksum: 449985000
  Workload2 mixed steady-state            median:      25.55 ns/op   checksum: -1055495428

== Queue: ArrayListQueue ==
  Workload1 bulk enq+deq                  median:      11.12 ns/op   checksum: 449985000
  Workload2 mixed steady-state            median:      24.55 ns/op   checksum: 8738648310

== Queue: DLinkedListQueue ==
  Workload1 bulk enq+deq                  median:      10.78 ns/op   checksum: 449985000
  Workload2 mixed steady-state            median:      85.02 ns/op   checksum: 8738648310


== PriorityQueue: SortedArrayListPQ ==
  Workload1 bulk enq+deq (uniform priorities)  median:   20075.10 ns/op   checksum: 449985000
  Workload2 mixed steady-state (uniform priorities)  median:   31470.46 ns/op   checksum: -101944034770
  Workload3 skewed priorities (bulk)      median:   20652.24 ns/op   checksum: 449985000

== PriorityQueue: SortedDLinkedListPQ ==
  Workload1 bulk enq+deq (uniform priorities)  median:   20602.81 ns/op   checksum: 449985000
  Workload2 mixed steady-state (uniform priorities)  median:   19786.65 ns/op   checksum: -101944034770
  Workload3 skewed priorities (bulk)      median:   18029.38 ns/op   checksum: 449985000

== PriorityQueue: BinaryHeapPQ ==
  Workload1 bulk enq+deq (uniform priorities)  median:      71.83 ns/op   checksum: 449985000
  Workload2 mixed steady-state (uniform priorities)  median:      56.14 ns/op   checksum: -106337492798
  Workload3 skewed priorities (bulk)      median:      50.88 ns/op   checksum: 449985000 
  ```


- **Stacks**: The ArrayListStack is much faster than the DLinkedList, running at 6.37ns/op for push/pop operatons comparted to the nearly 2x slower, 13.75ns/op. This is because the ArrayList does not have to deal with the fragmentations and nodes of a DLinkedList. The ArrayList is able to use less memory since it does not have multiple nodes to store information in, rather it can just store it in the cache.

- **Queues**: ArrayListQueue doing a mix of operations runs significantly faster (4x faster) than the DLinkedListQueue, at 24.55ns/op, compared to 85.02ns/op. This is because of the "Circular Buffer" of the ArrayList, which reuses array space without shifting elements, meaning hardware is used less frequently, which improves cache performance. 

- **Priority Queues**: The BinaryHeapPQ is way faster than the other two operations at 71.83ns/op compared to the sorted lists at over 20,000ns/op. The reason: the heaps do not search through the entire list, rather they search more efficently, like a tree, and are able to return faster. The sortedlists need to check through each element, significantly slowing their processing time down.