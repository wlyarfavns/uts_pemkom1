/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableRowSorter;

public class produk {
 

public class SearchExample extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public SearchExample() {
        setTitle("Search Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Data model untuk JTable
        String[] columnNames = {"ID User", "Username", "Password", "Role"};
        Object[][] data = {
            {"1", "JohnDoe", "1234", "Admin"},
            {"2", "JaneSmith", "5678", "User"},
            {"3", "MikeJones", "9101", "User"},
            // Tambahkan data lain sesuai kebutuhan
        };
        
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // JScrollPane untuk table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 60, 550, 200);
        add(scrollPane);

        // Field dan button untuk search
        searchField = new JTextField();
        searchField.setBounds(20, 20, 200, 25);
        add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(230, 20, 100, 25);
        add(searchButton);

        // ActionListener untuk tombol search
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText().trim();
                searchTable(keyword);
            }
        });
    }

    // Metode untuk mencari data dalam tabel
    private void searchTable(String keyword) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        if (keyword.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, 1)); // Kolom 1 adalah kolom "Username"
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            SearchExample frame = new SearchExample();
//            frame.setVisible(true);
        });
    }
}

}
