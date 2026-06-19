package br.com.ijuris.infrastructure.persistence.repository;

import br.com.ijuris.infrastructure.persistence.entity.AddressDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataAddressRepository extends JpaRepository<AddressDbEntity, UUID> {
}
