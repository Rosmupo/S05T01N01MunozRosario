package cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class SucursalService {
    @Autowired
    SucursalRepository sucursalRepository;

    public SucursalDTO add(SucursalDTO sucursalDTO){

        Sucursal sucursal = dtoToSucursal(sucursalDTO);

        sucursal =  sucursalRepository.save(sucursal);

        sucursalDTO = sucursalToDTO(sucursal);

        return sucursalDTO;
    }

    public SucursalDTO update(SucursalDTO sucursalDTO){

        Sucursal sucursal = dtoToSucursal(sucursalDTO);

        sucursal = sucursalRepository.save(sucursal);

        return sucursalToDTO(sucursal);

    }

    public boolean delete(long id){
        try{sucursalRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public SucursalDTO getOne(long id){

        Sucursal sucursal = sucursalRepository.findById(id).get();

        if(sucursal == null){return null;}

        return sucursalToDTO(sucursal);
    }




    public ArrayList<SucursalDTO> getAll(){
        ArrayList<Sucursal> list = (ArrayList<Sucursal>) sucursalRepository.findAll();
        ArrayList<SucursalDTO> listDTO = new ArrayList<SucursalDTO>();
        for(Sucursal item: list){
            listDTO.add(sucursalToDTO(item));
        }
        return listDTO;
    }

    private SucursalDTO sucursalToDTO(Sucursal sucursal){

        SucursalDTO sucursalDTO = new SucursalDTO();

        sucursalDTO.setId(sucursal.getId());
        sucursalDTO.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipoSucursal(sucursal.getPaisSucursal());

        return sucursalDTO;
    }

    private Sucursal dtoToSucursal(SucursalDTO sucursalDTO){

        Sucursal sucursal = new Sucursal();

        sucursal.setId(sucursalDTO.getId());
        sucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());

        return sucursal;
    }
}

