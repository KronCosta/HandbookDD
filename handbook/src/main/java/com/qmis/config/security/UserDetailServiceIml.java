package com.qmis.config.security;

import com.qmis.dao.EmployeeRepository;
import com.qmis.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceIml implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String eMail) {
        Employee employee = employeeRepository.findByEMail(eMail).orElseThrow(() ->
                new UsernameNotFoundException("Employee doesn't not exist"));
        return SecurityUser.fromEmployee(employee);
    }

}
