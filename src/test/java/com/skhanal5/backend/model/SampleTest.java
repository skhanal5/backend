package com.skhanal5.backend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    public void constructSample() {
        var sample = new Sample("","");
        Assertions.assertNotNull(sample);
        Assertions.assertEquals("", sample.id);
        Assertions.assertEquals("", sample.name);
    }

}
