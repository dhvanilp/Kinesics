package com.example.kinesics.processing.postprocessing;

import com.example.kinesics.imaging.IFrame;

public interface IFramePostProcessor {

    IFrame postProcess(IFrame inputFrame);

}
