package sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.models.UserModel;
import sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.repositorys.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserRepository {
    @Autowired

    private static List<UserModel> list = new ArrayList<>();
    private UserModel userModel;
    static {
        list.add(new UserModel(1L, "GOUDIABY", "Aminata", "goudiabyaminata2001@gmail.com"));
        list.add(new UserModel(2L, "Kanouté", "Fatimah", "fatimahkanoute@gmail.com"));
    }

    @Override
    public List<UserModel> getUser() {
        return list;
    }

    @Override
    public UserModel findUser(Long id) {
        for (UserModel user : list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserModel deleteUser(Long id) {
        UserModel user = findUser(id);
        if (user != null) {
            list.remove(user);
        }
        return user;
    }

    @Override
    public void addUser(UserModel user) {
        user.setId((long) (list.size() + 1));
        list.add(user);
    }

    @Override
    public UserModel editUser(UserModel user) {
        UserModel existingUser = findUser(user.getId());
        if (existingUser != null) {
            existingUser.setNom(user.getNom());
            existingUser.setPrenom(user.getPrenom());
            existingUser.setEmail(user.getEmail());
        }
        return existingUser;
    }
}
