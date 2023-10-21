package sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.models.UserModel;
import sn.edu.isepdiamniadio.tpSpringBoot.tpSpringBoot.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> listerUtilisateurs() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public UserModel trouverUtilisateurParId(@PathVariable Long id) {
        return userService.findUser(id);
    }

    @PostMapping
    public void ajouterUtilisateur(@RequestBody UserModel user) {
        userService.addUser(user);
    }

    @PutMapping
    public UserModel modifierUtilisateur(@RequestBody UserModel user) {
        return userService.editUser(user);
    }

    @DeleteMapping("/{id}")
    public UserModel supprimerUtilisateur(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
