package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "currentspeed")
public class CurrentSpeed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int LeftMotorSpeed;
	private int RightMotorSpeed;
	
	
	public CurrentSpeed() {
		super();
	}
	public CurrentSpeed(int id, int leftMotorSpeed, int rightMotorSpeed) {
		super();
		Id = id;
		LeftMotorSpeed = leftMotorSpeed;
		RightMotorSpeed = rightMotorSpeed;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getLeftMotorSpeed() {
		return LeftMotorSpeed;
	}
	public void setLeftMotorSpeed(int leftMotorSpeed) {
		LeftMotorSpeed = leftMotorSpeed;
	}
	public int getRightMotorSpeed() {
		return RightMotorSpeed;
	}
	public void setRightMotorSpeed(int rightMotorSpeed) {
		RightMotorSpeed = rightMotorSpeed;
	}
	@Override
	public String toString() {
		return "CurrentSpeed [Id=" + Id + ", LeftMotorSpeed=" + LeftMotorSpeed + ", RightMotorSpeed=" + RightMotorSpeed
				+ "]";
	}

}