package restart.dsa;

import java.util.Arrays;

public class Heap {
    public int[] minHeap;
    public int last;

    public Heap(int n) {
        this.minHeap = new int[n];
        this.last = -1;
        Arrays.fill(minHeap, -1);
    }

    // time complexity: O(log n)
    public void offer(int num) {
        ++last;
        if (last >= minHeap.length) throw new Error("Heap Full");
        minHeap[last] = num;
        int current = last;
        int parent = (current - 1) / 2;
        while (current > 0 && minHeap[current] < minHeap[parent]) {
            int temp = minHeap[current];
            minHeap[current] = minHeap[parent];
            minHeap[parent] = temp;
            current = parent;
            parent = (parent - 1) / 2;

        }
    }

    public int peek() {
        if (last == -1) throw new Error("Heap is empty");
        return minHeap[0];
    }

    // Time complexity: O(log n)
    public int poll() {
        if (last < 0) return -1;
        int result = minHeap[0];
        minHeap[0] = minHeap[last];
        --last;
        int current = 0;
        while (current <= last) {
            int left = 2 * current + 1, right = 2 * current + 2;
            if (left > last) {
                break;
            }
            int smallest = right <= last && minHeap[right] < minHeap[left] ? right : left;
            if (minHeap[smallest] < minHeap[current]) {
                int temp = minHeap[smallest];
                minHeap[smallest] = minHeap[current];
                minHeap[current] = temp;
                current = smallest;
            } else break;
        }
        return result;
    }

    public void heapSort(int[] array) {

    }
}
