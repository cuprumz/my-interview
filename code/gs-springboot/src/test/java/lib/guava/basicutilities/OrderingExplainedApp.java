package lib.guava.basicutilities;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

/**
 * 04
 */
public class OrderingExplainedApp {
    
    @Test
    public void gs() {
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        

    }
}
