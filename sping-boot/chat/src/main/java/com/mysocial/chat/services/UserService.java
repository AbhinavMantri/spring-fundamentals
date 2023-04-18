package com.mysocial.chat.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.mysocial.chat.entity.User;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusDays(22)));
        users.add(new User(++userCount, "Eva", LocalDate.now().minusDays(30)));
        users.add(new User(++userCount, "Martin", LocalDate.now().minusDays(15)));
        users.add(new User(++userCount, "Susan", LocalDate.now().minusDays(45)));
        users.add(new User(++userCount, "Avail", LocalDate.now().minusDays(58)));
    }

    public List<User> retrieveUsers() {
        return this.users;
    }

    public User retrieveUser(int id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(++userCount);
        this.users.add(user);
        return user;
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
