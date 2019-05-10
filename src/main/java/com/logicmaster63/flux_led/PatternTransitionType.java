package com.logicmaster63.flux_led;

public enum PatternTransitionType {
    GRADUAL,
    JUMP,
    STROBE;

    String getValue() {
        return name().toLowerCase();
    }
}
