package lib.guava.basicutilities;

import org.junit.jupiter.api.Test;

import static com.google.common.base.Preconditions.*;

/**
 * 02
 */
public class PreconditionsExplainedApp {

    /**
     * sqrt function may accept only nonnegative arguments
     */
    @Test
    public void example() {
        double value = -1;
        checkArgument(value>=0,"input is negative: " + value);
    }
}
