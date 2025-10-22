package com.babull.infra.adapter.out.persistence.springdata;

import com.babull.infra.adapter.out.persistence.entity.CuentaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaJpaRepository extends JpaRepository<CuentaJpaEntity, Long> {

    // Spring Data genera todo: findById, save, etc.
}
