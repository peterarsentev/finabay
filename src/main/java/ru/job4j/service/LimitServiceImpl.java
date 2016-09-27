package ru.job4j.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
@Service
public class LimitServiceImpl implements LimitService {
    private final ConcurrentHashMap<String, Pair> cache = new ConcurrentHashMap<>();

    @Value("${limit.period}")
    private int period;

    @Value("${limit.total}")
    private int total;

    @Override
    public boolean isLimit(String locale) {
        boolean result;
        do {
            Pair pair = this.cache.get(locale);
            Pair temp = pair;
            if (pair == null) {
                pair = new Pair(System.currentTimeMillis(), 1);
                temp = pair;
            } else {
                if ((System.currentTimeMillis() - pair.start)/1000 > total) {
                    pair = new Pair(System.currentTimeMillis(), 1);
                } else {
                    pair = new Pair(pair.start, pair.count + 1);
                }
            }
            result = this.cache.putIfAbsent(locale, pair) == null || this.cache.replace(locale, temp, pair);
        } while (!result);
        return this.cache.get(locale).count > this.total;
    }

    private final class Pair {
        private final long start;
        private final int count;

        private Pair(final long start, final int count) {
            this.start = start;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (start != pair.start) return false;
            return count == pair.count;

        }

        @Override
        public int hashCode() {
            int result = (int) (start ^ (start >>> 32));
            result = 31 * result + count;
            return result;
        }
    }
}
