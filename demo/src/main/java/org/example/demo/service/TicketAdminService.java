package org.example.demo.service;

import org.example.demo.dao.db.MovieTicketAdminDAO;
import org.example.demo.dao.model.MovieTicket;

import java.sql.SQLException;
import java.util.List;

public class TicketAdminService {
    private MovieTicketAdminDAO ticketDAO;

    public TicketAdminService(MovieTicketAdminDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public List<MovieTicket> getAllBookedTickets() throws SQLException {
        return ticketDAO.getAllBookedTickets();
    }

    public List<MovieTicket> searchTickets(String keyword) throws SQLException {
        return ticketDAO.searchTickets(keyword);
    }
}
