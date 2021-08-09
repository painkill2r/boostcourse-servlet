package example.jdbc.dao;

import example.jdbc.dto.Role;

//1. import java.sql.*
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    private final static String DB_URL = "jdbc:mysql://1.215.95.162:3306/developer";
    private final static String DB_USER = "developer";
    private final static String DB_PASSWD = "dev123~";

    /**
     * ROLE 목록 조회
     * try with resource 문법 사용
     *
     * @return
     */
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT description, role_id FROM boost_role WHERE 1 = 1 ORDER BY role_id ASC";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Role role = new Role(rs.getInt("role_id"), rs.getString("description"));
                    list.add(role);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * ROLE 조회
     *
     * @param roleId
     * @return
     */
    public Role getRole(Integer roleId) {
        Role role = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); //2. 메모리에 MySQL Driver 로드
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD); //3. Connection 객체 생성
            String sql = "SELECT description, role_id FROM boost_role WHERE 1 = 1 AND role_id = ?";
            pstmt = conn.prepareStatement(sql); //4. Statement 객체 생성
            pstmt.setInt(1, roleId);
            rs = pstmt.executeQuery(); //5. SQL Query 실행, ResultSet 객체 생성

            if (rs.next()) {
                String description = rs.getString(1);
                Integer id = rs.getInt("role_id");

                role = new Role(id, description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6. JDBC에 사용된 모든 객체를 닫음
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

        return role;
    }

    /**
     * ROLE 추가
     *
     * @param role
     * @return
     */
    public int addRole(Role role) {
        int insertCount = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            String sql = "INSERT INTO boost_role (description) VALUES (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, role.getDescription());
            insertCount = pstmt.executeUpdate(); //SELECT에서는 executeQuery()를 사용했지만, INSERT/UPDATE/DELETE에서는 executeUpdate()를 사용한다.
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return insertCount;
    }

    /**
     * ROLE 삭제
     *
     * @param roleId
     * @return
     */
    public int deleteRole(Integer roleId) {
        int deleteCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM boost_role WHERE 1 = 1 AND role_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roleId);
            deleteCount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleteCount;
    }

    /**
     * ROLE 수정
     *
     * @param role
     * @return
     */
    public int updateRole(Role role) {
        int updateCount = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            String sql = "UPDATE boost_role SET description = ? WHERE 1 = 1 AND role_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, role.getDescription());
            pstmt.setInt(2, role.getRoleId());
            updateCount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return updateCount;
    }
}
