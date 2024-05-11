package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "obstacle") // Corrected table name
public class Obstacale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Changed variable name to lowercase

    private float obstacleDistance; // Corrected variable name

    // Constructor
    public Obstacale() {
    }

    // Constructor with parameters
    public Obstacale(int id, float obstacleDistance) {
        this.id = id;
        this.obstacleDistance = obstacleDistance;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getObstacleDistance() {
        return obstacleDistance;
    }

    public void setObstacleDistance(float obstacleDistance) {
        this.obstacleDistance = obstacleDistance;
    }

    // toString method
    @Override
    public String toString() {
        return "#" + id + "#" + obstacleDistance + "#";
    }
}
