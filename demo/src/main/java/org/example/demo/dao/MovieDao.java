package org.example.demo.dao;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    public List<Movie> getMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies " +
                    "WHERE status = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setString(1, "active");
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getMoviesA_Z() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies " +
                    "ORDER BY title ASC";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> showingMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // Query lấy phim đang chiếu (dựa vào releaseDate và endDate)
            String query = "SELECT * FROM movies WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE";
            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery(); // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies; // Trả về danh sách phim đang chiếu

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return new ArrayList<>(); // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> incomingMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // Query lấy phim đang chiếu (dựa vào releaseDate và endDate)
            String query = " SELECT * FROM movies WHERE releaseDate > CURRENT_DATE ";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery(); // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies; // Trả về danh sách phim đang chiếu

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return new ArrayList<>(); // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public Movie getMovieById(int id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies WHERE id = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            ps.setInt(1, id);  // Set tham số cho PreparedStatement

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            if (resultSet.next()) {
                return new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status"),
                        resultSet.getString("trailerUrl")
                );
            }

            return null;  // Trả về null nếu không tìm thấy phim

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi
            return null;  // Trả về null khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getGenreMovies(String idGenre) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies m " +
                    "JOIN movie_genres mg ON mg.movieId = m.id  " +
                    "JOIN genres g ON mg.genreId = g.id " +
                    "WHERE g.id = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, Integer.parseInt(idGenre));
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Genre> getGenres() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM genres";
            ps = DbConnect.get(query);
            resultSet = ps.executeQuery();  // Thực thi truy vấn
            List<Genre> genres = new ArrayList<>();
            while (resultSet.next()) {
                Genre g = new Genre(
                        resultSet.getInt("id"),
                        resultSet.getString("genre")
                );
                genres.add(g);
            }
            return genres;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getConditionMovie(String condition){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "";
        try {
            if(condition.equalsIgnoreCase("hot")){
                query = "SELECT m.*, COUNT(st_s.id) as total_booked_seat " +
                        "FROM movies m " +
                        "LEFT JOIN showtimes st ON m.id = st.movieId " +
                        "LEFT JOIN showtime_seats st_s ON st.id = st_s.showTimeId AND st_s.status = 'booked' " +
                        "GROUP BY m.id " +
                        "ORDER BY total_booked_seat DESC";
            }
            if(condition.equalsIgnoreCase("new")){
                query = "SELECT * " +
                        "FROM movies " +
                        "WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE "+
                        "ORDER BY releaseDate DESC" ;
            }
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getGenAndConMovie(String condition,String genre){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "";
        try {
            if(condition.equalsIgnoreCase("hot")){
                query = "SELECT m.*, COUNT(st_s.id) as total_booked_seat " +
                        "FROM movies m " +
                        "LEFT JOIN showtimes st ON m.id = st.movieId " +
                        "LEFT JOIN showtime_seats st_s ON st.id = st_s.showTimeId AND st_s.status = 'booked' " +
                        "JOIN movie_genres mg ON mg.movieId = m.id  " +
                        "JOIN genres g ON mg.genreId = g.id " +
                        "WHERE g.id = ? "+
                        "GROUP BY m.id " +
                        "ORDER BY total_booked_seat DESC";
            }
            if(condition.equalsIgnoreCase("new")){
                query = "SELECT * " +
                        "FROM movies " +
                        "WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE "+
                        "JOIN movie_genres mg ON mg.movieId = m.id  " +
                        "JOIN genres g ON mg.genreId = g.id " +
                        "WHERE g.id = ? " +
                        "ORDER BY releaseDate DESC" ;
            }
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, Integer.parseInt(genre));
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getMoviesByName(String nameMovie) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies " +
                    "WHERE title LIKE ? ";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setString(1, "%" + nameMovie + "%");
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getMoviesByNGC(String nameMovie, String genre, String condition) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "";
        try {
            if(condition.equalsIgnoreCase("hot")){
                query = "SELECT m.*, COUNT(st_s.id) as total_booked_seat " +
                        "FROM movies m " +
                        "LEFT JOIN showtimes st ON m.id = st.movieId " +
                        "LEFT JOIN showtime_seats st_s ON st.id = st_s.showTimeId AND st_s.status = 'booked' " +
                        "JOIN movie_genres mg ON mg.movieId = m.id  " +
                        "JOIN genres g ON mg.genreId = g.id " +
                        "WHERE g.id = ? AND m.title Like ? "+
                        "GROUP BY m.id " +
                        "ORDER BY total_booked_seat DESC";
            }
            if(condition.equalsIgnoreCase("new")){
                query = "SELECT * " +
                        "FROM movies " +
                        "WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE "+
                        "JOIN movie_genres mg ON mg.movieId = m.id  " +
                        "JOIN genres g ON mg.genreId = g.id " +
                        "WHERE g.id = ? AND m.title Like ? " +
                        "ORDER BY releaseDate DESC" ;
            }
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, Integer.parseInt(genre));
            ps.setString(2, "%" + nameMovie + "%");
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getMovieNow() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies " +
                    "WHERE releaseDate < CURRENT_DATE AND endDate >= CURRENT_DATE ";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<Movie> getMovieFuture() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies " +
                    "WHERE releaseDate > CURRENT_DATE";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }
//    public static void main(String[] args) {
//        List<Movie> movies = new ArrayList<>();
//        MovieDao movieDao = new MovieDao();
////        movies = movieDao.getMovieNow();
////        movies = movieDao.getMovieFuture();
//        for (Movie movie : movies) {
//            System.out.println(movie.getTitle());
//        }
//    }

    public List<Movie> getMovieByActor(String actor) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies m " +
                    "JOIN movie_actors m_a ON m_a.movieId = m.id " +
                    "JOIN actors a ON a.id = m_a.actorId " +
                    "WHERE a.name LIKE ? ";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setString(1, "%" + actor + "%");
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }


    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        MovieDao movieDao = new MovieDao();
        movies = movieDao.getMovieByDIR("Anil Sharma");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }

    public List<Movie> getMovieByDIR(String director) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies m " +
                    "JOIN movie_directors m_d ON m_d.movieId = m.id " +
                    "JOIN directors d ON d.id = m_d.directorId " +
                    "WHERE d.name LIKE ? ";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setString(1, "%" + director + "%");
            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }
}

