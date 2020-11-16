package org.forum.service;

import org.forum.entity.Vlakno;

import java.util.List;

public interface VlaknoService {
    List<Vlakno> getAllVlakna();
    void saveUzivatel(Vlakno vlakno);
    Vlakno getVlaknoById(Integer id);
}
