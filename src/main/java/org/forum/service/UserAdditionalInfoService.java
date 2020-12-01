package org.forum.service;

<<<<<<< Updated upstream
import org.forum.entities.Post;
=======
>>>>>>> Stashed changes
import org.forum.entities.user.User;
import org.forum.entities.user.UserAdditionalInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserAdditionalInfoService {

    UserAdditionalInfo findOne(int id);

    UserAdditionalInfo findByUser(User user);

    void save(UserAdditionalInfo userAdditionalInfo);



}
