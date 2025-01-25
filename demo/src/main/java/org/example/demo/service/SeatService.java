package org.example.demo.service;

import org.example.demo.dao.SeatDao;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.ShowSeat;

import java.util.List;
import java.util.Set;

public class SeatService {
    SeatDao seatDao = new SeatDao();
    public List<ShowSeat> getStatusSeatByShowtimeId(int showtimeId, int roomId) {
        return seatDao.getStatusSeatByShowtimeId(showtimeId, roomId);
    }
    public List<Seat> getSeatsInRooms(int roomId) {
        return seatDao.getSeatsInRoom(roomId);
    }
    public Set<String> getRowsInRoom(int roomId) {
        return seatDao.getRowInRoom(roomId);
    }
    public Seat  getSeatById(int seatId) {
        return seatDao.getSeatById(seatId);
    }
    public void updateSeatStatus(int seatId, String status, int showtimeId) {
        seatDao.setStatus(status ,seatId, showtimeId);
    }

    public List<Seat> getAllSeat(){
        return seatDao.getAllSeat();
//        return null; // khoi tao trc
    }

}
