package dev.amroz.microservices.bookshop.catalog.domain;

public interface BookRepository {

    Iterable<Book> findALl();

}
