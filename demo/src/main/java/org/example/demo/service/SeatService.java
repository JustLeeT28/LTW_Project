package org.example.demo.service;

import org.example.demo.dao.SeatDao;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.ShowSeat;

import java.util.ArrayList;
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

    public List<Seat> getSeatByQuery(String querySeats) {
        List<Seat> listSeat = new ArrayList<>();
        String[] queryString = querySeats.split("-");
        if(queryString.length == 1) {
            listSeat = seatDao.getSeatsInRoom(Integer.parseInt(queryString[0]));
        }
        else if(queryString.length == 2) {
            listSeat = seatDao.getSeatsByRoomAndRow(Integer.parseInt(queryString[0]),queryString[1]);
        } else if (queryString.length == 3) {
            listSeat = seatDao.getSeatByRoom_Row_Number(Integer.parseInt(queryString[0]),queryString[1],queryString[2]);
        }
        return listSeat;
    }

    public static void main(String[] args) {
        SeatService seatService = new SeatService();
        List<Seat> seats = seatService.getSeatByQuery("1");
        for(Seat seat : seats) {
            System.out.println(seat.getId());
        }
    }
}
