package com.example.service;

import com.example.user.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class UserService {
    private static Map<Long, User> userMap = new TreeMap<>();

    static {
        userMap.put(1L, new User(1L, "Bruno", "oliveira", "brunoOliv", "mySecretPassword"));
        userMap.put(2L, new User(2L, "Ricardo", "oliveira", "ricOliv", "mySecretPassword1"));
        userMap.put(3L, new User(3L, "My", "Kat", "kaaaat", "myKatPassword"));
        userMap.put(4L, new User(4L, "Some", "One", "someone", "mySecretPassword3"));
        userMap.put(5L, new User(5L, "Ricardo", "Quaresma", "quaresmaOfficial", "mySecretPassword4"));
    }

    public boolean create(User user) {
        User newUser = userMap.putIfAbsent(user.getId(), user);
        return newUser == null;
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(long userId) {
        userMap.remove(userId);
    }

    public User findByID(Long id) {
        return userMap.get(id);
    }


}
