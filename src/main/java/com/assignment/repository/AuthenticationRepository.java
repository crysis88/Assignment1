package com.assignment.repository;

import com.assignment.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class AuthenticationRepository {

    public User verifyUserDetails(String username, String password) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession()) {
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("username", username);
            paramMap.put("password", password);
            return session.selectOne("token.selectUser", paramMap);
        } finally {
        }
    }

    public void storeToken(int id, String token) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession(true)) {
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("user_id", id);
            paramMap.put("token", token);
            session.insert("token.addToken", paramMap);
        } finally {
        }
    }


    public boolean verifyToken(String token) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession()) {
            int count = session.selectOne("token.verifyToken", token);
            if (count == 0) {
                return false;
            } else {
                return true;
            }
        } finally {
        }
    }

}
