package org.example.demo.service;

import org.example.demo.dao.TicketMovieDao;
import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.User;

import java.util.List;

public class TicketMovieService {
    TicketMovieDao ticketMovieDao = new TicketMovieDao();
    public List<MovieTicket> getTicketAll() {
        return ticketMovieDao.getTicketAll();
    }

    public List<MovieTicket> getTicketByQuery(String queryTikket) {
        if(isNumber(queryTikket)) {
            return ticketMovieDao.getTicketMoiveById(queryTikket);
        }
        return ticketMovieDao.getTicketMovieByName(queryTikket);

    }
    public static boolean isNumber(String queryCus) {
        String phoneRegex = "^[0-9]{1,15}$";
        return queryCus.matches(phoneRegex);
    }
}
