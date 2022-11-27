package net.com.springboot.repository;

import net.com.springboot.entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaEventDataRepository extends JpaRepository<WikiMediaData,Long> {

}
