package org.example.demo.dao;
import org.example.demo.controller.LoginController;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.MovieService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public User getUser(String username, String password) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE email = ? AND password = ?";
            ps = DbConnect.get(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                return user; // lấy cái đầu tiên
            }
            return null ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User createUser(String signupUserEmail, String signupUserName, String hashedPassword2Signup) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        if(checkEmail(signupUserEmail)){ // kiểm tra xem email đã đc su dụng chưa
            return null;
        }
        try {
            // Query để chèn người dùng mới vào bảng `users`
            String query = "INSERT INTO USERS (email, name, password, role, status) VALUES (?, ?, ?, ?, ?)";

            // Lấy PreparedStatement từ DbConnect
            ps = DbConnect.get(query);

            // Thiết lập tham số cho PreparedStatement
            ps.setString(1, signupUserEmail);
            ps.setString(2, signupUserName);
            ps.setString(3, hashedPassword2Signup); // mật khẩu đã mã hóa
            ps.setInt(4, 0);
            ps.setString(5, "active");

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return getUser(signupUserEmail, hashedPassword2Signup);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkEmail(String email) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM USERS WHERE email = ?";
        ps = DbConnect.get(query);
        try {
            ps.setString(1,email);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean changePass(String forgotpassUserEmail) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            // 1. Kiểm tra xem email có tồn tại trong cơ sở dữ liệu không
            String checkEmailQuery = "SELECT * FROM USERS WHERE email = ?";
            ps = DbConnect.get(checkEmailQuery);
            ps.setString(1, forgotpassUserEmail);
            resultSet = ps.executeQuery();

            // Kiểm tra nếu có kết quả (email tồn tại)
            if (resultSet.next()) {
                // 2. Nếu email tồn tại, cập nhật mật khẩu thành mật khẩu mới (12345)
                String updatePasswordQuery = "UPDATE USERS SET password = ? WHERE email = ?";
                ps = DbConnect.get(updatePasswordQuery);
                String pass = HashUtil.hashWithMD5("12345") ;
                ps.setString(1, pass);
                ps.setString(2, forgotpassUserEmail);

                int rowsAffected = ps.executeUpdate();

                // Nếu có ít nhất một dòng bị ảnh hưởng, trả về true
                if (rowsAffected > 0) {
                    return true; // Mật khẩu đã được cập nhật thành công
                } else {
                    return false; // Lỗi khi cập nhật mật khẩu
                }
            } else {
                return false; // Email không tồn tại
            }

        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            return false; // Lỗi xảy ra trong quá trình thực thi
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateName(String userId, String name) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
//            String checkEmailQuery = "SELECT * FROM USERS WHERE id = ?"; // cái tên để quên từ trên kia thôi >> lấy id user
//            ps = DbConnect.get(checkEmailQuery);
//            ps.setString(1, userId);
//            resultSet = ps.executeQuery();

//            if (resultSet.next()) {
                String updatePasswordQuery = "UPDATE USERS SET name = ? WHERE id = ?";
                ps = DbConnect.get(updatePasswordQuery);
                ps.setString(1, name);
                ps.setString(2, userId);
                ps.executeUpdate();
//            }
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateEmail(String userId, String email) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
//            String checkEmailQuery = "SELECT * FROM USERS WHERE id = ?";
//            ps = DbConnect.get(checkEmailQuery);
//            ps.setString(1, userId);
//            resultSet = ps.executeQuery();
//
//            if (resultSet.next()) {
                String updatePasswordQuery = "UPDATE USERS SET email = ? WHERE id = ?";
                ps = DbConnect.get(updatePasswordQuery);
                ps.setString(1, email);
                ps.setString(2, userId);

                ps.executeUpdate();
//            }

        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updatePhone(String userId, String phone) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
//            String checkEmailQuery = "SELECT * FROM USERS WHERE id = ?";
//            ps = DbConnect.get(checkEmailQuery);
//            ps.setString(1, userId);
//            resultSet = ps.executeQuery();

//            if (resultSet.next()) {
                String updatePasswordQuery = "UPDATE USERS SET phone = ? WHERE id = ?";
                ps = DbConnect.get(updatePasswordQuery);
                ps.setString(1, phone);
                ps.setString(2, userId);

                ps.executeUpdate();

//            }

        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateDob(String userId, String dob) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // Chuyển đổi chuỗi dob thành java.util.Date
            java.util.Date utilDate = sdf.parse(dob);
            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            String checkEmailQuery = "SELECT * FROM USERS WHERE id = ?";
//            ps = DbConnect.get(checkEmailQuery);
//            ps.setString(1, userId);
//            resultSet = ps.executeQuery();

//            if (resultSet.next()) {
                String updatePasswordQuery = "UPDATE USERS SET dob = ? WHERE id = ?";
                ps = DbConnect.get(updatePasswordQuery);
                ps.setDate(1, sqlDate);
                ps.setString(2, userId);

                ps.executeUpdate();

//            }

        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public User getUserById(String userId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE id = ?";
            ps = DbConnect.get(query);
            ps.setString(1, userId);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                return user; // lấy cái đầu tiên
            }
            return null ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS";
            ps = DbConnect.get(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) { // Lặp qua tất cả các kết quả trong ResultSet
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void blockCustomer(int idStatusBlock) {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE USERS SET status = ? WHERE id = ?";
            ps = DbConnect.get(query);
            ps.setString(1, "inactive");
            ps.setInt(2, idStatusBlock);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void unBlockCustomer(int idStatusUnblock) {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE USERS SET status = ? WHERE id = ?";
            ps = DbConnect.get(query);
            ps.setString(1, "active");
            ps.setInt(2, idStatusUnblock);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delCustomer(int idUserdel) {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM USERS WHERE id = ?";
            ps = DbConnect.get(query);
            ps.setInt(1, idUserdel);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getCustomerByEmail(String queryCus) {
        List<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE email LIKE ?" ;
            ps = DbConnect.get(query);
            ps.setString(1, "%"+queryCus+"%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                list.add(user);
            }
            return list ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getCustomerByName(String queryCus) {
        List<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE name LIKE  ?" ;
            ps = DbConnect.get(query);
            ps.setString(1, "%"+queryCus+"%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                list.add(user);
            }
            return list ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getCustomerByPhone(String queryCus) {
        List<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE phone LIKE  ?" ;
            ps = DbConnect.get(query);
            ps.setString(1, "%"+queryCus+"%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                list.add(user);
            }
            return list ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public static void main(String[] args) {
//        UserDao dao = new UserDao();
//        String p = "Dung12345";
//        String pmd5 = HashUtil.hashWithMD5(p);
//        User user = dao.getUser("phamthidung@gmail.com", pmd5);
//        if (user != null) {
//            System.out.println("User found: " + user);
//            System.out.println("User found: " + user.getEmail());
//            System.out.println("User found: " + user.getPassword());
//        } else {
//            System.out.println("User not found.");
//        }
//
//    }


}