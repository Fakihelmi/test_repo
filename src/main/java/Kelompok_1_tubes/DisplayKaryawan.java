package Kelompok_1_tubes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DisplayKaryawan {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            displayKaryawanData(conn);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayKaryawanData(Connection conn) throws SQLException {
        String query = "SELECT * FROM Karyawan ";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Print header
            System.out.println("\n=== Data Karyawan ===");
            System.out.printf("%-5s %-15s %-15s %-15s %-15s%n",
                    "id_karyawan", "Nama", "Jabatan", "Gaji", "Tanggal Masuk");
            System.out.println("=".repeat(70));

            // Print each row
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-15s Rp %-12.2f %-15s%n",
                        rs.getInt("id_karyawan"),
                        rs.getString("nama"),
                        rs.getString("jabatan"),
                        rs.getDouble("gaji"),
                        rs.getDate("tanggal_masuk")
                );
            }
            System.out.println("=".repeat(70));
        }
    }
}