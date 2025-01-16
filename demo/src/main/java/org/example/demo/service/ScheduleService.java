package org.example.demo.service;

import org.example.demo.dao.ScheduleDao;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleService {
    ScheduleDao scheduleDao = new ScheduleDao();
    public boolean isConflict(String movieId,String roomId, String showDate, String showTime) {
        return scheduleDao.isConflict(movieId,roomId,showDate,showTime);
    }

    public void addShowTime(String movieId, String roomId, String showDate, String showTime) {
        scheduleDao.addShowTime(movieId,roomId,showDate,showTime);
    }

    public Showtime GetShowtime(int movieIdInt, int roomIdInt, LocalDate localShowDate, LocalTime localShowTime) {
        return scheduleDao.GetShowTime(movieIdInt,roomIdInt,localShowDate,localShowTime);
    }

//    public void addShowAndSeat(int id, String movieId) {
//        scheduleDao.addShowAndSeats(id,movieId);
//    }

    public List<Seat> getListSeatsByRoomid(String roomId) {
        return scheduleDao.GetSeatByRoom(roomId);
    }

    public void addSh_S(int id, int id1, String isActive) {
        scheduleDao.addShow_seats(id,id1,isActive);
    }

    public List<Showtime> getAllShowtime() {
        return scheduleDao.getAllShowtime();
    }

    public void dellshowtimeID(int i) {
        scheduleDao.dellShowtimeID(i);
    }

    public Showtime getShowtimeByID(int i) {
        return scheduleDao.GetShowTimeByID(i);
    }

    public void del_show_seat(int i, int id) {
        scheduleDao.del_show_seat(i,id);
    }
}
