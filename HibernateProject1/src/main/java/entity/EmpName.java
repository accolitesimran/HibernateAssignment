package entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmpName {
	String fname;
	String mname;
	String lname;
}
