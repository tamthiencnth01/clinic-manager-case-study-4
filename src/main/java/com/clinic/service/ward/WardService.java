package com.clinic.service.ward;

import com.clinic.model.Ward;
import com.clinic.repository.IWardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WardService implements IWardService{
    @Autowired
    private IWardRepository wardRepository;

    @Override
    public Iterable<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public Optional<Ward> findById(Long id) {
        return wardRepository.findById(id);
    }

    @Override
    public Ward save(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public void remove(Long id) {
        wardRepository.deleteById(id);
    }
}
