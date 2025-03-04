package com.patika.emlakburadauserservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String USER_NOT_FOUND = "kullanıcı bulunamadı.";
    public static final String USER_NOT_FOUND_BY_EMAIL = "geçerli email ile kayıtlı kullanıcı bulunamadı.";
    public static final String USER_NOT_ACTIVE = "user aktif değil.";
    public static final String EMAIL_ALREADY_EXIST = "bu email ile kayıtlı kullanıcı var";
}
