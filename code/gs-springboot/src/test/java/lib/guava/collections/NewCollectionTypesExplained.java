package lib.guava.collections;


import com.google.common.collect.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 01
 */
public class NewCollectionTypesExplained {

    /**
     * doesn't support collecting a variety useful statistics, like total words
     */
    public void countWord() {
        String[] words = null;
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
    }

    /**
     * implementation:
     * 1.map  2.Corresponding Multiset  3.support null element
     * HashMap  HasMultiset yes
     * TreeMap  TreeMultiset    yes
     * LinkedHashMap    LinkedHashMultiset  yes
     * ConcurrentHashMap    ConcurrentMultiset  no
     * ImmutableMap ImmutableMultiset   no
     */
    @Test
    public void testMultiset() {
        Multiset<String> m = HashMultiset.create();
        for (int i = 0; i < 10; i++) {
            m.add("a" + i);
            m.add("a");
        }

        System.out.println(m.size());
        System.out.println(m.count("a"));
    }


    /**
     *
     */
    @Test
    public void testMultimap() {
        ListMultimap<String, Integer> treeListMultimap =
                MultimapBuilder.treeKeys().arrayListValues().build();

        SetMultimap<String, MyEnum> hashEnumMultimap =
                MultimapBuilder.hashKeys().enumSetValues(MyEnum.class).build();
    }

}

enum MyEnum {

}
