package com.example.kinesics.processing.preprocessing;

import com.example.kinesics.imaging.IFrame;

import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;

public interface IFramePreProcessor {

    IFrame preProcess(CvCameraViewFrame inputFrame);

}
