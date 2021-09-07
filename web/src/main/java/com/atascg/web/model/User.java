package com.atascg.web.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class User {

    private String name;

    private String surname;

    private String email;

    private String phone;

    private Date birthDate;

}
