package org.forum.service;

import org.forum.entity.Uzivatel;
import org.forum.repository.UzivatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UzivatelServiceImpl implements UzivatelService {

    @Autowired
    private UzivatelRepository uzivatelRepository;

    @Override
    public List<Uzivatel> getAllUzivatelov() {
        return uzivatelRepository.findAll();
    }

    @Override
    public void saveUzivatel(Uzivatel uzivatel) {
        this.uzivatelRepository.save(uzivatel);
    }

    @Override
    public Uzivatel getUzivatelByName(String name) {
        Optional<Uzivatel> optional = uzivatelRepository.findById(name);
        Uzivatel uzivatel = null;
        if(optional.isPresent()) {
            uzivatel = optional.get();
        }else {
            throw new RuntimeException("Uzivatel s menom: " + name + " nebol najdeny!");
        }
        return uzivatel;
    }

}
