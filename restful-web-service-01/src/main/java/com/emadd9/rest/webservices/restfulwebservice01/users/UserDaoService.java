package com.emadd9.rest.webservices.restfulwebservice01.users;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Sudeb", LocalDate.of(1998,10,15)));
        users.add(new User(++userCount,"Neil", LocalDate.of(1999,12,14)));
        users.add(new User(++userCount,"Ishan", LocalDate.of(2000,11,19)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<? super User>predicate
                = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
