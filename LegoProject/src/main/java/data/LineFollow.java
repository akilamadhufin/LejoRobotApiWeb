//package data;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;
//import javax.persistence.Id;
//
//@Entity
//@Table(name = "linefollow")
//public class LineFollow {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int Id;
//    private int targetIntensity;
//    private int LeftMotorSpeed;
//    private int RightMotorSpeed;
//
//    public LineFollow(int leftMotorSpeed, int rightMotorSpeed) {
//        super();
//        LeftMotorSpeed = leftMotorSpeed;
//        RightMotorSpeed = rightMotorSpeed;
//    }
//
//    public LineFollow() {
//        super();
//    }
//
//    public LineFollow(int id, int targetIntensity, int leftMotorSpeed, int rightMotorSpeed) {
//        super();
//        this.Id = id;
//        this.targetIntensity = targetIntensity;
//        this.LeftMotorSpeed = leftMotorSpeed;
//        this.RightMotorSpeed = rightMotorSpeed;
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        this.Id = id;
//    }
//
//    public int getTargetIntensity() {
//        return targetIntensity;
//    }
//
//    public void setTargetIntensity(int targetIntensity) {
//        this.targetIntensity = targetIntensity;
//    }
//
//    public int getLeftMotorSpeed() {
//        return LeftMotorSpeed;
//    }
//
//    public void setLeftMotorSpeed(int leftMotorSpeed) {
//        LeftMotorSpeed = leftMotorSpeed;
//    }
//
//    public int getRightMotorSpeed() {
//        return RightMotorSpeed;
//    }
//
//    public void setRightMotorSpeed(int rightMotorSpeed) {
//        RightMotorSpeed = rightMotorSpeed;
//    }
//
//    @Override
//    public String toString() {
//        return "#" + Id + "#" + targetIntensity + "#" + LeftMotorSpeed + "#" + RightMotorSpeed + "#";
//    }
//
//}


package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "linefollow")
public class LineFollow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int LeftMotorSpeed_1;
    private int RightMotorSpeed_1;
    private int LeftMotorSpeed_2;
    private int RightMotorSpeed_2;
    private int targetIntensity;

    public LineFollow(int leftMotorSpeed_1, int rightMotorSpeed_1, int leftMotorSpeed_2, int rightMotorSpeed_2) {
        super();
        LeftMotorSpeed_1 = leftMotorSpeed_1;
        RightMotorSpeed_1 = rightMotorSpeed_1;
        LeftMotorSpeed_2 = leftMotorSpeed_2;
        RightMotorSpeed_2 = rightMotorSpeed_2;
    }

    public LineFollow() {
        super();
    }

    public LineFollow(int id, int targetIntensity, int leftMotorSpeed_1, int rightMotorSpeed_1,
            int leftMotorSpeed_2, int rightMotorSpeed_2) {
        super();
        this.Id = id;
        this.LeftMotorSpeed_1 = leftMotorSpeed_1;
        this.RightMotorSpeed_1 = rightMotorSpeed_1;
        this.LeftMotorSpeed_2 = leftMotorSpeed_2;
        this.RightMotorSpeed_2 = rightMotorSpeed_2;
        this.targetIntensity = targetIntensity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getTargetIntensity() {
        return targetIntensity;
    }

    public void setTargetIntensity(int targetIntensity) {
        this.targetIntensity = targetIntensity;
    }

    public int getLeftMotorSpeed_1() {
        return LeftMotorSpeed_1;
    }

    public void setLeftMotorSpeed_1(int leftMotorSpeed_1) {
        LeftMotorSpeed_1 = leftMotorSpeed_1;
    }

    public int getRightMotorSpeed_1() {
        return RightMotorSpeed_1;
    }

    public void setRightMotorSpeed_1(int rightMotorSpeed_1) {
        RightMotorSpeed_1 = rightMotorSpeed_1;
    }

    public int getLeftMotorSpeed_2() {
        return LeftMotorSpeed_2;
    }

    public void setLeftMotorSpeed_2(int leftMotorSpeed_2) {
        LeftMotorSpeed_2 = leftMotorSpeed_2;
    }

    public int getRightMotorSpeed_2() {
        return RightMotorSpeed_2;
    }

    public void setRightMotorSpeed_2(int rightMotorSpeed_2) {
        RightMotorSpeed_2 = rightMotorSpeed_2;
    }

    @Override
    public String toString() {
        return "#" + Id + "#" + LeftMotorSpeed_1  + "#" + LeftMotorSpeed_2 + "#" + RightMotorSpeed_1 + "#" + RightMotorSpeed_2 + "#" + targetIntensity ;
               
    }
}
