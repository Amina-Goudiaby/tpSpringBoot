package sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.repositorys;

import org.springframework.stereotype.Repository;
import sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.models.UserModel;

import java.util.List;

@Repository
public interface UserRepository {
    public List<UserModel> getUser();
    public UserModel findUser(Long id);
    public UserModel deleteUser(Long id);
    public void addUser(UserModel user);
    public UserModel editUser(UserModel user);
}
