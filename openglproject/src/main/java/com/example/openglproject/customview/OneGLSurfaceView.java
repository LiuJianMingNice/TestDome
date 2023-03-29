package com.example.openglproject.customview;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.example.openglproject.renderer.OneGlRenderer;

public class OneGLSurfaceView extends GLSurfaceView {
    private final OneGlRenderer mRenderer;
    public OneGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);

        mRenderer = new OneGlRenderer();

        setRenderer(mRenderer);
    }

}
