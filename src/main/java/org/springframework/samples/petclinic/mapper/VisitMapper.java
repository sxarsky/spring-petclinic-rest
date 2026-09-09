package org.springframework.samples.petclinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.rest.dto.VisitDto;
import org.springframework.samples.petclinic.rest.dto.VisitFieldsDto;

import java.util.Collection;

/**
 * Map Visit & VisitDto using mapstruct
 */
@Mapper(uses = PetMapper.class)
public interface VisitMapper {
    @Mapping(source = "petId", target = "pet.id")
    Visit toVisit(VisitDto visitDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pet", ignore = true)
    Visit toVisit(VisitFieldsDto visitFieldsDto);

    /**
     * Copies every settable field of {@link VisitFieldsDto} onto an existing {@link Visit}; see
     * {@code OwnerMapper.updateOwnerFromFields} for why update handlers go through the mapper.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pet", ignore = true)
    void updateVisitFromFields(VisitFieldsDto visitFieldsDto, @MappingTarget Visit visit);

    @Mapping(source = "pet.id", target = "petId")
    VisitDto toVisitDto(Visit visit);

    Collection<VisitDto> toVisitsDto(Collection<Visit> visits);

}
