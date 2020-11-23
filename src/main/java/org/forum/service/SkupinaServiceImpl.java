package org.forum.service;

import org.forum.entity.Skupina;
import org.forum.repository.SkupinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkupinaServiceImpl implements SkupinaService {

    @Autowired
    private SkupinaRepository skupinaRepository;

    @Override
    public List<Skupina> findAll() {
        return skupinaRepository.findAll();
    }

    @Override
    public Skupina findOne(int id) {
        Optional<Skupina> optional = skupinaRepository.findById(id);
        Skupina skupina = null;
        if (optional.isPresent()) {
            skupina = optional.get();
        } else {
            throw new RuntimeException("Skupina s id: " + id + " nebola najdena!");
        }
        return skupina;
    }

    @Override
    public Skupina findByNazov(String nazov) {
        return skupinaRepository.findByNazov(nazov);
    }

    @Override
    public Skupina save(Skupina skupina) {
        return skupinaRepository.save(skupina);
    }

    @Override
    public void delete(int id) {
        delete(findOne(id));
    }

    @Override
    public void delete(Skupina skupina) {
        skupinaRepository.delete(skupina);
    }
}