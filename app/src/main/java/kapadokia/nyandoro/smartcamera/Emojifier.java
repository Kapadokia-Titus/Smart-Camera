package kapadokia.nyandoro.smartcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


public class Emojifier {

    public  static final String LOG_TAG ="smartcamera.Emojifier";

    static void detectFaces(Context context, Bitmap bitmap){


        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                                .setTrackingEnabled(false)
                                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                                .build();

        //build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        //Detect face
        SparseArray<Face> faces = detector.detect(frame);

        //Log the number of faces.
        Log.d(LOG_TAG, "detectFaces: Number of faces =" + faces.size());

        //if there are no faces detected, show a toast message
        if (faces.size() == 0){
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        //release the detector
        detector.release();
    }
}
