package com.yuxue.util;

import java.time.Duration;
import java.time.Instant;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yuxue.constant.Constant;

import lombok.extern.slf4j.Slf4j;


/**
 * 人脸识别工具类
 * 使用级联分类器进行目标检测
 * 对应的训练类为：com.yuxue.train.FaceCascadeTrain
 * @author yuxue
 * @date 2020-05-28 15:11
 */
@Slf4j
@Component
public class FaceUtil {

    private CascadeClassifier faceDetector;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    /**
     * 构造函数，加载默认模型文件
     */
    FaceUtil(){
        faceDetector = new CascadeClassifier("model/haarcascade_frontalface_default.xml"); // haar级联分类器

        // faceDetector = new CascadeClassifier("model/lbpcascade_frontalface.xml");  // lbp级联分类器
        log.info("成功加载级联分类器：" + faceDetector.getFeatureType());
    }

    /**
     * 加载自定义模型文件
     * @param modelPath
     */
    public void loadModel(String modelPath){
        if(!StringUtils.isEmpty(modelPath)) {
            faceDetector = new CascadeClassifier(modelPath);
        }
    }

    /**
     * 检测图片中的人脸
     * @param inMat
     * @param targetPath
     * @return
     */
    public MatOfRect detectFace(Mat inMat, String targetPath) {
        if(null == faceDetector || faceDetector.empty()) {
            log.error("加载模型文件失败!");
            return null;
        }

        MatOfRect faceDetections = new MatOfRect(); // 识别结果存储对象 // Rect矩形类

        faceDetector.detectMultiScale(inMat, faceDetections); // 识别人脸
        log.info(String.format("识别出 %s 张人脸", faceDetections.toArray().length));

        // 在识别到的人脸部位，描框
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(inMat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
            Imgcodecs.imwrite(targetPath, inMat);
        }
        return faceDetections;
    }


    /**
     * 识别图片中的人脸是谁
     * 未完待续
     * @return
     */
    public Object recogniseFace() {
        return null;
    }


    /**
     * 测试当前工具类
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();

        FaceUtil fu = new FaceUtil();
        Mat inMat = ImageUtil.imread(Constant.DEFAULT_FACE_DIR + "/train/huge/huge.png", CvType.CV_8UC3);

        fu.detectFace(inMat, Constant.DEFAULT_FACE_TEMP_DIR + "result.jpg");

        Instant end = Instant.now();
        System.err.println("总耗时：" + Duration.between(start, end).toMillis());
    }

}
