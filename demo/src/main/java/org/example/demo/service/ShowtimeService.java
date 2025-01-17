package org.example.demo.service;
import org.example.demo.dao.ShowtimeDao;
import org.example.demo.dao.model.Showtime;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ShowtimeService {
    ShowtimeDao showtimeDao = new ShowtimeDao();

    public List<Showtime> getShowTime(int movieId) {
        return showtimeDao.getShowTime(movieId);
    }

    public List<Showtime> getShowTimeSameDate(int movieId) {
        return showtimeDao.getShowTimeSameDate(movieId);
    }

    public List<Showtime> getShowTimeByDateAndId(int id, String date, String month) {
        return showtimeDao.getShowTimeByDateAndId(id, date, month);  }
    public Showtime getShowtimeById(int id) {
        return showtimeDao.getShowtimeById(id);
    }

//    public List<Showtime> getShowTimeByTimeAndId(int id, String hour, String minute) {
//    }
}
