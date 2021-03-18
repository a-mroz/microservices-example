package dev.amroz.microservices.bookshop.catalog.infrastructure;

import dev.amroz.microservices.bookshop.catalog.domain.Book;
import dev.amroz.microservices.bookshop.catalog.domain.BookRepository;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
interface JpaBookRepository extends BookRepository, CrudRepository<Book, Long> {
}
