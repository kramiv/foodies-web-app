package learn.recipemanager.controllers;

import learn.recipemanager.domain.AppUserService;
import learn.recipemanager.models.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getUsers() {

        List<AppUser> users = appUserService.findAll();

        for (AppUser u : users) {
            u.setPassHash("");
        }
        ;

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/account/{userId}")
    public ResponseEntity<Object> getAccount(@PathVariable String userId) {
        AppUser user = appUserService.findById(userId).getPayload();

        if (user == null) {
            return new ResponseEntity<>("Account was not found.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        if (appUserService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}