package org.forum.service;

import org.forum.entity.Prispevok;

import java.util.List;

public interface PrispevokService {
    List<Prispevok> getAllPrispevky();
    void savePrispevok(Prispevok prispevok);
    Prispevok getPrispevokById(Integer id);
}
