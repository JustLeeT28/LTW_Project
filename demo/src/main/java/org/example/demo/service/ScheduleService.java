package org.example.demo.service;

import org.example.demo.dao.ScheduleDao;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleService {
    ScheduleDao scheduleDao = new ScheduleDao();

    public boolean isConflict(String movieId, String roomId, String showDate, String showTime) {
        return scheduleDao.isConflict(movieId, roomId, showDate, showTime);
    }

    public void addShowTime(String movieId, String roomId, String showDate, String showTime) {
        if(isNumber(roomId)) {
            scheduleDao.addShowTime(movieId, roomId, showDate, showTime);
        }
        else {
            scheduleDao.addShowTimeByName(movieId, roomId, showDate, showTime);
        }
    }


    public Showtime GetShowtime(int movieIdInt, int roomIdInt, LocalDate localShowDate, LocalTime localShowTime) {
        return scheduleDao.GetShowTime(movieIdInt, roomIdInt, localShowDate, localShowTime);
    }

//    public void addShowAndSeat(int id, String movieId) {
//        scheduleDao.addShowAndSeats(id,movieId);
//    }

    public List<Seat> getListSeatsByRoomid(String roomId) {
        return scheduleDao.GetSeatByRoom(roomId);
    }

    public void addSh_S(int id, int id1, String isActive, int id3) {
        scheduleDao.addShow_seats(id, id1, isActive, id3);
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
        scheduleDao.del_show_seat(i, id);
    }

    public static boolean isNumber(String queryCus) {
        String phoneRegex = "^[0-9]{2,15}$";
        return queryCus.matches(phoneRegex);
    }

    public static void main(String[] args) {
        ScheduleService scheduleService = new ScheduleService();
        List<Seat> seats = scheduleService.getListSeatsByRoomid("1");
        for (Seat seat : seats) {
            System.out.println(seat.getRoomId());
        }
    }
}

