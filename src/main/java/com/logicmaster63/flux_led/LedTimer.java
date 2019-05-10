package com.logicmaster63.flux_led;

public interface LedTimer {
    void setActive(boolean active);
    void setActive();
    boolean isActive();
    boolean isExpired();
    void setTime(int hour, int minute);
    void setDate(int year, int month, int day);
    void setRepeatMask(int repeat_mask);
    void setModeDefault();
    void setModePresetPattern(int pattern, int speed);
    void setModeColor(byte r, byte g, byte b);
    void setModeWarmWhite(int level);
    void setModeSunrise(int startBrightness, int endBrightness, int duration);
    void setModeSunset(int startBrightness, int endBrightness, int duration);
    void setModeTurnOff();;
    void fromBytes(byte[] bytes);
    byte[] toBytes();
}
