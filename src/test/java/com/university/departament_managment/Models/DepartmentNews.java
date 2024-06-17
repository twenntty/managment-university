package com.university.departament_managment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "department_news_bilous")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;
}
