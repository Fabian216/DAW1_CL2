package pe.cibertec.cl02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.cibertec.cl02.entity.Film;
import pe.cibertec.cl02.repository.FilmRepository;

import java.util.Optional;

@SpringBootApplication
public class Cl02Application implements CommandLineRunner {

	@Autowired
	FilmRepository filmRepo;

	public static void main(String[] args) {
		SpringApplication.run(Cl02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-----------------------------------------------------");
		System.out.println("findAll() - 1ra llamada LISTANDO");
		System.out.println("-----------------------------------------------------");
		Iterable<Film> iterable = filmRepo.findAll();
		iterable.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
		});

		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("findAll() - 2da llamada CACHE");
		System.out.println("-----------------------------------------------------");
		Iterable<Film> iterable2 = filmRepo.findAll();
		iterable2.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
		});

		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("save() - 3ra llamada ACTUALIZANDO");
		System.out.println("-----------------------------------------------------");
		Optional<Film> optional = filmRepo.findById(10);
		optional.ifPresentOrElse(
				(film) -> {
					film.setTitle("ALADIN LO MAXIMOOOO");
					filmRepo.save(film);
				},
				() -> {
					System.out.println("Film not found");
				}
		);

		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("findAll() - 4ta llamada a MySQL");
		System.out.println("-----------------------------------------------------");
		Iterable<Film> iterable3 = filmRepo.findAll();
		iterable3.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
		});

		/*System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("deleteByFilmId() - Eliminar registro con ID 1001");
		System.out.println("-----------------------------------------------------");
		filmRepo.deleteByFilmId(1001);*/

		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("findAll() - Verificar caché tras la eliminación");
		System.out.println("-----------------------------------------------------");
		Iterable<Film> iterable4 = filmRepo.findAll();
		iterable4.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
		});



	}

}
