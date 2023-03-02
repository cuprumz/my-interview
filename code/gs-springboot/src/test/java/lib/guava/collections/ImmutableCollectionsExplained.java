package lib.guava.collections;


import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

/**
 * 00
 * immutable objects advantages:
 *  1. safe for use by untrusted libraries
 *  2. thread safe
 *  3. no mutation support, more memory-efficient
 *  4. as a constant
 *  
 * JDK provide Collections.unmodifiableXXX
 *  1. unwieldy and verbose
 *  2. unsafe
 *  3. inefficient
 *  
 * reject null values
 * failing fast in nulls
 * 
 * Collection   ImmutableCollection
 * List ImmutableList
 * Set  ImmutableSet
 * SortedSet/NavigableSet   ImmutableSortedSet
 * Map ImmutableMap
 * SortedMap ImmutableSortedMap
 * 
 * Multiset ImmutableMultiset
 * SortedMultiset ImmutableSortedMultiset
 * Multimap ImmutableMultimap
 * ListMultimap ImmutableListMultimap
 * SetMultimap ImmutableSetMultimap
 * BiMap    ImmutableBiMap
 * ClassToInstanceMap   ImmutableClassToInstanceMap
 * Table    ImmutableTable
 */
public class ImmutableCollectionsExplained {

    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red", "green", "blue"
    );
    
    @Test
    public void defensiveCopy() {
        ImmutableSet<String> copy = ImmutableSet.copyOf(COLOR_NAMES);
    }
}
