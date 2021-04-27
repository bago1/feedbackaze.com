package com.feedback.website.repos;

import com.feedback.website.entities.TargetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepo  extends JpaRepository<TargetEntity,Integer> {
}
