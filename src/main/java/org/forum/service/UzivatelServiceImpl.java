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
    public List<Uzivatel> findAll() {
        return uzivatelRepository.findAll();
    }

    @Override
    public Uzivatel findOne(int id) {
            Optional<Uzivatel> optional = uzivatelRepository.findById(id);
            Uzivatel uzivatel = null;
            if(optional.isPresent()) {
                uzivatel = optional.get();
            }else {
                throw new RuntimeException("Uzivatel s id: " + id + " nebol najdeny!");
            }
            return uzivatel;
    }

    @Override
    public Uzivatel findByUzivatelskeMeno(String uzivatelskeMeno) {
        Uzivatel user = uzivatelRepository.findByUzivatelskeMeno(uzivatelskeMeno);
        if (user == null) {
            throw new RuntimeException("Uzivatel s menom: " + uzivatelskeMeno + " nebol najdeny!");
        }
        return user;
    }

    @Override
    public Uzivatel save(Uzivatel uzivatel) {
        return uzivatelRepository.save(uzivatel);
    }

}