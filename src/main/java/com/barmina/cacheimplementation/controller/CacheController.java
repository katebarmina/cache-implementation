package com.barmina.cacheimplementation.controller;

import com.barmina.cacheimplementation.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kateryna Barmina
 * Controller which contains endpoints for working with cache
 */
@RestController
@RequestMapping("/caches")
public class CacheController {
    /**
     * Instance of CashService
     */
    @Autowired
    private CacheService cacheService;

    /**
     * Endpoint for creating an instance of MyCache class
     */
    @PostMapping 
    public String createCache() {
        return cacheService.createCache();
    }

    /**
     * Endpoint for adding object to the specified cache
     */
    @PostMapping("/{cache}/{key}/{value}")
    public String put(@PathVariable("cache") String cache, @PathVariable("key") String key, @PathVariable("value") String value) {
        return cacheService.put(cache, key, value);
    }

    /**
     * Endpoint to get specified object from cache.
     */
    @GetMapping("/{cache}/{key}")
    public String get(@PathVariable("cache") String cache, @PathVariable("key") String key) {
        return cacheService.get(cache, key);
    }

    /**
     * Endpoint for clearing all caches.
     */
    @DeleteMapping
    public String clearAllCaches() {
        return cacheService.clear();
    }

    /**
     * Endpoint for clearing specified cache.
     */
    @DeleteMapping("/{cache}")
    public String clearCache(@PathVariable("cache") String cache) {
        return cacheService.clear(cache);
    }

    /**
     * Endpoint for checking if the specified cache exists or not.
     */
    @GetMapping("/{cache}")
    public String isCacheExists(@PathVariable String cache) {
        return cacheService.isCacheExist(cache);
    }
}
