package com.skhanal5.model;

import lombok.Data;

@Data
public class Book {
    String title;
    String author;
    String genre; //change to enum later on
    int numOfCopiesAvailable;
    int numOfCopiesSold;
    int ISBN;
}
