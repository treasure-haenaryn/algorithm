- 임의의 위치에 있는 원소를 확인 및 변경 = O(1)
- 원소를 끝에 추가 = O(1)
- 마지막 원소를 제거 = O(1)
- 임의의 위치에 원소를 추가/제거 = O(N)
# Java 알고리즘 - 배열 관련 함수 정리

---

## 일반 배열 (`int[]`)

```java
int[] arr = new int[5];          // 선언
int[] arr = {1, 2, 3, 4, 5};    // 선언 + 초기화
arr.length                        // 배열 크기

Arrays.sort(arr);                 // 오름차순 정렬
Arrays.sort(arr, 0, 3);          // 부분 정렬 (0~2 인덱스)
Arrays.fill(arr, 0);             // 전체 0으로 초기화
Arrays.copyOf(arr, 10);          // 크기 10으로 복사
Arrays.toString(arr);            // 출력용 문자열로 변환 "[1, 2, 3]"
Arrays.binarySearch(arr, 3);     // 이진탐색 (정렬된 상태에서만)
```

---

## ArrayList

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);                     // 끝에 추가
list.add(1, 50);                  // 인덱스 1에 삽입
list.get(0);                      // 인덱스 접근
list.set(0, 99);                  // 값 변경
list.remove(0);                   // 인덱스로 삭제
list.remove(Integer.valueOf(10)); // 값으로 삭제
list.size();                      // 크기
list.contains(10);                // 포함 여부
list.indexOf(10);                 // 값의 인덱스
list.clear();                     // 전체 삭제
Collections.sort(list);           // 정렬
Collections.reverse(list);        // 역순
```

---

## 배열 ↔ ArrayList 변환

```java
// 배열 → ArrayList
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

// ArrayList → 배열
int[] arr = list.stream().mapToInt(i -> i).toArray();
```

---

## 언제 뭘 쓸까?

| 상황 | 추천 |
|------|------|
| 크기 고정, 빠른 접근 | `int[]` |
| 삽입/삭제 자주 발생 | `ArrayList` |
| 문제에서 배열 명시 | `int[]` |

> 알고리즘 테스트에서는 보통 `ArrayList`가 편한 경우가 많아요. 특별한 이유 없으면 ArrayList 추천!

---

## 시간복잡도 정리

### 정렬 / 역순

| 메서드 | 시간복잡도 | 설명 |
|--------|-----------|------|
| `Arrays.sort(arr)` | O(n log n) | Dual-Pivot QuickSort |
| `Collections.sort(list)` | O(n log n) | TimSort (병합+삽입 혼합) |
| `Collections.reverse(list)` | O(n) | 앞뒤 swap만 하면 되니까 |

### 주요 메서드

| 메서드 | 시간복잡도 |
|--------|-----------|
| `list.add()` (끝에 추가) | O(1) |
| `list.add(idx, val)` (중간 삽입) | O(n) |
| `list.remove(idx)` | O(n) |
| `list.get(idx)` | O(1) |
| `list.contains(val)` | O(n) |
| `Arrays.binarySearch()` | O(log n) |

> 중간 삽입/삭제가 O(n)인 이유는 뒤의 원소들을 전부 한 칸씩 밀거나 당겨야 하기 때문이에요.
> 삽입/삭제가 많다면 LinkedList가 O(1)이라 유리하지만, 인덱스 접근이 O(n)이 되는 트레이드오프가 있어요.