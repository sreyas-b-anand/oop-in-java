public class QuickSort {

    int partition(String[] ar, int left, int right) {
        int i = left, j = right;
        int pivot = left;
        while (i <= j) {
            while ((ar[i].compareTo(ar[pivot]) <= 0) && (i <= j )) {
                i++;
            }
            while ((ar[j].compareTo(ar[pivot]) >= 0) && (j >= i)) {
                j--;
            }
            if (i < j) {
                String temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        String temp = ar[j];
        ar[j] = ar[pivot];
        ar[pivot] = temp;
        return j;
    }

    void Quicksort(String[] ar, int left, int right) {
        if (left < right) {
            int j = partition(ar, left, right);
            Quicksort(ar, left, j - 1);
            Quicksort(ar, j + 1, right);
        }
    }

    public static void main(String args[]) {
        String a[] = { "Joshua" , "Sreyas" , "Elvin" , "Antony" , "Abhay"};
        int left = 0;
        int right = 4;
        QuickSort cl1 = new QuickSort();
        cl1.Quicksort(a, left, right);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
