package com.clinic.service.doctor;

import com.clinic.model.Doctor;
import com.clinic.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorService implements IDoctorService {
	
	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public Iterable<Doctor> findAll () {
		return doctorRepository.findAll ();
	}
	
	@Override
	public Optional<Doctor> findById (Long id) {
		return doctorRepository.findById (id);
	}
	
	@Override
	public Doctor save (Doctor doctor) {
		return doctorRepository.save (doctor);
	}
	
	@Override
	public void remove (Long id) {
	     doctorRepository.deleteById (id);
	}
}
