package data;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="runlego")
public class Runlego {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private int run;
	private java.sql.Timestamp time=new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	
	
	
	public Runlego() {
		super();
	}
	public Runlego(int id, int run, Timestamp time) {
		super();
		this.Id = id;
		this.run = run;
		this.time = time;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "#" + Id + "#" + run + "#" + time;
	}
	
	
	
	
	

}
