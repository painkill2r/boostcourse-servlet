package example.jdbc;

import example.jdbc.dao.RoleDao;
import example.jdbc.dto.Role;

public class jdbcInsertMain {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        Role role = new Role("ROLE_MANAGER");

        int insertCount = roleDao.addRole(role);

        System.out.println("insertCount = " + insertCount);
    }
}
