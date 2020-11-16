package org.forum.service;

import org.forum.entity.Skupina;

import java.util.List;

public interface SkupinaService {
    List<Skupina> getAllSkupiny();
    void saveSkupinu(Skupina skupina);
    Skupina getSkupinuByName(String name);
}
