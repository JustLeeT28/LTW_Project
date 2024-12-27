package org.example.demo.controller;

import org.example.demo.model.Movies;
import org.example.demo.service.MoviesService;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.db.MoviesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/movies")
public class MoviesServlet extends HttpServlet {
    private MoviesService movieService;

    @Override
    public void init() throws ServletException {
        movieService = new MoviesService(new MoviesDAO(DbConnect.getConnection()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listMovies(request, response);
            } else {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteMovie(request, response);
                        break;
                    default:
                        listMovies(request, response);
                        break;
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listMovies(request, response);
            } else {
                switch (action) {
                    case "insert":
                        insertMovie(request, response);
                        break;
                    case "update":
                        updateMovie(request, response);
                        break;
                    default:
                        listMovies(request, response);
                        break;
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listMovies(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Movies> moviesList = movieService.getAllMovies();
        request.setAttribute("movies", moviesList);
        request.getRequestDispatcher("/admin/movie_management.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/admin/movie_form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movies existingMovie = movieService.getMovieById(id);
        request.setAttribute("movie", existingMovie);
        request.getRequestDispatcher("/admin/movie_form.jsp").forward(request, response);
    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Movies newMovie = extractMovieFromRequest(request);
        movieService.addMovie(newMovie);
        response.sendRedirect("movies");
    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Movies updatedMovie = extractMovieFromRequest(request);
        updatedMovie.setId(Integer.parseInt(request.getParameter("id")));
        movieService.updateMovie(updatedMovie);
        response.sendRedirect("movies");
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        movieService.deleteMovie(id);
        response.sendRedirect("movies");
    }

    private Movies extractMovieFromRequest(HttpServletRequest request) {
        return new Movies(
                request.getParameter("posterUrl"),
                request.getParameter("bannerUrl"),
                request.getParameter("endDate"),
                request.getParameter("releaseDate"),
                request.getParameter("ageRating"),
                request.getParameter("genre"),
                request.getParameter("description"),
                request.getParameter("actors"),
                Integer.parseInt(request.getParameter("duration")),
                request.getParameter("director"),
                request.getParameter("title"),
                0 // ID sẽ được gán khi cập nhật
        );
    }
}
