package com.projet.library.prez;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public final static String BASE_URL = "v1/api";

    public final static String BOOK_BASE_URL = BASE_URL + "/books";

    public final static String BOOK_URL_BY_NAME = BOOK_BASE_URL + "/{name}";
}
