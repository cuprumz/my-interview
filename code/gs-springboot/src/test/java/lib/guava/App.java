package lib.guava;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class App {
    
    @Test
    public void gsLists() {
        List<List<String>> ll = Lists.partition(new ArrayList<String>() {{
            add("c");
            add("cb");
            add("cba");
        }},1);
        
        ll.forEach(System.out::println);
        System.out.println("");
        Lists.reverse(ll).forEach(System.out::println);
    }
    
}
