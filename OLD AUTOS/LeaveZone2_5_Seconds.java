package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware;

/**
 * This autonomous mode will leave the specified alliance starting zone
 * by commanding the left & right motors for two seconds before stopping.
 */
@Autonomous
public class LeaveZone2_5_Seconds extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors & sensors.
        Hardware hw = new Hardware(hardwareMap);
        double drive_time = 2.5; //amount of time to drive forward in seconds
        waitForStart();

        // Start timer.
        ElapsedTime timer = new ElapsedTime();

        // Power robot forward for drive_time amount of seconds
        while (timer.seconds() < drive_time) {
            hw.right_motor.setPower(1);
            hw.left_motor.setPower(1);
        }

        // Stop drivetrain
        hw.left_motor.setPower(0);
        hw.right_motor.setPower(0);

        //raise pixel spear
        if(gamepad1.y){
            hw.pixel_spear.setPosition(0);
        }
        //lower pixel spear
        else if(gamepad1.x){
            hw.pixel_spear.setPosition(45);
        }

    }
}
