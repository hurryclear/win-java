//package com.concurrency;
//
//
//import com.collection.dao.UserDao;
//import com.collection.dao.impl.UserDaoImpl;
//import com.collection.service.UserService;
//import com.collection.service.impl.UserServiceImpl;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ThreadSecurityExample1 {
//
//    public static void main(String[] args) {
//        System.out.println("1");
//    }
//}
//
//public class MyServlet extends HttpServlet {
//    // safe? yes
//    private UserService userService = new UserServiceImpl();
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        userService.update();
//    }
//}
//
//public class UserServiceImpl implements UserService {
//    // safe? yes
//    private UserDao userDao = new UserDaoImpl();
//    public void update () {
//        userDao.update();
//    }
//}
//
//public class UserDaoImpl implements UserDao {
//    public void update() {
//        String sql = "update user set password = ? where username = ?";
//        // safe? yes
//        try (Connection connection = DriverManager.getConnection("", "", "")) {
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
