package com.patika.emlakburadauserservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String province;
}
