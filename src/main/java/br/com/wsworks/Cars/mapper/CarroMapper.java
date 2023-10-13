package br.com.wsworks.Cars.mapper;

import br.com.wsworks.Cars.dto.CarroRequestDTO;
import br.com.wsworks.Cars.dto.CarroResponseDTO;
import br.com.wsworks.Cars.entity.CarroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarroMapper {

    public static final CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);

    @Mapping(target = "ano", source = "modelo.id")
    public abstract CarroResponseDTO toDTO(CarroEntity carro);

    @Mapping(target = "modelo.id", source = "modeloId")
    public abstract CarroEntity toEntity(CarroEntity carroRequestDTO);

    @Mapping(target = "nome", source = "nome")
    public abstract CarroEntity updateFromDTO (CarroRequestDTO carroRequestDTO, CarroEntity carroExistente);
}
