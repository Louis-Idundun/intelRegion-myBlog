package com.intelRegionProject.myBlog.services.implementations;

import com.intelRegionProject.myBlog.repositories.UserRepository;
import com.intelRegionProject.myBlog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImplementation implements UserService {
    private final UserRepository userRepository;
}
