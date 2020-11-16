package org.forum.service;

import org.forum.entity.Uzivatel;

import java.util.List;

public interface UzivatelService {
    List<Uzivatel> getAllUzivatelov();
    void saveUzivatel(Uzivatel uzivatel);
    Uzivatel getUzivatelByName(String name);
}
