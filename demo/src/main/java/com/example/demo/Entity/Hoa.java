package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tenhoa;
    @Column
    private String mota;
    @Column
    private double giaban;
    @Column
    private String hinhanh;
    @Column
    private String category;

    
}
