package dev.amroz.microservices.bookshop.catalog.service;

import javax.inject.Inject;
import dev.amroz.microservices.bookshop.catalog.domain.Book;
import dev.amroz.microservices.bookshop.catalog.domain.BookRepository;
import io.reactivex.Flowable;


public class ListBooksService {

    private final BookRepository repository;

    @Inject
    public ListBooksService(
        BookRepository repository) {
        this.repository = repository;
    }

    public Flowable<Book> listBooks() {
        return Flowable.fromIterable(repository.findALl());
    }

}
