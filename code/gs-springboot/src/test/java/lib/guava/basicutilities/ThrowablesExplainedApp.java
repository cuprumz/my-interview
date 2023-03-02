package lib.guava.basicutilities;

import com.google.common.base.Throwables;
import org.junit.jupiter.api.Test;

/**
 * 06
 * propagation
 */
public class ThrowablesExplainedApp {
    
    @Test
    public void gs() {
        Throwables.throwIfInstanceOf(new RuntimeException(), RuntimeException.class);
    }
}
