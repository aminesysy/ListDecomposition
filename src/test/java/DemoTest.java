import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class DemoTest {
    private Demo demo;
    private String[] args;

    @Before
    public void setUp(){
        demo = new Demo(new Integer(2),
                        new ArrayList<Integer>());
        args = new String[1];
    }

    @Test(expected = WrongParmsException.class)
    public void shouldThrowWrongParmsExceptionWhenArgsNotDefined() {
        Demo.validerArgs(args);
    }
    @Test(expected = WrongParmsException.class)
    public void shouldThrowWrongParmsExceptionWhenArgsNotCorrect() {
        args[0] = "2";
        Demo.validerArgs(args);
    }

    @Test
    public void shouldReturnTrue() {
        args = new String[] { "2", "1", "2", "3", "4","5" };
        if (demo.validerArgs(args)) {
            demo.init(args);
        }

        List<ArrayList<Integer>> partList = new ArrayList<ArrayList<Integer>>();
        partList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        partList.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        partList.add(new ArrayList<Integer>(Arrays.asList(5)));
        assertEquals(partList, demo.partitionner());
    }
    @Test

    public void shouldReturnFalse() {
        args = new String[] { "2", "1", "2", "3", "4","5","6" };
        if (demo.validerArgs(args)) {
            demo.init(args);
        }

        List<ArrayList<Integer>> partList = new ArrayList<ArrayList<Integer>>();
        partList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        partList.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        partList.add(new ArrayList<Integer>(Arrays.asList(5)));
        partList.add(new ArrayList<Integer>(Arrays.asList(6)));
        assertNotEquals(partList,demo.partitionner());
    }

}
