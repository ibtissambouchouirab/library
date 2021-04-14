package com.projet.library.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CategoryBook {

    Romance("Romance"),
    cooking("cook"),
    history("history"),
    Travel("Travel"),
    Horror("Horror") ;

    private String Category ;
}
