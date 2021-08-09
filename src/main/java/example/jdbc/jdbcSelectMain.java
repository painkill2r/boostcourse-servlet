package example.jdbc;

import example.jdbc.dao.RoleDao;
import example.jdbc.dto.Role;

public class jdbcSelectMain {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        Role role = roleDao.getRole(1);
        System.out.println("role = " + role);
    }
}
