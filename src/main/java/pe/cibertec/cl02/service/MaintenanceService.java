package pe.cibertec.cl02.service;

import pe.cibertec.cl02.dto.FilmCreateDto;
import pe.cibertec.cl02.dto.FilmDetailDto;
import pe.cibertec.cl02.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(int filmId);

    Boolean createFilm(FilmCreateDto filmCreateDto);
}
