package com.university.departament_managment.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department_bilous")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "classroom", nullable = false, length = 10)
    private String classroom;

    @ManyToMany(mappedBy = "departments")
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<DepartmentNews> news = new ArrayList<>();
}
