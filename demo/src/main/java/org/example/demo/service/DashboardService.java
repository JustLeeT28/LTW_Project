package org.example.demo.service;

import org.example.demo.dao.OrderDao;

public class DashboardService {
    OrderDao orderDao = new OrderDao();
    public double getTotalFood7() {
        return orderDao.getTotalFood7();
    }

    public double getTotalMovie7() {
        return orderDao.getTotalMovie7();
    }

    public double getTotalFood30() {
        return orderDao.getTotalFood30();
    }

    public double getTotalMovie30() {
        return orderDao.getTotalMovie30();
    }

    public double getTotalFood365() {
        return orderDao.getTotalFood365();
    }

    public double getTotalMovie365() {
        return orderDao.getTotalMovie365();
    }

    public int getTotalMovieTicket(int i) {
        return orderDao.getTotalTicketMovie(i);
    }
}
