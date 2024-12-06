package pe.cibertec.cl02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.cl02.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
