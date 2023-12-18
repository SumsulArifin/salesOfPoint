package com.example.sysDevLtd.service;
import com.example.sysDevLtd.entity.request.DepartmentDTO;
import com.example.sysDevLtd.entity.model.salesOfPoint.Department;
import com.example.sysDevLtd.repository.DepartmentRepository;
import com.example.sysDevLtd.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        Department department1 = new Department();
        department1.setDepName(department.getDepName());
        return departmentRepository.save(department);

    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(int deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Override
    public Optional<Department> updateDepartment(int deptId, DepartmentDTO departmentDTO) {
        Optional<Department> result = departmentRepository.findById(deptId);

        if (result.isPresent()) {
            Department department = result.get();
            department.setDepName(departmentDTO.getDepName());
            departmentRepository.save(department);
        } else {
            throw new ResourceNotFoundException("Department", "deptId", deptId);
        }

        return result;
    }

    @Override
    public void deleteDepartmentById(int deptId) {
        departmentRepository.deleteById(deptId);

    }
}
