package com.example.onionarchitecture.interfaces.repositories;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;
import com.example.onionarchitecture.interfaces.repositories.data.SollstundenRepository;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.YearMonth;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RepositoryServiceTest {

    @InjectMocks
    private RepositoryService uut;

    @Mock
    private SollstundenRepository sollstundenRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void employeeErstellen() {

        // Given
        Sollstunden sollstunden = Sollstunden.builder()
                .id(1L).beratername("Wetie").monat(YearMonth.parse("2023-03")).arbeitstage(23)
                .taeglicheArbeitsstunden(8.0).urlaubstage(0.0).sollstunden(184.0).schulungstage(0.0)
                .krankheitstage(0.0).sonstiges(0.0).build();

        BeraterSollStunden beraterSollStunden = BeraterSollStunden.builder()
                .id(1L).beratername("Wetie").monat(YearMonth.parse("2023-03")).arbeitstage(23)
                .taeglicheArbeitsstunden(8.0).urlaubstage(0.0).sollstunden(184.0).schulungstage(0.0)
                .krankheitstage(0.0).sonstiges(0.0).build();

        Mockito.when(sollstundenRepository.save(Mockito.any())).thenReturn(sollstunden);

        // When
        SollstundenDto sollstundenDto = DbMapper.mapBeraterSollstundenToSollstundenDto(beraterSollStunden);
        BeraterSollStunden beraterSollStunden1 = DbMapper.mapSollstundenDtoToBeraterSollstunden(sollstundenDto);
        BeraterSollStunden result= uut.erstellenSollstunden(beraterSollStunden1);

        // Then
        assertAll("Mocktest",
                () -> Assertions.assertThat(result.getBeratername()).isEqualToIgnoringCase("Wetie"),
                () -> Assertions.assertThat(result.getArbeitstage()).isEqualTo(23));
    }

    @Test
    void ladeEmployee() {
    }

    @Test
    void getEmployeeByEmployeeId() {
    }

    @Test
    void employeeLoeschen() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void findEmployee() {
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void erstellenSollstunden() {
    }

    @Test
    void deleteSollstunden() {
    }

    @Test
    void updateSollstunden() {
    }

    @Test
    void getListBeraterSollstunden() {
    }

    @Test
    void getBeraterSollstundenById() {

        // Given
        Long sollstundenId = 1L;

        Sollstunden sollstundenForMock = Sollstunden.builder()
                .id(1L).beratername("Nana").monat(YearMonth.parse("2023-03"))
                .arbeitstage(23).taeglicheArbeitsstunden(8.0).urlaubstage(0.0)
                .sollstunden(184.0).schulungstage(0.0).krankheitstage(0.0)
                .sonstiges(0.0).build();

        Mockito.when(sollstundenRepository.findById(sollstundenId)).thenReturn(Optional.of(sollstundenForMock));

        // When
        BeraterSollStunden result = uut.getBeraterSollstundenById(sollstundenId);

        // Then
        Mockito.verify(sollstundenRepository, Mockito.times(1)).findById(1L);

        assertEquals(result.getBeratername(), sollstundenForMock.getBeratername());
        assertEquals(sollstundenId, result.getId());
    }
}