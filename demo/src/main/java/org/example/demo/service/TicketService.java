package org.example.demo.service;

import org.example.demo.dao.TicketDao;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.MovieTickets;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

//    public List<MovieTickets> gettiketFoodById(int id) {
//    }

    public List<MovieTickets> getTikeckMovieByID(int id) {
        String idStr = String.valueOf(id);
        return ticketDao.getTikeckMovieByID(idStr);
    }

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        List<MovieTickets> list = new ArrayList<>();
        list = ticketService.getTikeckMovieByID(21);
        for (MovieTickets movieTickets : list) {
            System.out.println(movieTickets.getPrice());
        }
    }
}
