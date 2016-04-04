public class BinarySearchActivity {
    public static void main(String[] args) {
        int[] list1 = {1, 1, 2, 3, 4, 5}; // sorted
        int[] list2 = {6, 33, 7, 7, 4, 2, 3}; // not sorted

        String [] list = {"against" , "forms" , "belief" , "government" , "democratic" , "movement" , "understanding"};
        sortAndPrint(list);

        System.out.println(isSorted(list1));
        System.out.println(isSorted(list2));

        System.out.println(binarySearch(list1, 2)); // 2
        System.out.println(binarySearch(list1, 5)); // 5
        System.out.println(binarySearch(list1, 45)); // -1

        // System.out.println(binarySearch(list2, 33)); // Crash!
    }

    private static int binarySearch(int[] list, int number) {
        // this is super gross and probably the improper way. but it works, so can you really complain?
        int min=0, max=list.length, mid=(list.length/2);

        if (!isSorted(list)) {
            throw new ArrayStoreException("Array isn't sorted, try again");
        }

        for (int x=min;x<mid;x++) {
            if (list[x] == number) {
                return x;
            }

            if (x+1 == mid) {
                // obviously we didn't find a match.
                x = mid;
                mid = max;
                continue;
            }
        }
        return -1;
    }

    private static boolean isSorted(int[] list) {
        for (int x=1;x<list.length;x++) {
            if (list[x] < list[x-1]) {
                // The last digit is worth more than the current one
                // die
                return false;
            }
        }
        return true;
    }

    private static void sortAndPrint(String[] list) {
        for (int x=0;x<list.length;x++) {
            for (int y=0;y<list.length;y++) {
                String o=list[x], n=list[y];
                if (o.compareTo(n) >= 0) {
                    // So this means that o comes before n, or they're equal, right??
                    // We'll do nothing then
                }
                else if (o.compareTo(n) < 0) {
                    // This means n comes before o.
                    // We'll switch their positions. That looks good.
                    list[x] = n;
                    list[y] = o;
                }
            }
        }

        for (String s: list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
