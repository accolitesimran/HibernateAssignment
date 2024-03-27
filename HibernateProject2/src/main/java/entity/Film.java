package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;  

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long filmId;
	@Column(name="film title")
	private String filmTitle;
	private String filmReleaseDate;
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	public String getFilmReleaseDate() {
		return filmReleaseDate;
	}
	public void setFilmReleaseDate(String filmReleaseDate) {
		this.filmReleaseDate = filmReleaseDate;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", filmTitle=" + filmTitle + ", filmReleaseDate=" + filmReleaseDate
				+  ", actors=" + actors + "]";
	}
	//assuming that one film belongs to a single category and a category can have multiple films
	@ManyToOne
    @JoinColumn
    private FilmCategory category;
	
	public FilmCategory getCategory() {
		return category;
	}
	public void setCategory(FilmCategory category) {
		this.category = category;
	}
	
	@ManyToMany(mappedBy="films")
    private List<Actor> actors=new ArrayList<Actor>();
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	

	
	
}
