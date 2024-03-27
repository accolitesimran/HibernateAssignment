package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FilmCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "FilmCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", films=" + films + "]";
	}
	@OneToMany(mappedBy="category")
    private List<Film> films=new ArrayList<Film>();
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	

}
