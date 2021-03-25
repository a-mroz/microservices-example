package dev.amroz.microservices.bookshop.catalog.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private UUID businessKey;

    @Basic
    private String title;

    @Basic
    private BigDecimal price;

    public String title() {
        return title;
    }

    public BigDecimal price() {
        return price;
    }




}
