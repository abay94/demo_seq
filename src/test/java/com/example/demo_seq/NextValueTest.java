package com.example.demo_seq;

import com.example.demo_seq.model.sequence.ISequenceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextValueTest {

    @Test
    public void testNextString() {
        assertEquals("a0a1", ISequenceService.getNextValue("a0a0"));
        assertEquals("a1a0", ISequenceService.getNextValue("a0z9"));
        assertEquals("b9a0", ISequenceService.getNextValue("b8z9"));
        assertEquals("a0a0a0", ISequenceService.getNextValue("z9z9"));
        assertEquals("a0a0a0a0", ISequenceService.getNextValue("z9z9z9"));
    }
}

