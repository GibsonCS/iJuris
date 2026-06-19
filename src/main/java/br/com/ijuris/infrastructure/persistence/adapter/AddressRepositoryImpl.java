package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.core.domain.entity.Address;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataAddressRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final SpringDataAddressRepository springDataAddressRepository;

    public AddressRepositoryImpl(SpringDataAddressRepository springDataAddressRepository) {
        this.springDataAddressRepository = springDataAddressRepository;
    }

    @Override
    public void save(Address address) {

    }
}
