package main.tutorial.LLD.InheritenceDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String email;

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }
}
