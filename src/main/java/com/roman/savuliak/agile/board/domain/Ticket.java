package com.roman.savuliak.agile.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Roman on 06.02.2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Ticket.COLLECTION_NAME)
public class Ticket {
    public static final String COLLECTION_NAME = "tickets";
    @Id
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private String state;

    public Ticket(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }
}