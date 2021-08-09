package example.jdbc;

import example.jdbc.dao.RoleDao;

public class jdbcDeleteMain {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        int deleteCount = roleDao.deleteRole(2);
        System.out.println("deleteCount = " + deleteCount);
    }
}
