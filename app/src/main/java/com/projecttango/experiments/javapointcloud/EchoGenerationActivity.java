package com.projecttango.experiments.javapointcloud;

import android.app.Activity;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EchoGenerationActivity extends Activity {
    private ArrayList<Short> referenceClick;
    private ArrayList<Short> referenceClickRight;
    private float referenceClick_absMin;
    private float referenceClick_absMax;
    private float referenceClick_absMinRight;
    private float referenceClick_absMaxRight;
    private PointCloudActivity pointCloudActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AudioManager m_amAudioManager;
        m_amAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        m_amAudioManager.setMode(AudioManager.MODE_IN_CALL);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        m_amAudioManager.setSpeakerphoneOn(false);
//        System.out.println("EchoGenerationActivity--------------------onCreate---------------------");
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.activity_echo_generation);
        List<Short> generatedEcho = getIntent().getExtras().getParcelable("ReferenceClick");
        if(generatedEcho == null){
            System.out.println("HELLO FROM HERE");
        }else{
            System.out.println(generatedEcho.get(1));
        }
        */
        float[] infoBuf = getIntent().getFloatArrayExtra("Angle,ClosestDist,X,Y,Z");
        float attentuationRatio;
        float level = 9;
        attentuationRatio = (float) Math.pow(10, (double) -7 / 20);
//        System.out.println("EchoGenerationActivity ....onCreate....*...attenuationRatio: " + attentuationRatio);
        float echoAttenDefault = -9; //dB, default echo attenuation before trial-by-trial amplification
        attentuationRatio *= -((10 / 90) * Math.abs(infoBuf[0])) * echoAttenDefault * level;
        System.out.println("EchoGenerationActivity ....onCreate....*...attenuationRatio: " + attentuationRatio);
        long startTime = System.nanoTime();

        referenceClick = scaleTo16Bit(generateTone("r_click", 1)); /*TODO - OPTIMIZATION:  maybe obtain this as an extra from intent - maybe faster*/
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("1 The nanosec duration is ....." + duration );
        startTime = System.nanoTime();
        referenceClickRight = scaleTo16Bit(generateTone("r_click_right", 2)); /*TODO - OPTIMIZATION:  maybe obtain this as an extra from intent - maybe faster*/
         endTime = System.nanoTime();

         duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("2 The nanosec duration is ....." + duration );

        /*
        float[] floatBuffer = getIntent().getFloatArrayExtra("PointCloudFloatBuffer");
        echoGenerator(floatBuffer);
        */
        startTime = System.nanoTime();

        echoGeneratorWithInfoBuf(infoBuf);
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("3 The nanosec duration is ....." + duration);

        finish();
    }

    public short[] echoGeneratorWithInfoBuf(float[] pointInfoBuf) {
//        System.out.println(".....echoGenWithInfoBuf1 ................*...............*.................*.......");

        int Fs = 44100;              //Sampling rate

        //Convert points and distances to millimeters
        double angle = pointInfoBuf[0];
        double closestDist = pointInfoBuf[1];
        double x = pointInfoBuf[2] * 1000;
        double y = pointInfoBuf[3] * 1000;
        double z = pointInfoBuf[4] * 1000;
        int soundSpeed = 343290; //in mm/s
//        angle = 0;
//        closestDist = 10000;

//        //Time delay
        float timeToTravel = ((float) closestDist) / soundSpeed;
//
//        //Delay the reference signal to generate echo
        boolean ref = true;
        /*baseline attenuation of echo (to be softer than the click)*/
        float echoAttenDefault = -3; // dB, default echo attenuation before trial-by-trial amplification, random

        /*baseline attenuation of echo (to be softer than the click)*/
        double baselineAttenuation = Math.pow(10, echoAttenDefault / 20);
        /*amplify based on levelStart and stepSize*/
        double amplification = Math.pow(10, 9.0 / 20.0);
        /*
        % Delays and further attenuates echo based on distance.
        % Attenuate the echo 6dB for each doubling of distance (empirical data)
        % Reference distance for the attenuation is 1 meter, so the number of
                % doublings is log2(distance)
                */
        double furtherAttenuation = Math.pow(10, -6.0 * (Math.log(closestDist / 1000) / Math.log(2)) / 20);
        /*Interaural attenuation*/
        double interauralAttenuation = Math.pow(10, -(10.0 / 90.0) * Math.abs(angle) / 20.0);

        List<Short> delayedEcho = prependDelay(referenceClick, timeToTravel, Fs, ref);
        List<Short> delayedEchoRight = prependDelay(referenceClickRight, timeToTravel, Fs, ref);
//        System.out.println(".....echoGen4 ................*...............delayTime = " + timeToTravel);
//        System.out.println(".....echoGen4 ................*...............interauralAttentuation = " + interauralAttenuation);
//        System.out.println(".....echoGen4 ................*...............10 raised to this = " +  -(10.0 / 90.0) * Math.abs(90.0) / 20.0);
//        System.out.println(".....echoGen4 ................*...............10 raised to the ^ = " +  Math.pow(10, -(10.0 / 90.0) * Math.abs(90.0) / 20.0));
//        System.out.println(".....echoGen4 ................*...............baseline = " + baselineAttenuation);
//        System.out.println(".....echoGen4 ................*...............amplification = " + amplification);
//        System.out.println(".....echoGen4 ................*...............furtherAttenuation = " + furtherAttenuation + ", " + Math.log(closestDist / 1000) / Math.log(2) + ", " + -6.0 * (Math.log(closestDist / 1000) / Math.log(2)) + ", " + -6.0 * (Math.log(closestDist / 1000) / Math.log(2)) / 20);

        short[] echoBinaural = ITDfromangle_andConcat(closestDist, angle, delayedEcho, delayedEchoRight, baselineAttenuation * amplification * furtherAttenuation, interauralAttenuation, Fs);

        return echoBinaural;
    }

    /**
     * @param T
     * @param Fs
     * @param ref if true, then echo is concatenated to the delayed source.
     * @return return an array of two List</Short> lists:  index0 contains the left, and index1 contains the right
     */

    private List<Short> prependDelay(List<Short> src, float T, int Fs, boolean ref) {
        //delay Delays an input signal by the given time.
        //src - The source signal
        //T - The amount of time(in seconds) to delay the signal by
        //Fs - The sampling frequency of src
        ArrayList<Short> echo = new ArrayList<Short>(Collections.nCopies((int) (T * Fs), (short) 0));
        echo.addAll(src);
        return echo;
    }


    private short[] ITDfromangle2(double closestDist, double angle, List<Short> echoDelayed, List<Short> echoDelayedRight, int Fs) {
//        System.out.println(".....ITD ................*...............*.................*.......");

        //ITDfromangle Calculates the ITD value based on the angle
        //angle = angle in degrees
        //echoBinaural = Echo for two ears based on ITD calculated
        //ITD = the time difference in usec between two ears based on the angle
        //Assumptions:
        //The ITD value is independent of distance of the object and only
        //depends on angle
        //The ITD values change linearly from 0 to 650 usec as
        //medium of travel is dry air so speed of sound = 343 m / s
        double ITD = (65 / 9) * angle;
        if (Fs == 0) {
            return null;
        }
        float timePerSample = (float) 1 / Fs * 1000000;//(in usec)
        int sampleDelay = (int) Math.abs(Math.ceil(ITD / timePerSample));
        List<Short> echoLeft;
        List<Short> echoRight;
        int echoRightSize;
        int echoLeftSize;
        int echoDelayedSize = echoDelayed.size();
        int largestArraySize = sampleDelay + echoDelayedSize;
        if (angle < 0) {
            echoRight = new ArrayList<Short>(Collections.nCopies(sampleDelay, (short) 0));
            echoRight.addAll(echoDelayedRight);
            echoLeft = echoDelayed;
//            echoLeft.addAll(delay);
            echoRightSize = largestArraySize;
            echoLeftSize = largestArraySize; //echoDelayedSize;
        } else {
            echoLeft = new ArrayList<Short>(Collections.nCopies(sampleDelay, (short) 0));
            echoLeft.addAll(echoDelayed);
            echoRight = echoDelayedRight;
//            echoRight.addAll(delay);
            echoRightSize = largestArraySize; //echoDelayedSize;
            echoLeftSize = largestArraySize;
        }
//        System.out.println(".....ITD2 ................*...............*.................*.......");
        int echoBinauralSize = largestArraySize * 2;
        short[] echoBinaural = new short[echoBinauralSize]; //auto initialized to 0
        int counter = 0;
        int counter_adjusted = 0;
        while (counter_adjusted < largestArraySize) {
            if (echoRightSize <= counter_adjusted) {// !rightIter.hasNext() condition
                echoBinaural[counter] = echoLeft.get(counter_adjusted);
            } else if (echoLeftSize <= counter_adjusted) {// !leftIter.hasNext() condition
                echoBinaural[counter + 1] = echoRight.get(counter_adjusted);
            } else {// rightIter && leftIter .hasNext() condition
                echoBinaural[counter + 1] = echoRight.get(counter_adjusted);
                echoBinaural[counter] = echoLeft.get(counter_adjusted);
            }
            counter = counter + 2;
            counter_adjusted++;
        }
//        System.out.println(".....ITD 3................*...............*.................*.......");

        assert counter == largestArraySize;
//        System.out.println(".....ITD 4................*...............*.................*.......");
//
//        System.out.println(".....closestDist= " + closestDist + " ; Angle = " + angle + "..........................");
//        //Client.sendShortArray(echoBinaural);
        echoRight.add((short) closestDist);
        echoRight.add((short) angle);
//        EchoGeneratorClass echoGeneratorClass = new EchoGeneratorClass(echoRight, echoLeft, this);
//        echoGeneratorClass.doInBackground(null);
        writeAndPlay(echoBinaural, Fs);

//

//        System.out.println(".....ITD 6................*...............*.................*.......");
        return echoBinaural;

    }

    private short[] ITDfromangle_andConcat(double closestDist, double angle, List<Short> echoDelayed, List<Short> echoDelayedRight, double attenuationRatio, double interauralAttenuation, int Fs) {
        double attenuateReference = 1;
        if (attenuationRatio > 1) {
            attenuateReference = 1 / attenuationRatio;
            attenuationRatio = 1;
        }
//        System.out.println(".....ITD ................*................*..................*........");
        /*
        Ensure equal sizes for adding aka superposition concatenation
         */

        //ITDfromangle Calculates the ITD value based on the angle
        //angle = angle in degrees
        //echoBinaural = Echo for two ears based on ITD calculated
        //ITD = the time difference in usec between two ears based on the angle
        //Assumptions:
        //The ITD value is independent of distance of the object and only
        //depends on angle
        //The ITD values change linearly from 0 to 650 usec as
        //medium of travel is dry air so speed of sound = 343 m / s
        double ITD = (65 / 9) * angle;
        if (Fs == 0) {
            return null;
        }
        float timePerSample = (float) 1 / Fs * 1000000;//(in usec)
        int sampleDelay = (int) Math.abs(Math.ceil(ITD / timePerSample));
        List<Short> echoLeft;
        List<Short> echoRight;
        List<Short> delay = new ArrayList<Short>(Collections.nCopies(sampleDelay, (short) 0));
        int echoRightSize;
        int echoLeftSize;
        int echoDelayedSize = echoDelayed.size();
        int largestArraySize = sampleDelay + echoDelayedSize;
        double interauralAttenLeft = 1;
        double interauralAttenRight = 1;
        if (angle < 0) {
            /*Prepend delay to right echo, postpend delay to left angle*/
            echoRight = new ArrayList<Short>(Collections.nCopies(sampleDelay, (short) 0));
            echoRight.addAll(echoDelayedRight);
            echoDelayedRight = echoRight;
            echoDelayed.addAll(delay);
            interauralAttenRight = interauralAttenuation;
        } else {
            /*Prepend delay to left echo, postpend delay to right angle*/
            echoLeft = new ArrayList<Short>(Collections.nCopies(sampleDelay, (short) 0));
            echoLeft.addAll(echoDelayed);
            echoDelayed = echoLeft;
            echoDelayedRight.addAll(delay);
            interauralAttenLeft = interauralAttenuation;
        }
        int diff = echoDelayed.size() - referenceClick.size(); /* TODO:  this stuff with differences can be combined in calculations so we only do addAll's at a minimal*/
        if (diff > 0) {
            referenceClick.addAll(Collections.nCopies(diff, (short) 0));
            referenceClickRight.addAll(Collections.nCopies(diff, (short) 0));
        } else {
            echoDelayed.addAll(Collections.nCopies(diff, (short) 0));
            echoDelayedRight.addAll(Collections.nCopies(diff, (short) 0));
        }
//        System.out.println(".....ITD2 ................*...............*.................*.......");
        int echoBinauralSize = largestArraySize * 2;
        short[] echoBinaural = new short[echoBinauralSize]; //auto initialized to 0
        int counter = 0;
        int counter_adjusted = 0;
        echoLeft = new ArrayList<Short>();
        echoRight = new ArrayList<Short>();

        referenceClick = scaleTo16Bit(generateTone("r_click", 1)); /*TODO - OPTIMIZATION:  maybe obtain this as an extra from intent - maybe faster*/
        long startTime = System.nanoTime();
        while (counter_adjusted < referenceClick.size()) {
            /*Left at index i*/
            echoBinaural[counter] = (short) (echoDelayed.get(counter_adjusted) * attenuationRatio * interauralAttenLeft + referenceClick.get(counter_adjusted) * attenuateReference);
            /*Right at index i+1*/
            echoBinaural[counter + 1] = (short) (echoDelayedRight.get(counter_adjusted) * attenuationRatio * interauralAttenRight + referenceClickRight.get(counter_adjusted) * attenuateReference);
            echoLeft.add(echoBinaural[counter]);
            echoRight.add(echoBinaural[counter + 1]);
            counter_adjusted++;
            counter = counter + 2;
        }
         long endTime = System.nanoTime();
        long duration = (endTime - startTime)/ 1000000;
        System.out.println("4 The nanosec duration is ....." + duration );

//        System.out.println(".....ITD 3................*...............*..l...............*.......");


//        System.out.println(".....closestDist= " + closestDist + " ; Angle = " + angle + "..........................");
//        //Client.sendShortArray(echoBinaural);
//
//        echoRight.add((short) angle);
//        echoRight.add((short) closestDist);
//        Client.send(echoLeft, echoRight);
        writeAndPlay(echoBinaural, Fs);

//

        System.out.println(".....ITD 6................*...............*........attenuationRatio = " + attenuationRatio);
//        System.out.println(".....ITD 7................*...............*........size of echoRight = " + echoRight.size() + " and echoLeft = " + echoLeft.size());
//        System.out.println(".....ITD 8................*...............*........interaural attenuations (Left) = " + interauralAttenLeft + " and (Right) = " + interauralAttenRight + ", and interaural = " + interauralAttenuation);
        return echoBinaural;

    }



    public void writeAndPlay(short[] binaural, int Fs) {
        int streamType = AudioManager.STREAM_MUSIC;
        int sampleRateInHz = Fs;
        int channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        int bufferSizeInBytes = binaural.length * 4; //two bytes per short
        int mode = AudioTrack.MODE_STATIC;
//        System.out.println(".....writeAndPlay 1................*...............*.................*.......");
        for (int i = 0; i < 1; i++) {

            AudioTrack player = new AudioTrack(streamType, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes, mode);
//            System.out.println(".....writeAndPlay 2................*...............*.................*.......");

            int offsetInShorts = 0;
            int sizeInShorts = binaural.length;
            player.write(binaural, offsetInShorts, sizeInShorts);
//            System.out.println(".....writeAndPlay 3................*...............*.................*.......");

            player.play();
//            System.out.println(".....writeAndPlay 4................*...............*.................*.......");

            try {
                Thread.sleep(30);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            player.release();

        }
//        System.out.println(".....writeAndPlay 5................*...............*.................*.......");

    }


    private ArrayList<Float> generateTone(String filename, int option) {
//        System.out.println("gen1");
        if (option == 1) {
            referenceClick_absMax = 0;
            referenceClick_absMin = 0;
        }
        if (option == 2) {
            referenceClick_absMaxRight = 0;
            referenceClick_absMinRight = 0;
        }
        ArrayList<Float> list = new ArrayList<Float>();
        String mLine;
        boolean first = true;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename)));
            // do reading, usually loop until end of file reading
            while ((mLine = reader.readLine()) != null) {
                float parsed = Float.parseFloat(mLine);
                list.add(parsed); //add the signed parsed integer
                parsed = Math.abs(parsed);
                if (first) {
                    if (option == 1) {
                        referenceClick_absMax = parsed;
                        referenceClick_absMin = parsed;
                    } else if (option == 2) {
                        referenceClick_absMaxRight = parsed;
                        referenceClick_absMinRight = parsed;
                    }
                    first = false;
                } else {
                    if (parsed > referenceClick_absMax) {
                        if (option == 1) {
                            referenceClick_absMax = parsed;
                        }
                        if (option == 2) {
                            referenceClick_absMaxRight = parsed;
                        }
                    }
                    if (parsed < referenceClick_absMin) {
                        if (option == 1) {
                            referenceClick_absMin = parsed;
                        }
                        if (option == 2) {
                            referenceClick_absMinRight = parsed;

                        }
                    }
                }
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return list;
    }

    /**
     * @param aList
     * @return
     */
    private ArrayList<Short> scaleTo16Bit(ArrayList<Float> aList) {

//        System.out.println("....scaleTo16Bit.....................*...................*..................*.");
        ArrayList<Short> bList = new ArrayList<Short>();
        float denom;
        if (referenceClick_absMin == referenceClick_absMax) {
            denom = referenceClick_absMax;
        } else {
            denom = referenceClick_absMax - referenceClick_absMin;
        }
        for (int i = 0; i < aList.size(); i++) {
            float elem = aList.get(i);
            float sign = Math.signum(elem);
            float factor = 0;
            if (sign < 0) {
                factor = ((float) 1 / denom) * 32768 ; // * 64;
            } else {
                factor = ((float) 1 / denom) * 32767 ;// * 64;
            }
            bList.add((short) (sign * factor * (((float) Math.abs(elem)) - referenceClick_absMin)));
        }
        return bList;
    }


}
