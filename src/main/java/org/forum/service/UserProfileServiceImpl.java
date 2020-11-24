package org.forum.service;

import org.forum.entities.user.User;
import org.forum.entities.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private TopicService topicService;

    @Override
    public UserProfile findOne(int uzivatelId) {
        UserProfile userProfile = new UserProfile();
        User user = userService.findOne(uzivatelId);
        userProfile.setUser(user);
        userProfile.setPrispevky(postService.findByUser(user));
        userProfile.setVlakna(topicService.findByUser(user));
        return userProfile;
    }

    @Override
    public UserProfile findOne(String username) {
        return findOne(userService.findByUsername(username).getId());
    }
}
