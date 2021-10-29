package com.noob.coder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noob.coder.dto.HomeDto;

public interface PreferencesRepository extends JpaRepository<HomeDto, Long> {

	HomeDto findByUserId(Long userId);

}
