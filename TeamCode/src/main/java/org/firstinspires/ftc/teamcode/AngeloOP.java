package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="AngeloOP with Hunter's Good Succ™")

public class AngeloOP extends OpMode {
    private static final double GEAR_RATIO = 80 / 120;
    private DcMotor leftFront, rightFront, leftRear, rightRear,succ1,succ2;
    private Servo glyph;

    private boolean glyphState = false, lastState = false;

    @Override
    public void init() {
        telemetry.addData("Robot", "Started");
        telemetry.addData("Hunter's Succ™", "Good");
        telemetry.addData("Traps", "Gay");

        leftFront = (DcMotor) hardwareMap.get("lFront");
        rightFront = (DcMotor) hardwareMap.get("rFront");
        leftRear = (DcMotor) hardwareMap.get("lRear");
        rightRear = (DcMotor) hardwareMap.get("rRear");
        succ1 = (DcMotor) hardwareMap.get("succ1");
        succ2 = (DcMotor) hardwareMap.get("succ2");
        glyph = (Servo) hardwareMap.get("glyph");
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        double v1 = r * Math.cos(robotAngle) + rightX;
        double v2 = r * Math.sin(robotAngle) - rightX;
        double v3 = r * Math.sin(robotAngle) + rightX;
        double v4 = r * Math.cos(robotAngle) - rightX;
        leftFront.setPower(-v1);
        rightFront.setPower(v2);
        leftRear.setPower(-v3);
        rightRear.setPower(v4);

        double power0;
        double power1;
        double power2 = 0;
        if(gamepad1.dpad_up)
        {
            power0 = 1;
            power1 = -1;
        }
        else if(gamepad1.dpad_down)
        {
            power0 = -1;
            power1 = 1;
        }
        else
        {
            power0 = 0;
            power1 = 0;
        }
        succ1.setPower(power0);
        succ2.setPower(power1);
    }
}
