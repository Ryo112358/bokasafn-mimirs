package dev.koicreek.bokasafn.mimir.users.model;

import lombok.Data;


@Data
public class LoginRequestCM {
    private String username;
    private String password;
}
