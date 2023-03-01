package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
//Postgres doesnt allow creating table with name User which is a reserved keyword, so set table name to users
@Table(name="users")
@Getter
@Setter
public class User extends BaseModel{
    private String email;
}
