package ru.slorimer.spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.slorimer.spring.model.User;

import java.util.List;

@Component
public class userDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public userDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> index(){
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(User.class));
    }
    public User show(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }
    public void save(User user){
        jdbcTemplate.update("INSERT INTO person(name, age, email) VALUES(?, ?, ?)", user.getName(),
        user.getAge(), user.getEmail());
    }
    public void edit(int id, User newUser){
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                newUser.getName(), newUser.getAge(), newUser.getEmail(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
