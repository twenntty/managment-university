package com.university.departament_managment.Services;

import com.university.departament_managment.Models.Department;
import com.university.departament_managment.Models.Subject;
import com.university.departament_managment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final SubjectService subjectService;

    private final List<Department> departments = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private long ID = 0;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }



    public DepartmentService(@Autowired SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id) {
        departments.removeIf(department -> department.getId().equals(id));
    }

    public void addSubjectsToDepartment(Long departmentId, List<Long> subjectIds) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Subject> departmentSubjects = department.getSubjects();

            subjects = subjectService.listSubjects();

            subjectIds.forEach(id -> subjects.stream()
                    .filter(subject -> subject.getId().equals(id))
                    .filter(subject -> !department.getSubjects().contains(subject))
                    .findFirst()
                    .ifPresent(departmentSubjects::add));
        }
    }

}
