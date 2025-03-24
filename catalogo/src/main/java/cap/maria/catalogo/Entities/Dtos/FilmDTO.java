package cap.maria.catalogo.Entities.Dtos;

import java.math.BigDecimal;
import java.util.Optional;

import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private int filmId;
    private String title;
    private int languageId;
    private int rentalDuration;
    private BigDecimal rentalRate;
    private BigDecimal cost;

    public static FilmDTO from(Film source) {
        return new FilmDTO(
            source.getFilmId(),
            source.getTitle(),
            Optional.ofNullable(source.getLanguage()).map(Language::getLanguageId).orElse(0),
            source.getRentalDuration(),
            source.getRentalRate(),
            source.getReplacementCost()
        );
    }

    public static Film from(FilmDTO dto){
        Film film = new Film();
        film.setFilmId(dto.getFilmId());
        film.setTitle(dto.getTitle());
        film.setRentalDuration((byte) dto.getRentalDuration());
        film.setRentalRate(dto.getRentalRate());
        film.setReplacementCost(dto.getCost());

        Language language = new Language();
        language.setLanguageId(dto.getLanguageId());
        film.setLanguage(language);

        return film;
    }

}
