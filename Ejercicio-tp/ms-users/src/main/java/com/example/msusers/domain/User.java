package com.example.msusers.domain;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class User {
    //esta entidad la modelan ustedes de acuerdo a los atributos que vayan a necesitar
    private String id;
    private String username;
    private String email;
    private String firstname;


}
