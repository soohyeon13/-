package 알고리즘코드;

public class 힙정렬 {
    public int heap_sort() {

        int answer = 0;
        int[] arr_heap = new int[100];
        heapsort(arr_heap);

        return answer;
    }

    private void heapsort(int[] arr_heap) {
        int len = arr_heap.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr_heap, len, i);
        }

        for (int i = len-1; i >0; i--) {
            swap(arr_heap,0,i);
            heapify(arr_heap,i,0);
        }
    }

    private void heapify(int[] arr_heap, int len, int i) {
        int parent = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < len && arr_heap[parent] < arr_heap[left]) {
            parent = left;
        }

        if (right < len && arr_heap[parent] < arr_heap[right]) {
            parent = right;
        }

        if (i !=len) {
            swap(arr_heap,parent,i);
            heapify(arr_heap,len,parent);
        }
    }

    private void swap(int[] arr_heap, int parent, int i) {
        int temp = arr_heap[i];
        arr_heap[i] = arr_heap[parent];
        arr_heap[parent] = temp;
    }
}
