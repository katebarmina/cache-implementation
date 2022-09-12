package com.barmina.cacheimplementation.service;

/**
 * @author Kateryna Barmina
 * Interface which contains methods for working with cache
 */
public interface CacheService {

    String createCache();

    String get(String cache, String key);

    String put(String cache, String key, String str);

    String clear();

    String clear(String cache);

    String isCacheExist(String cache);
}
