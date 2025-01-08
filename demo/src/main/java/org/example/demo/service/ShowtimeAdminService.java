package org.example.demo.service;

import org.example.demo.dao.db.ShowtimeAdminDAO;
import org.example.demo.dao.model.Showtime;

import java.sql.SQLException;
import java.util.List;

public class ShowtimeAdminService {
    private ShowtimeAdminDAO showtimeDAO;

    public ShowtimeAdminService(ShowtimeAdminDAO showtimeDAO) {
        this.showtimeDAO = showtimeDAO;
    }

    // Lấy tất cả lịch chiếu
    public List<Showtime> getAllShowtimes() throws SQLException {
        return showtimeDAO.getAllShowtimes();
    }

    // Thêm lịch chiếu mới
    public boolean addShowtime(Showtime showtime) throws SQLException {
        return showtimeDAO.addShowtime(showtime);
    }

    // Xóa lịch chiếu
    public boolean deleteShowtime(int id) throws SQLException {
        return showtimeDAO.deleteShowtime(id);
    }

    // Cập nhật lịch chiếu
    public boolean updateShowtime(Showtime showtime) throws SQLException {
        return showtimeDAO.updateShowtime(showtime);
    }
}

