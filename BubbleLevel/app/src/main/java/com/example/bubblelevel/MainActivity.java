package com.example.bubblelevel;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor rotationVectorSensor;

    private FrameLayout mainLayout;
    private View horizonLine;
    private TextView angleText;


    private static final float LEVEL_THRESHOLD_DEGREES = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        horizonLine = findViewById(R.id.horizonLine);
        angleText = findViewById(R.id.angleText);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (rotationVectorSensor != null) {
            sensorManager.registerListener(this, rotationVectorSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            float[] rotationMatrix = new float[9];
            SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);

            float[] orientations = new float[3];
            SensorManager.getOrientation(rotationMatrix, orientations);


            float pitchDegrees = (float) Math.toDegrees(orientations[1]);
            float rollDegrees = (float) Math.toDegrees(orientations[2]);

            float absPitch = Math.abs(pitchDegrees);
            float absRoll = Math.abs(rollDegrees);


            float totalTilt = (float) Math.sqrt(pitchDegrees * pitchDegrees + rollDegrees * rollDegrees);


            horizonLine.setRotation(-rollDegrees);


            angleText.setText(String.format("Tilt: %.0f°", totalTilt));


            if (totalTilt < LEVEL_THRESHOLD_DEGREES) {
                mainLayout.setBackgroundColor(Color.parseColor("#00FF00"));
                angleText.setText("0°");
                angleText.setTextColor(Color.BLACK);
            } else {
                mainLayout.setBackgroundColor(Color.BLACK);
                angleText.setTextColor(Color.WHITE);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
