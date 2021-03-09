package com.apps.demo.video;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoViewUtils {

    // "muoi_nam.mp4" in directory "raw".
    public static final String RAW_VIDEO_SAMPLE = "muoi_nam.mp4";
    public static final String LOCAL_VIDEO_SAMPLE ="/storage/emulated/0/Download/sample-mp4-file.mp4";
    public static final String URL_VIDEO_SAMPLE  = "https://raw.githubusercontent.com/o7planning/webexamples/master/_testdatas_/mov_bbb.mp4";
    public static final String LOG_TAG= "AndroidVideoView";


    // Play a video in directory RAW.
    public static void playRawVideo(Context context, VideoView videoView, String resName)  {
        try {
            String[] separated = resName.split("\\.");

            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/"+separated[0]);
            Log.i(LOG_TAG, "uri uri1: "+ uri);
            videoView.setVideoURI(uri);
            videoView.requestFocus();

        } catch (Exception e) {
            Log.e(LOG_TAG, "Error Play Raw Video: "+e.getMessage());
            Toast.makeText(context,"Error Play Raw Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public static void playLocalVideo(Context context, VideoView videoView, String localPath)  {
        try {
            Uri uri = Uri.parse(localPath);
            Log.i(LOG_TAG, "uri uri: "+ uri);
            videoView.setVideoURI(uri);
            videoView.requestFocus();

        } catch(Exception e) {
            Log.e(LOG_TAG, "Error Play Local Video: "+ e.getMessage());
            Toast.makeText(context,"Error Play Local Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public static void playURLVideo(Context context, VideoView videoView, String videoURL)  {
        try {
            Log.i(LOG_TAG, "Video URL: "+ videoURL);

            Uri uri= Uri.parse( videoURL );

            videoView.setVideoURI(uri);
            videoView.requestFocus();

        } catch(Exception e) {
            Log.e(LOG_TAG, "Error Play URL Video: "+ e.getMessage());
            Toast.makeText(context,"Error Play URL Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    // Find ID corresponding to the name of the resource (in the directory RAW).
    public static int getRawResIdByName(Context context, String resName) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "raw", pkgName);

        Log.i(LOG_TAG, "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}