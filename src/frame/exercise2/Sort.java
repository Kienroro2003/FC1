package frame.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    private List<Integer> sort = new ArrayList<>();

    public void setItemSort(String strNumber){
        String[] strings = strNumber.split(",");
        for (String s :
                strings) {
            sort.add(Integer.parseInt(s));
        }
    }

    public List<Integer> sort(){
        Collections.sort(this.sort);
        return this.sort;
    }
}
