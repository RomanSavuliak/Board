package com.roman.savuliak.agile.board.services;

import com.roman.savuliak.agile.board.domain.Ticket;

import java.util.List;

/**
 * Created by Roman on 06.02.2018.
 */
public interface ITicketService {
    Ticket createTicket(String name, String description, String state);
    Long add(Ticket ticket);
    List<Ticket> findByUserId(Long id);
    void setToDoState(Long id);
    void setInProgressState(Long id);
    void setDoneState(Long id);
    void remove(Long id);
}