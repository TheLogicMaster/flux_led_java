package com.logicmaster63.flux_led_java.flux_led;

import org.python.core.PyByteArray;
import org.python.core.PyTuple;

/**
 * A wrapper for the flux led wifi bulb class
 */
public interface WifiLedBulb {
    /**
     * Connect to bulb
     * @param retry attempts
     */
    void connect(int retry);

    /**
     * Connect to bulb
     */
    void connect();

    /**
     * Close the connection
     */
    void close();

    /**
     * Query the state of the bulb
     * @param retry attempts
     * @param led_type: LEDENET or LEDENET_ORIGINAL
     * @return queried bytes
     */
    PyByteArray queryState(int retry, String led_type);

    /**
     * Query the state of the bulb
     * @return queried bytes
     */
    PyByteArray queryState();

    /**
     * Update local state from queried data
     * @param retry attempts
     */
    void updateState(int retry);

    /**
     * Update local state from queried data
     */
    void updateState();

    /**
     * Turns on bulb
     * @param retry attempts
     */
    void turnOn(int retry);

    /**
     * Turns on bulb
     */
    void turnOn();

    /**
     * Turns off bulb
     * @param retry attempts
     */
    void turnOff(int retry);

    /**
     * Turns off bulb
     */
    void turnOff();

    /**
     * Check whether bulb is on
     * @return on/off state
     */
    boolean isOn();

    /**
     * Leave the colors but set the brightness
     * @param persist after power cycle
     * @param brightness level 0-255
     * @param retry attempts
     */
    void justSetBrightness(boolean persist, int brightness, int retry);

    /**
     * Sets the color to warm white
     * @param level: brightness percent
     * @param persist after power cycle
     * @param retry: number of retry attempts
     */
    void setWarmWhite(int level, boolean persist, int retry);

    /**
     * Sets the color to warm white
     * @param level: brightness percent
     */
    void setWarmWhite(int level);

    /**
     * Sets the color to warm white
     * @param level: brightness value between 0 and 255
     * @param persist after power cycle
     * @param retry: number of retry attempts
     */
    void setWarmWhite255(int level, boolean persist, int retry);

    /**
     * Sets the color to warm white
     * @param level: brightness value between 0 and 255
     */
    void setWarmWhite255(int level);

    /**
     * Set color to cold white
     * @param level: percent brightness
     * @param persist after power cycle
     * @param retry: number of retry attempts
     */
    void setColdWhite(int level, boolean persist, int retry);
    /**
     * Set color to cold white
     * @param level: percent brightness
     */
    void setColdWhite(int level);

    /**
     * Set color to cold white
     * @param level: 0 to 255 brightness
     * @param persist after power cycle
     * @param retry: number of retry attempts
     */
    void setColdWhite255(int level, boolean persist, int retry);

    /**
     * Set color to cold white
     * @param level: 0 to 255 brightness
     */
    void setColdWhite255(int level);

    /**
     * Set color to a white with this temperature
     * @param temperature between 2700 and 6500 kelvin
     * @param brightness value between 0 and 255
     * @param persist after power cycle
     * @param retry: number of retry attempts
     */
    void setWhiteTemperature(int temperature, int brightness, boolean persist, int retry);

    /**
     * Set color to a white with this temperature
     * @param temperature between 2700 and 6500 kelvin
     * @param brightness value between 0 and 255
     */
    void setWhiteTemperature(int temperature, int brightness);

    /**
     * Get the current mode
     * @return mode
     */
    String getMode();

    /**
     * Gets the current warm white value
     * @return value between 0 and 255
     */
    int getWarmWhite255();

    /**
     * Gets the current warm white value
     * @return value between 0 and 255?
     */
    int getWarmWhite();

    /**
     * Gets the current cold white value
     * @return value between 0 and 255?
     */
    int getColdWhite();

    /**
     * Gets the current brightness
     * @return brightness value between 0 and 255
     */
    int getBrightness();

    /**
     * Get the current RGBW value
     * @return color tuple
     */
    PyTuple getRgbw();

    /**
     * Get the current RGBWW value
     * @return color tuple
     */
    PyTuple getRgbww();

    /**
     * Gets the speed of the pattern
     * @return speed
     */
    int getSpeed();

    /**
     * Set rgbw values
     * @param r amount
     * @param g amount
     * @param b amount
     * @param w amount
     * @param persist after power cycle
     * @param brightness 0-255
     * @param retry attempts
     * @param w2 amount
     */
    void setRgbw(int r, int g, int b, int w, boolean persist, int brightness, int retry, int w2);

    /**
     * Get the rgb values
     * @return rgb tuple
     */
    PyTuple getRgb();

    /**
     * Set rgb color
     * @param r amount
     * @param g amount
     * @param b amount
     * @param persist after power cycle
     * @param brightness 0-255
     * @param retry attempts
     */
    void setRgb(int r, int g, int b, boolean persist, int brightness, int retry);

    /**
     * Set rgb color
     * @param r amount
     * @param g amount
     * @param b amount
     */
    void setRgb(int r, int g, int b);

    /**
     * Get current time
     * Format: (year, month, date, hour, minute, second, dayofweek)
     * Days start with Monday(day 1)
     * @return time tuple
     */
    PyTuple getClock();

    /**
     * Update the time
     */
    void setClock();

    /**
     * Sets the current protocol
     * @param protocol: LEDENET or LEDENET_ORIGINAL
     */
    void setTheProtocol(String protocol);

    /**
     * Sets a preset pattern
     * @param pattern value from {@link com.logicmaster63.flux_led_java.flux_led.PresetPattern#getValue}
     * @param speed of pattern
     */
    void setPresetPattern(int pattern, int speed);

    /**
     * Get the currently set timers
     * @return a list of timers
     */
    LedTimer[] getTimers();

    /**
     * Update timers on bulb
     * @param timer_list to send
     */
    void sendTimers(LedTimer[] timer_list);

    /**
     * Set a custom pattern
     * @param rgb_list: list of color tuples
     * @param speed of pattern
     * @param transition_type from {@link com.logicmaster63.flux_led_java.flux_led.PatternTransitionType#getValue}
     */
    void setCustomPattern(PyTuple[] rgb_list, int speed, String transition_type);
}
