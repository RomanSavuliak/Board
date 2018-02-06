package com.roman.savuliak.agile.board.persistence;

import com.roman.savuliak.agile.board.domain.Sequence;
import com.roman.savuliak.agile.board.exceptions.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman on 06.02.2018.
 */
@Repository
public class SequenceDao implements ISequenceDao{
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Long getNextSequenceId(String key) {

        Query query = new Query(Criteria.where("id").is(key));

        Update update = new Update();
        update.inc("sequence", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Sequence sequence = mongoOperations.findAndModify(query, update, options, Sequence.class);

        if(sequence == null) throw new SequenceException("Unable to get sequence for key: " + key);

        return sequence.getSequence();
    }
}