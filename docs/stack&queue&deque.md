### Stack

스택의 성질(FILO)
1. 원소의 추가 O(1)
2. 원소의 제거 O(1)
3. 제일 상단 원소 확인 O(1)
4. 그외 원소 확인/변경은 원칙적으로 불가능


stack.pop() 호출시 빈 스택이라면 NoSuchElementException 예외
stack.peek() 호출시 빈 스택이면 null 반환

### Queue

큐의 성질(FIFO)

// 스택으로 사용 (LIFO) - 앞에서 넣고 앞에서 뺌
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);   // 앞에 삽입
stack.pop();     // 앞에서 삭제

// 큐로 사용 (FIFO) - 뒤에 넣고 앞에서 뺌
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(1);  // 뒤에 삽입
queue.poll();    // 앞에서 삭제


### Deque
덱은 스택 + 큐를 합친 자료구조이다.

덱의 성질
1. 원소의 추가 O(1)
2. 원소의 제거 O(1)
3. 제일 앞/뒤 원소 확인 O(1)

스택 (LIFO)
앞 ← push/pop
[ 3, 2, 1 ]

큐 (FIFO)
앞 → pop       push → 뒤
[ 1, 2, 3 ]

덱 (양방향)
앞 ← push/pop  push/pop → 뒤
[ 1, 2, 3 ]

덱의 특징

- 앞에서도 삽입/삭제 가능
- 뒤에서도 삽입/삭제 가능
- 스택처럼도, 큐처럼도 사용 가능

  ---
Java에서 덱 메서드

┌──────┬────────────┬─────────────┬─────────────┐
│ 위치 │    삽입    │    삭제     │    조회     │
├──────┼────────────┼─────────────┼─────────────┤
│ 앞   │ addFirst() │ pollFirst() │ peekFirst() │
├──────┼────────────┼─────────────┼─────────────┤
│ 뒤   │ addLast()  │ pollLast()  │ peekLast()  │
└──────┴────────────┴─────────────┴─────────────┘
