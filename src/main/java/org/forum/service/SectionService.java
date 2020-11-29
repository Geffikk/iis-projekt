package org.forum.service;

import org.forum.entities.Section;
import org.forum.entities.Topic;
import org.forum.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface SectionService {

    List<Section> findAll();

    Section findOne(int id);

    Section findByName(String name);

    Section save(Section section);

    Set<Section> findByUser(User user);

    //Set<Section> findAllByModerators();

    //Set<Section> findAllByMembers();

    void delete(int id);

    void delete(Section section);

}
