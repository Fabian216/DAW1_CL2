package pe.cibertec.cl02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cl02.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Eliminar rentals por film_id (lo que afecta el inventory_id relacionado con el film)
    @Modifying
    @Transactional
    @Query("DELETE FROM Rental r WHERE r.inventory.film IN (SELECT i.film FROM Inventory i WHERE i.film.filmId = :filmId)")
    void deleteByFilmId(Integer filmId);
}
