package com.atascg.web.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class User {

    @NonNull
    private String name;

    private String surname;

    @NonNull
    private String email;

    @NonNull
    private String phone;

    private Date birthDate;

}
