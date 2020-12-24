import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {

    public static void main(String[] args) {
        int a[] = {1, 3, 2, 5};
        int b[] = {2, 3, 4};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.equals(a, b));

        Arrays.fill(a, 10);
        System.out.println(Arrays.toString(a));
        Arrays.sort(b);
        Integer[] c = {1, 3, 5, 2};

        int dex = Arrays.binarySearch(b, 3);
        System.out.println(dex);
       
        Arrays.sort(c, new LengthComparator());
        System.out.println(Arrays.toString(c));

    }
}

class LengthComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }


}
