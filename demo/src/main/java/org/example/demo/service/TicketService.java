package org.example.demo.service;

import org.example.demo.dao.TicketDao;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.MovieTickets;

public class TicketService {
    TicketDao ticketDao = new TicketDao();

    public void addMovieTicket(MovieTickets movieTickets) {
        ticketDao.addMovieTicket(movieTickets);
    }
    public void addFoodTicketItem(FoodTicketItem foodTicketItem) {
        ticketDao.addFoodTicketItem(foodTicketItem);
    }
    public MovieTickets getMovieTicketByUserId(int id) {
        return ticketDao.getMovieTicketByUserId(id);
    }
    public FoodTicketItem getFoodTicketItemByUserId(int id) {
        return ticketDao.getFoodTicketItemByUserId(id);
    }
}
