package pe.cibertec.cl02.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cl02.entity.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Modifying
    @Transactional
    @CacheEvict(value = "films", allEntries = true) // Limpia toda la caché de 'films' tras la eliminación
    @Query("DELETE FROM Film f WHERE f.filmId = :filmId")
    void deleteByFilmId(Integer filmId);

    @Cacheable(value = "films")
    List<Film> findAll();

    @CacheEvict(value = "films", allEntries = true)
    Film save(Film film);


}
