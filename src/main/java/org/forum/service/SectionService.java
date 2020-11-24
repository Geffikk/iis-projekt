package org.forum.service;

import org.forum.entities.Section;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectionService {

    List<Section> findAll();

    Section findOne(int id);

    Section findByName(String name);

    Section save(Section section);

    void delete(int id);

    void delete(Section section);

}
