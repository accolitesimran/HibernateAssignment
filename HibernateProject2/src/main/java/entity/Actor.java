package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;
	private String name;
	
	//assuming that a person can be a actor. So there would be a one to one mapping between actor and person.
	@OneToOne
    @JoinColumn(name = "personId")
    private Person person;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getPersonId() {
		return person;
	}
	public void setPersonId(Person person) {
		this.person= person;
	}
	public int getActorId() {
		return actorId;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + name + ", person=" + person + "]";
	}
	
	//An actor has multiple films and a film can have multiple actors in it.
	//So there would be a many to many mapping between film and actor.
	//If an actor is not there then that film should be dropped in the corresponding film entity.
	@ManyToMany 
	private List<Film> films=new ArrayList<Film>();
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
