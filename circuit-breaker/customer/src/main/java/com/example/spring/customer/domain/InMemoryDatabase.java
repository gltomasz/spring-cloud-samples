package com.example.spring.customer.domain;

import java.util.concurrent.ConcurrentHashMap;

class InMemoryDatabase<T extends BaseEntity> {

    private ConcurrentHashMap<Long, T> database;

    private Long id = 0L;

    InMemoryDatabase() {
        this.database = new ConcurrentHashMap<>();
    }

    synchronized void add(T t) {
        long a = generateNextId();
        t.setId(a);
        database.put(t.getId(), t);
    }

    T get(Long id) {
        return database.get(id);
    }

    private Long generateNextId() {
        return ++id;
    }
}
