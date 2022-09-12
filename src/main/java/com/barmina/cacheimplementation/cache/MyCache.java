package com.barmina.cacheimplementation.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kateryna Barmina
 * A class for storing and working with caches
 */
@Component
public class MyCache {

    /**
     * Logger instance
     */
    private static final Logger logger = LoggerFactory.getLogger(MyCache.class);
    /**
     * Repository for caches
     */
    private final Map<String, Map<String, String>> cacheMap;

    public MyCache() {
        this.cacheMap = new HashMap<>();
    }

    /**
     * Caches the object.
     * @param cache - name of the cache
     * @param key   - unique identifier for an object in the cache
     * @param str   - object from cache
     * @return - return true if data was successfully cached
     */
    public boolean put(String cache, String key, String str) {
        logger.debug("Checking if cache contains the specified cache");
        if (cacheMap.containsKey(cache)) {
            logger.debug("Caching the object");
            cacheMap.get(cache).put(key, str);
        } else {
            logger.debug("Creating cache with the specified name");
            logger.debug("Caching the object");
            cacheMap.put(cache, new HashMap<>() {{
                put(key, str);
            }});
        }
        return true;
    }

    /**
     * Gets the specified object from the cache.
     * @param cache - name of the cache
     * @param key   - unique identifier for an object in the cache
     * @return either object from the cache or message,
     * which notifies about absence of the searched object
     */
    public String get(String cache, String key) {
        logger.debug("Checking if cache contains the specified cache and if this cache contains the specified key");
        if (cacheMap.containsKey(cache) && cacheMap.get(cache).containsKey(key)) {
            logger.debug("Returning object from the cache");
            return cacheMap.get(cache).get(key);
        } else {
            logger.debug("Couldn't find the specified object");
            return "There isn't such element.";
        }
    }

    /**
     * Clears all caches.
     */
    public void clear() {
        logger.debug("Clearing all caches");
        cacheMap.clear();
    }

    /**
     * Clears the specified cache.
     * @param cache - name of the cache which needs to be cleared
     */
    public void clear(String cache) {
        logger.debug("Preparing for cleaning the specified cache");
        logger.debug("Checking if the specified cache exists");
        if (isCacheExist(cache)) {
            logger.debug("Clearing the cache");
            cacheMap.remove(cache);
        }
    }

    /**
     * Checks whether the specified cache exists.
     * @param cache - name of the cache
     * @return - return true if cache with the given name exists or false if it doesn't
     */
    public boolean isCacheExist(String cache) {
        logger.debug("Checking if the specified cache exists..");
        return cacheMap.containsKey(cache);
    }

}
