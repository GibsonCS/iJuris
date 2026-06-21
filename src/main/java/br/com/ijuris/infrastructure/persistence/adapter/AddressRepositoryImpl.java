package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.core.domain.entity.Address;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.infrastructure.persistence.entity.AddressDbEntity;
import br.com.ijuris.infrastructure.persistence.entity.UserDbEntity;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataAddressRepository;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final SpringDataAddressRepository springDataAddressRepository;
    private final SpringDataUserRepository springDataUserRepository;

    public AddressRepositoryImpl(SpringDataAddressRepository springDataAddressRepository, SpringDataUserRepository springDataUserRepository) {
        this.springDataAddressRepository = springDataAddressRepository;
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public void save(Address address) {

        AddressDbEntity addressDbEntity = new AddressDbEntity(address.getCep().cep(), address.getState(), address.getCity(),
                address.getNeighborhood(), address.getNumber(), address.getComplement(), address.getStreet());

        addressDbEntity.setId(address.getId());

      Optional<UserDbEntity> userDbEntity = springDataUserRepository.findById(address.getUserId());

      if(userDbEntity.isEmpty()){
          throw new RuntimeException("usuário inexistente");
      }

        addressDbEntity.setUserDbEntity(userDbEntity.get());

        springDataAddressRepository.save(addressDbEntity);
    }

}
