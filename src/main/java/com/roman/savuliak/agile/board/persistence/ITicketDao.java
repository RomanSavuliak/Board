package com.roman.savuliak.agile.board.persistence;

import com.roman.savuliak.agile.board.domain.Ticket;
import lombok.NonNull;

import java.util.List;

/**
 * Created by Roman on 06.02.2018.
 */
public interface ITicketDao {
    List<Ticket> findByUserId(@NonNull Long id);
    Ticket findById(@NonNull Long id);
    void save(@NonNull Ticket ticket);
    void remove(Long id);

}