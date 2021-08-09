package example.jdbc;

import example.jdbc.dao.RoleDao;
import example.jdbc.dto.Role;

public class jdbcUpdateMain {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        Role role = new Role(2, "ROLE_USER");
        int updateCount = roleDao.updateRole(role);
        System.out.println("updateCount = " + updateCount);
    }
}
