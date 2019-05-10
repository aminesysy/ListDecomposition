import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        int start=0,n = 2;
        int end = n;

        ArrayList lint = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)) ;
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while(end <= lint.size()) {
            list.add(new ArrayList<Integer>(lint.subList(start, end)));
            start +=n;
            end+=n;
        }
        if (end > lint.size() && start < lint.size()) {
            list.add(new ArrayList<Integer>(lint.subList(start, lint.size())));
        }

        System.out.println(list);
    }
}
