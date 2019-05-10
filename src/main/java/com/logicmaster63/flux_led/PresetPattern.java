package com.logicmaster63.flux_led;

public enum PresetPattern {
    SEVEN_COLOR_CROSS_FADE   (0X25),
    RED_GRADUAL_CHANGE       (0X26),
    GREEN_GRADUAL_CHANGE     (0X27),
    BLUE_GRADUAL_CHANGE      (0X28),
    YELLOW_GRADUAL_CHANGE    (0X29),
    CYAN_GRADUAL_CHANGE      (0X2A),
    PURPLE_GRADUAL_CHANGE    (0X2B),
    WHITE_GRADUAL_CHANGE     (0X2C),
    RED_GREEN_CROSS_FADE     (0X2D),
    RED_BLUE_CROSS_FADE      (0X2E),
    GREEN_BLUE_CROSS_FADE    (0X2F),
    SEVEN_COLOR_STROBE_FLASH (0X30),
    RED_STROBE_FLASH         (0X31),
    GREEN_STROBE_FLASH       (0X32),
    BLUE_STROBE_FLASH        (0X33),
    YELLOW_STROBE_FLASH      (0X34),
    CYAN_STROBE_FLASH        (0X35),
    PURPLE_STROBE_FLASH      (0X36),
    WHITE_STROBE_FLASH       (0X37),
    SEVEN_COLOR_JUMPING      (0X38);

    private final int value;

    PresetPattern(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name().toLowerCase().replace('_', ' ');
    }

    public static boolean isValid(int value) {
        return value > 0x25 && value < 0x38;
    }
}
