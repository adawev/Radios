package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AddressDto;
import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.model.Address;
import diyor.adawev.radios.model.Category;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    public List<Address> getAll() {
        return addressRepo.findAll();
    }
    public Address getById(Integer id) {
        return addressRepo.findById(id).get();
    }

    public Result create(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setZipcode(addressDto.getZipcode());
        address.setHomeNumber(addressDto.getHomeNumber());
        addressRepo.save(address);
        return new Result(true, "Address created");
    }
    public Result update(Integer id, AddressDto addressDto) {
        Optional<Address> byId = addressRepo.findById(id);
        if (byId.isPresent()) {
            Address address = byId.get();
            address.setCity(addressDto.getCity());
            address.setStreet(addressDto.getStreet());
            address.setZipcode(addressDto.getZipcode());
            address.setHomeNumber(addressDto.getHomeNumber());
            addressRepo.save(address);
            return new Result(true, "Address updated");
        }
        return new Result(true, "Address not found");
    }
    public Result delete(Integer id) {
        Optional<Address> byId = addressRepo.findById(id);
        if (byId.isPresent()) {
            addressRepo.delete(byId.get());
            return new Result(true, "Address deleted");
        }
        return new Result(true, "Address not found");
    }
}
