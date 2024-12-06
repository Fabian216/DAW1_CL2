package pe.cibertec.cl02.dto;

public record FilmCreateDto(
        String title,
        String description,
        Integer releaseYear,
        Integer languageId,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures) {
}
