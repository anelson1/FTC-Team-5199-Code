package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Hunter's Good Succ™ (with added controller support)")
public class HuntersGoodSuccOPConJoystick extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor0 = null;
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Succ", "Free");
        telemetry.addData("Memes", "Dank");
        telemetry.addData("Traps", "Gay");

        telemetry.update();

        motor0  = hardwareMap.get(DcMotor.class, "Motor0");
        motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        motor2  = hardwareMap.get(DcMotor.class, "Motor2");
        motor3 = hardwareMap.get(DcMotor.class, "Motor3");
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

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
            motor0.setPower(power0);
            motor1.setPower(power1);
            motor2.setPower( .5 * gamepad1.left_stick_y);
            motor3.setPower((.5 * gamepad1.left_stick_y));


            telemetry.addData("Status", "Meme Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
