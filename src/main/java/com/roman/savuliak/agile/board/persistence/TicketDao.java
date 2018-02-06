package com.roman.savuliak.agile.board.persistence;

import com.roman.savuliak.agile.board.domain.Ticket;
import com.roman.savuliak.agile.board.domain.TicketField;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Roman on 06.02.2018.
 */
@Component
public class TicketDao implements ITicketDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Ticket> findByUserId(@NonNull Long id) {
        return mongoTemplate.find(
                query(
                        where(TicketField.USER_ID.field()).is(id)),
                Ticket.class);
    }

    @Override
    public Ticket findById(@NonNull Long id){
        return mongoTemplate.findOne(
                query(
                        where("id").is(id)),
                Ticket.class);
    }

    @Override
    public void save(@NonNull Ticket ticket) {
        mongoTemplate.save(ticket);
    }

    @Override
    public void remove(Long id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Ticket.class);
    }
}