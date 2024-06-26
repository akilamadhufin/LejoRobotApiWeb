/*
 * package data;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Table;
 * import javax.persistence.Id;
 * 
 * @Entity
 * 
 * @Table(name = "robotdata") public class RobotData {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int Id; private
 * float currentintensity; private int currentspeedLeftMortor; private int
 * currentspeedRighttMortor;
 * 
 * public RobotData(int currentintensityvalue, int currentspeedLM, int
 * currentspeedRM) { super(); this.currentintensity = currentintensityvalue;
 * this.currentspeedLeftMortor = currentspeedLM; this.currentspeedRighttMortor =
 * currentspeedRM;
 * 
 * }
 * 
 * public RobotData() { super(); }
 * 
 * public int getId() { return Id; }
 * 
 * public void setId(int id) { Id = id; }
 * 
 * public float getCurrentintensity() { return currentintensity; }
 * 
 * public void setCurrentintensity(float currentintensity) {
 * this.currentintensity = currentintensity; }
 * 
 * public int getCurrentspeedLeftMortor() { return currentspeedLeftMortor; }
 * 
 * public void setCurrentspeedLeftMortor(int currentspeedLeftMortor) {
 * this.currentspeedLeftMortor = currentspeedLeftMortor; }
 * 
 * public int getCurrentspeedRighttMortor() { return currentspeedRighttMortor; }
 * 
 * public void setCurrentspeedRighttMortor(int currentspeedRighttMortor) {
 * this.currentspeedRighttMortor = currentspeedRighttMortor; }
 * 
 * @Override public String toString() { return "#" + Id + "#" + currentintensity
 * + "#" + currentspeedLeftMortor + "#" + currentspeedRighttMortor + "#"; }
 * 
 * 
 * }
 */

package data; // Replace with your actual package name

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import javax.persistence.Id;


@Entity
@Table(name = "robotdata")
public class RobotData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int currentIntensity;
    private int currentSpeedLeftMotor;
    private int currentSpeedRightMotor;
    private int currentSpeedLeftMotor1;
    private int currentSpeedRightMotor2;

    public RobotData(int currentIntensity, int currentSpeedLeftMotor, int currentSpeedRightMotor, int currentSpeedLeftMotorOne, int currentSpeedRightMotorTwo) 
    {
        this.currentIntensity = currentIntensity;
        this.currentSpeedLeftMotor = currentSpeedLeftMotor;
        this.currentSpeedRightMotor = currentSpeedRightMotor;
        this.currentSpeedLeftMotor1 = currentSpeedLeftMotorOne;
        this.currentSpeedRightMotor2 = currentSpeedRightMotorTwo;
    }

    public RobotData() {
        // Default constructor
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCurrentIntensity() {
        return currentIntensity;
    }

    public void setCurrentIntensity(int currentIntensity) {
        this.currentIntensity = currentIntensity;
    }

    public int getCurrentSpeedLeftMotor() 
    {
        return currentSpeedLeftMotor;
    }

    public void setCurrentSpeedLeftMotor(int currentSpeedLeftMotor) 
    {
        this.currentSpeedLeftMotor = currentSpeedLeftMotor;
    }

    public int getCurrentSpeedRightMotor() 
    {
        return currentSpeedRightMotor;
    }

    public void setCurrentSpeedRightMotor(int currentSpeedRightMotor) 
    {
        this.currentSpeedRightMotor = currentSpeedRightMotor;
    }
    

    // toString() method

    public int getCurrentSpeedLeftMotor1() {
		return currentSpeedLeftMotor1;
	}

	public void setCurrentSpeedLeftMotor1(int currentSpeedLeftMotor1) {
		this.currentSpeedLeftMotor1 = currentSpeedLeftMotor1;
	}

	public int getCurrentSpeedRightMotor2() {
		return currentSpeedRightMotor2;
	}

	public void setCurrentSpeedRightMotor2(int currentSpeedRightMotor2) {
		this.currentSpeedRightMotor2 = currentSpeedRightMotor2;
	}

	@Override
    public String toString() 
    {
        return "RobotData{" +
                "id=" + id +
                ", currentIntensity=" +currentIntensity +
                ", currentSpeedLeftMotor=" + currentSpeedLeftMotor +
                ", currentSpeedRightMotor=" + currentSpeedRightMotor +
                ", currentSpeedLeftMotor1=" + currentSpeedLeftMotor +
                ", currentSpeedRightMotor2=" + currentSpeedRightMotor +
                '}';
    }
}

