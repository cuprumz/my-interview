package lib.guava.basicutilities;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Test;

/**
 * 05
 * fluent Comparator
 */
public class CommonObjectUtilitiesExplainedApp {
    
    @Test
    public void testNullEqNull() {

        System.out.println(null == null);
    }
    
    
}

class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int zipCode;
    
    @Override
    public int compareTo(Person o) {
        int cmp = lastName.compareTo(o.lastName);
        if(cmp != 0) return cmp;
        cmp = firstName.compareTo(o.firstName);
        if (cmp != 0) return cmp;
        
        return Integer.compare(zipCode, o.zipCode);
    }
    
    public int compareToWithGWT(Person o) {
        return ComparisonChain.start()
                .compare(this.lastName, o.lastName)
                .compare(this.firstName, o.firstName)
                .compare(this.zipCode, o.zipCode, Ordering.natural().nullsFirst())
                .result();
    }
}
