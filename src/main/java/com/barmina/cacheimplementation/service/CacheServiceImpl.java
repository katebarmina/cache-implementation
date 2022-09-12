package com.barmina.cacheimplementation.service;

import com.barmina.cacheimplementation.cache.MyCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kateryna Barmina
 * Implemention of CacheService interface
 */
@Service
public class CacheServiceImpl implements CacheService {

    /**
     * Logger instance
     */
    private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
    /**
     * instance of MyCache class, which contains methods that work with cache itself
     */
    @Autowired
    private MyCache cacheMap;

    /**
     * Creates cache.
     * @return defines whether the cache was created or not
     */
    public String createCache() {
        logger.debug("Trying to create cache..");
        if (cacheMap != null) {
            logger.debug("The cache was successfully created.");
            return "The cache was successfully created.";
        }
        logger.debug("Couldn't create cache.");
        return "Couldn't create cache.";
    }

    /**
     * Gets the object from the cache.
     * @param cache - name of the cache
     * @param key   - unique identifier for an object in the cache
     * @return - object from cache
     */

    public String get(String cache, String key) {
        return cacheMap.get(cache, key);
    }

    /**
     * Caches the object.
     * @param cache - name of the cache
     * @param key   - unique identifier for an object in the cache
     * @param str   - object from cache
     * @return - defines whether the key was added to cache or not
     */
    public String put(String cache, String key, String str) {
        if (cacheMap.put(cache, key, str)) {
            return "The key was successfully added to cache.";
        } else {
            return "Couldn't add key to the cache.";
        }
    }

    /**
     * Clears all caches.
     * @return notifies that all caches have been cleared
     */

    public String clear() {
        cacheMap.clear();
        return "All caches have been cleared.";
    }

    /**
     * Clears the specified cache.
     * @param cache - name of the cache which needs to be cleared
     * @return - notifies that the cache was cleared
     */

    public String clear(String cache) {
        cacheMap.clear(cache);
        return "The " + cache + " cache was successfully cleared.";
    }

    /**
     * Checks whether the specified cache exists.
     * @param cache - name of the cache
     * @return - defines whether the specified cache exists or not
     */

    public String isCacheExist(String cache) {
        return String.valueOf(cacheMap.isCacheExist(cache));
    }


}
