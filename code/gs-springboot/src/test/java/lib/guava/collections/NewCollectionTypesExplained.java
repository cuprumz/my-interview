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

    /**
     * key -> value
     * value -> key
     * 
     */
    @Test
    public void testBiMap() {
        BiMap<String, Integer> userId = HashBiMap.create();

        userId.put("admin", 15);
//        userId.put("root", 15); // value already present: 15
        userId.forcePut("root", 15);
        userId.put("admin", 16);

        String userForId = userId.inverse().get(15);
        System.out.println(userForId);
    }

    /**
     * trying to index on more than one key at time
     */
    @Test
    public void testTable() {
        Table<String, String, Integer> weightedGraph = HashBasedTable.create();
        weightedGraph.put("row1", "col1", 11);
        weightedGraph.put("row1", "col1", 11);
        weightedGraph.put("row1", "col2", 12);
        weightedGraph.put("row2", "col1", 21);

        System.out.println(weightedGraph.row("row1"));
        System.out.println(weightedGraph.column("col1"));
    }

    /**
     * keys are types
     * 
     * ClassToInstanceMap<B>
     * a map from subclasses of B to instances of B
     */
    @Test
    public void testClassToInstanceMap() {
        ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();

        numberDefaults.putInstance(Integer.class, 10);
    }

    @Test
    public void testRangeSet() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}
    }
    
    @Test
    public void testRangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}
    }
}

enum MyEnum {

}
