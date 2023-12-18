package com.example.sysDevLtd.service;
import com.example.sysDevLtd.entity.request.DepartmentDTO;
import com.example.sysDevLtd.entity.model.salesOfPoint.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department findDepartmentById(int deptId);
    public Optional<Department> updateDepartment(int deptId, DepartmentDTO departmentDTO);
    public void deleteDepartmentById(int deptId);



}
