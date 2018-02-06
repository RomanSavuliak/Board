package com.roman.savuliak.agile.board.services;

import com.roman.savuliak.agile.board.domain.Ticket;
import com.roman.savuliak.agile.board.persistence.SequenceDao;
import com.roman.savuliak.agile.board.persistence.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Roman on 06.02.2018.
 */
@Service
public class TicketService implements ITicketService{

    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
    }

    @Override
    public Ticket createTicket(String name, String description, String state){
        return Ticket.builder()
                .userId(userService.getCurrentUser().getId())
                .name(name)
                .description(description)
                .state(state)
                .build();
    }

    @Override
    public Long add(Ticket ticket) {
        ticket.setId(sequenceDao.getNextSequenceId(Ticket.COLLECTION_NAME));
        ticketDao.save(ticket);
        return ticket.getId();
    }

    @Override
    public List<Ticket> findByUserId(Long id){
        return ticketDao.findByUserId(id);
    }

    @Override
    public void setToDoState(Long id){
        Ticket ticket = ticketDao.findById(id);
        ticket.setState("todo");
        ticketDao.save(ticket);
    }

    @Override
    public void setInProgressState(Long id){
        Ticket ticket = ticketDao.findById(id);
        ticket.setState("in-progress");
        ticketDao.save(ticket);
    }

    @Override
    public void setDoneState(Long id){
        Ticket ticket = ticketDao.findById(id);
        ticket.setState("done");
        ticketDao.save(ticket);
    }

    @Override
    public void remove(Long id){
        ticketDao.remove(id);
    }
}