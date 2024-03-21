import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class Main {

    static private int[] a;
    static int startIndex;
    static int[] tree;

    static private ElementInfo[] elementInfos;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a = new int[n];
        elementInfos = new ElementInfo[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            elementInfos[i] = new ElementInfo(a[i], i);
        }
        Arrays.sort(elementInfos);

        for (startIndex = 1; startIndex < n; startIndex *= 2) ;
        tree = new int[startIndex * 2 - 1 + 1];

        for (int i = 0; i < n; i++) {
            int index = elementInfos[i].index;
            updateTree(startIndex + index, findMaxLISLength(0, index, 1, 0, startIndex - 1) + 1);
        }

        System.out.print(tree[1]);
    }

    static void updateTree(int index, int value) {
        while (index != 0) {
            tree[index] = value;

            int parentIndex = index / 2;
            if (tree[parentIndex] < value) index = parentIndex;
            else index = 0;
        }
    }

    static int findMaxLISLength(int l, int r, int nodeIndex, int nodeL, int nodeR) {
        if ((l > nodeR) || (r < nodeL)) return 0;
        else if ((l <= nodeL) && (r >= nodeR)) return tree[nodeIndex];

        int mid = (nodeL + nodeR) / 2;
        int leftChildValue = findMaxLISLength(l, r, nodeIndex * 2, nodeL, mid);
        int rightChildValue = findMaxLISLength(l, r, nodeIndex * 2 + 1, mid + 1, nodeR);
        return leftChildValue > rightChildValue ? leftChildValue : rightChildValue;
    }
}

class ElementInfo implements Comparable<ElementInfo> {
    public int value;
    public int index;

    public ElementInfo(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(ElementInfo o) {
        if (this.value != o.value) return this.value - o.value;
        else return o.index - this.index;
    }
}