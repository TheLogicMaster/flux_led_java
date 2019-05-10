package com.logicmaster63.flux_led_java.flux_led;

public enum PatternTransitionType {
    GRADUAL,
    JUMP,
    STROBE;

    String getValue() {
        return name().toLowerCase();
    }
}
