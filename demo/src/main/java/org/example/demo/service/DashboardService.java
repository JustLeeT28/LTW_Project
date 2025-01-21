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
}
