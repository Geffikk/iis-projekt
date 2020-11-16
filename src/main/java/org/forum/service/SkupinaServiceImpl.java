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
    public List<Skupina> getAllSkupiny() {
        return skupinaRepository.findAll();
    }

    @Override
    public void saveSkupinu(Skupina skupina) {
        this.skupinaRepository.save(skupina);
    }

    @Override
    public Skupina getSkupinuByName(String name) {
        Optional<Skupina> optional = skupinaRepository.findById(name);
        Skupina skupina = null;
        if(optional.isPresent()) {
            skupina = optional.get();
        }else {
            throw new RuntimeException("Skupina s menom: " + name + " nebola najdena!");
        }
        return skupina;
    }
}
