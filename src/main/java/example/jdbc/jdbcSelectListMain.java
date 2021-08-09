package example.jdbc;

import example.jdbc.dao.RoleDao;
import example.jdbc.dto.Role;

import java.util.List;

public class jdbcSelectListMain {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        List<Role> list = roleDao.getRoles();

        for (Role role : list) {
            System.out.println("role = " + role);
        }
    }
}
