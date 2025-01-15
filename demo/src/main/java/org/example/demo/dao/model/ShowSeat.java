package org.example.demo.dao.model;

public class ShowSeat {
    private int id;
    private int showId;
    private int seatId;
    private int roomId;
    private String status;

    public ShowSeat(int id, int showId, int seatId, String status, int roomId) {
        this.id = id;
        this.showId = showId;
        this.seatId = seatId;
        this.status = status;
        this.roomId = roomId;
    }
    public ShowSeat(int id, int showId, int seatId, String status) {
        this.id = id;
        this.showId = showId;
        this.seatId = seatId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
