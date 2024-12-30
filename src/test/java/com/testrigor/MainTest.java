package com.testrigor;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void testFindCriminal() {
        Map<String, String> criminals = new HashMap<>();
        criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
        criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
        criminals.put("Paul White Jr.", null);
        criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
        criminals.put("Redford Fort", "Red Strong, Red Fort");

        // Test cases
        assertEquals("First name: Paul White. Aliases: Roger Night, Peter Llong Jr.", 
                     Main.findCriminal(criminals, "paul White"), "Case: Exact match for 'Paul White'");

        assertEquals("First name: Roger Fedexer. Aliases: Rob Ford, Pete Lord, Roger McWire", 
                     Main.findCriminal(criminals, "Roger"), "Case: Exact match for 'Roger' as actual name");

        assertEquals("First name: Red Fortress. Aliases: Roger Rabbit, Ross Winter", 
                     Main.findCriminal(criminals, "Ross"), "Case: Match for alias 'Ross'");

        assertEquals("First name: Paul White Jr.. Aliases: None", 
                     Main.findCriminal(criminals, "white jr."), "Case: Partial match for 'white jr.'");
    }
}
