package com.codegaju;

import java.util.List;

public interface Operation <T> {
    void create(T table);
    void read(int id);
    List<T> readAll();// to read all tables
    void update(T table);
    void delete(int id);
}

