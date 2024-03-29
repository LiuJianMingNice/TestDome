package com.example.pdfhelper.rspdfview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.pdfhelper.rspdfview.interfaces.IPDFControl;
import com.example.pdfhelper.rspdfview.interfaces.IPDFOperateListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSScaleImageView
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSScaleImageView extends AppCompatImageView implements IPDFControl {

    private RSScaleImageView.MatrixTouchListener mListener;
    protected List<IPDFOperateListener> mListeners;
    private boolean isScrollDistance = true;

    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;

    public RSScaleImageView(Context context) {
        this(context, null);
    }

    public RSScaleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RSScaleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        mListener = new RSScaleImageView.MatrixTouchListener();
        setOnTouchListener(mListener);
        mGestureDetector = new GestureDetector(getContext(), new RSScaleImageView.GestureListener(mListener));
        setBackgroundColor(Color.WHITE);
        //将缩放类型设置为FIT_CENTER，表示把图片按比例扩大/缩小到View的宽度，居中显示
        setScaleType(ScaleType.FIT_CENTER);
    }

    private GestureDetector mGestureDetector;
    /**
     * 模板Matrix，用以初始化
     */
    private Matrix mMatrix = new Matrix();
    /**
     * 图片长度
     */
    private float mImageWidth;
    /**
     * 图片高度
     */
    private float mImageHeight;

    private void init() {
        mListeners = new ArrayList<>();
    }

    protected void previousPage() {
        Log.d("ljm", "previousPage====" + mListeners.size());
        for (IPDFOperateListener listener : mListeners) {
            if (listener != null) {
                listener.previousPage();
            }
        }
    }
    protected void nextPage() {
        for (IPDFOperateListener listener : mListeners) {
            if (listener != null) {
                listener.nextPage();
            }
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        // TODO Auto-generated method stub
        super.setImageBitmap(bm);
        setScaleType(ScaleType.FIT_CENTER);
        mMatrix.reset();
        float[] values = new float[9];
        mMatrix.getValues(values);

        //setImageMatrix(mMatrix);
        mListener.resetListener();
        //图片宽度为屏幕宽度除缩放倍数
        mImageWidth = bm.getWidth() / values[Matrix.MSCALE_X];
        mImageHeight = (bm.getHeight() - values[Matrix.MTRANS_Y] * 2) / values[Matrix.MSCALE_Y];
    }

    public void resetScale(int scale) {
        //mMatrix.reset();
        //mListener.resetListener(scale);
    }

    @Override
    public void addPDFOperateListener(IPDFOperateListener listener) {
        Log.d("ljm", "addPDFOperateListener");
        if (mListeners != null && listener != null) {
            mListeners.add(listener);
        }
    }

    @Override
    public void setThePageNumber(String number) {

    }

    public class MatrixTouchListener implements OnTouchListener {
        /**
         * 拖拉照片模式
         */
        private static final int MODE_DRAG = 1;
        /**
         * 放大缩小照片模式
         */
        private static final int MODE_ZOOM = 2;
        /**
         * 不支持Matrix
         */
        private static final int MODE_UNABLE = 3;
        /**
         * 最大缩放级别
         */
        float mMaxScale = 6;
        /**
         * 双击时的缩放级别
         */
        float mDoubleClickScale = 2;
        private int mMode = 0;//
        /**
         * 缩放开始时的手指间距
         */
        private float mStartDis;
        /**
         * 当前Matrix
         */
        private Matrix mCurrentMatrix = new Matrix();

        /**
         * 用于记录开始时候的坐标位置
         */
        private PointF startPoint = new PointF();

        public void resetListener() {
            mStartDis = 0;
            mCurrentMatrix.reset();
            startPoint.set(0, 0);
            mCurrentMatrix.setScale(1, 1);
            setImageMatrix(mCurrentMatrix);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (isScrollDistance) {
                return false;
            } else {
                // TODO Auto-generated method stub
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        //设置拖动模式
                        mMode = MODE_DRAG;
                        startPoint.set(event.getX(), event.getY());
                        isMatrixEnable();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        reSetMatrix();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (mMode == MODE_ZOOM) {
                            setZoomMatrix(event);
                        } else if (mMode == MODE_DRAG) {
                            setDragMatrix(event);
                        }
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        if (mMode == MODE_UNABLE) {
                            return true;
                        }
                        mMode = MODE_ZOOM;
                        mStartDis = distance(event);
                        break;
                    default:
                        break;
                }
                return mGestureDetector.onTouchEvent(event);
            }
        }

        public void setDragMatrix(MotionEvent event) {
            if (isZoomChanged()) {
                float dx = event.getX() - startPoint.x; // 得到x轴的移动距离
                float dy = event.getY() - startPoint.y; // 得到x轴的移动距离
                //避免和双击冲突,大于10f才算是拖动
                if (Math.sqrt(dx * dx + dy * dy) > 10f) {
                    startPoint.set(event.getX(), event.getY());
                    //在当前基础上移动
                    mCurrentMatrix.set(getImageMatrix());
                    float[] values = new float[9];
                    mCurrentMatrix.getValues(values);
                    dx = checkDxBound(values, dx);
                    dy = checkDyBound(values, dy);
                    mCurrentMatrix.postTranslate(dx, dy);
                    setImageMatrix(mCurrentMatrix);
                }
            }
        }

        /**
         * 判断缩放级别是否是改变过
         *
         * @return true表示非初始值, false表示初始值
         */
        private boolean isZoomChanged() {
            float[] values = new float[9];
            getImageMatrix().getValues(values);
            //获取当前X轴缩放级别
            float scale = values[Matrix.MSCALE_X];
            //获取模板的X轴缩放级别，两者做比较
            mMatrix.getValues(values);
            return scale != values[Matrix.MSCALE_X];
        }

        /**
         * 和当前矩阵对比，检验dy，使图像移动后不会超出ImageView边界
         *
         * @param values
         * @param dy
         * @return
         */
        private float checkDyBound(float[] values, float dy) {
            float height = getHeight();
            if (mImageHeight * values[Matrix.MSCALE_Y] < height) {
                return 0;
            }
            if (values[Matrix.MTRANS_Y] + dy > 0) {
                dy = -values[Matrix.MTRANS_Y];
            } else if (values[Matrix.MTRANS_Y] + dy < -(mImageHeight * values[Matrix.MSCALE_Y] - height)) {
                dy = -(mImageHeight * values[Matrix.MSCALE_Y] - height) - values[Matrix.MTRANS_Y];
            }
            return dy;
        }

        /**
         * 和当前矩阵对比，检验dx，使图像移动后不会超出ImageView边界
         *
         * @param values
         * @param dx
         * @return
         */
        private float checkDxBound(float[] values, float dx) {
            float width = getWidth();
            if (mImageWidth * values[Matrix.MSCALE_X] < width) {
                return 0;
            }
            if (values[Matrix.MTRANS_X] + dx > 0) {
                dx = -values[Matrix.MTRANS_X];
            } else if (values[Matrix.MTRANS_X] + dx < -(mImageWidth * values[Matrix.MSCALE_X] - width)) {
                dx = -(mImageWidth * values[Matrix.MSCALE_X] - width) - values[Matrix.MTRANS_X];
            }
            return dx;
        }

        /**
         * 设置缩放Matrix
         *
         * @param event
         */
        private void setZoomMatrix(MotionEvent event) {
            //只有同时触屏两个点的时候才执行
            if (event.getPointerCount() < 2) {
                return;
            }
            float endDis = distance(event);// 结束距离
            if (endDis > 10f) { // 两个手指并拢在一起的时候像素大于10
                float scale = endDis / mStartDis;// 得到缩放倍数
                mStartDis = endDis;//重置距离
                mCurrentMatrix.set(getImageMatrix());//初始化Matrix
                float[] values = new float[9];
                mCurrentMatrix.getValues(values);

                scale = checkMaxScale(scale, values);
                setImageMatrix(mCurrentMatrix);
            }
        }

        /**
         * 检验scale，使图像缩放后不会超出最大倍数
         *
         * @param scale
         * @param values
         * @return
         */
        private float checkMaxScale(float scale, float[] values) {
            if (scale * values[Matrix.MSCALE_X] > mMaxScale) {
                scale = mMaxScale / values[Matrix.MSCALE_X];
            }
            mCurrentMatrix.postScale(scale, scale, getWidth() / 2, getHeight() / 2);
            return scale;
        }

        /**
         * 重置Matrix
         */
        private void reSetMatrix() {
            if (checkRest()) {
                setScaleType(ScaleType.FIT_CENTER);
                mCurrentMatrix.set(mMatrix);
                setImageMatrix(mCurrentMatrix);
            }
        }

        /**
         * 判断是否需要重置
         *
         * @return 当前缩放级别小于模板缩放级别时，重置
         */
        private boolean checkRest() {
            // TODO Auto-generated method stub
            float[] values = new float[9];
            getImageMatrix().getValues(values);
            //获取当前X轴缩放级别
            float scale = values[Matrix.MSCALE_X];
            //获取模板的X轴缩放级别，两者做比较
            mMatrix.getValues(values);
            return scale < values[Matrix.MSCALE_X];
        }

        /**
         * 判断是否支持Matrix
         */
        private void isMatrixEnable() {
            //当加载出错时，不可缩放
            if (getScaleType() != ScaleType.CENTER) {
                setScaleType(ScaleType.MATRIX);
            } else {
                mMode = MODE_UNABLE;//设置为不支持手势
            }
        }

        /**
         * 计算两个手指间的距离
         *
         * @param event
         * @return
         */
        private float distance(MotionEvent event) {
            float dx = event.getX(1) - event.getX(0);
            float dy = event.getY(1) - event.getY(0);
            /** 使用勾股定理返回两点之间的距离 */
            return (float) Math.sqrt(dx * dx + dy * dy);
        }

        /**
         * 双击时触发
         */
        public void onDoubleClick() {
            float scale = isZoomChanged() ? 1 : mDoubleClickScale;
            mCurrentMatrix.set(mMatrix);//初始化Matrix
            mCurrentMatrix.postScale(scale, scale, getWidth() / 2, getHeight() / 2);
            setImageMatrix(mCurrentMatrix);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d("ljm","onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private final RSScaleImageView.MatrixTouchListener listener;

        public GestureListener(RSScaleImageView.MatrixTouchListener listener) {
            this.listener = listener;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            //捕获Down事件
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            //触发双击事件
            listener.onDoubleClick();
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            // TODO Auto-generated method stub

//            if (e1.getY()-e2.getY() > FLING_MIN_DISTANCE
//                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
//                // Fling left
//                Log.d("ljm", "向上手势");
//                nextPage();
//            } else if (e2.getY()-e1.getY() > FLING_MIN_DISTANCE
//                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
//                // Fling right
//                Log.d("ljm", "向下手势");
//                previousPage();
//            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub
            super.onShowPress(e);
        }


        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            // TODO Auto-generated method stub
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            // TODO Auto-generated method stub
            return super.onSingleTapConfirmed(e);
        }

    }

    private void clear() {
        if (mListeners != null) {
            mListeners.clear();
        }
    }
}