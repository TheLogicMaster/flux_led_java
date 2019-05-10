package com.logicmaster63.flux_led;

import org.python.core.PyDictionary;

/**
 * A wrapper for the flux led bulb scanner
 */
public interface BulbScanner {
    /**
     * Finds bulb info using an id
     * @param id
     * @return the found bulb info dict
     */
    PyDictionary getBulbInfoByID(String id);

    /**
     * Get scan results
     * @return array of bulb info dicts
     */
    PyDictionary[] getBulbInfo();

    /**
     * Scan for bulbs
     * @param timeout in seconds
     * @return Array of found bulb info dicts
     */
    PyDictionary[] scan(int timeout);

    /**
     * Scan for bulbs
     * @return Array of found bulb info dicts
     */
    PyDictionary[] scan();
}
