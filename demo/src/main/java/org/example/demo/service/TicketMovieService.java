package org.example.demo.service;

import org.example.demo.dao.TicketMovieDao;
import org.example.demo.dao.model.MovieTicket;

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

    public void update2D(int i) {
        ticketMovieDao.update2D(i);
    }

    public void update3D(int i) {
        ticketMovieDao.update3D(i);
    }
    public void update4D(int i) {
        ticketMovieDao.update4D(i);
    }
    public void updateImax(int i) {
        ticketMovieDao.updateImax(i);
    }

    public void delTicketById(String ticketIdDel) {
        ticketMovieDao.delTicketById(ticketIdDel);
    }
}
