package com.projecttango.experiments.javapointcloud;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sarah on 3/29/16.
 */
public class EchoGenerationThread extends Thread {
    private PointCloudActivity context;
    private ArrayList<Short> referenceClick;
    private ArrayList<Short> referenceClickRight;
    private float [] infoBuf;


    public EchoGenerationThread(PointCloudActivity context, ArrayList<Short> referenceClick, ArrayList<Short> referenceClickRight, float[] infoBuf) {
        this.context = context;
        this.referenceClick = referenceClick;
        this.referenceClickRight = referenceClickRight;
        this.infoBuf = infoBuf;
        System.out.println("[EchoGenerationThread constructor()]......5.....*...........*............*...........*...........*");



    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            float attentuationRatio = 1;
            float level = 9;
            attentuationRatio = (float) Math.pow(10, (double) -7 / 20);
            this.infoBuf = context.infoBuf;
//        System.out.println("EchoGenerationActivity ....onCreate....*...attenuationRatio: " + attentuationRatio);
            float echoAttenDefault = -9; //dB, default echo attenuation before trial-by-trial amplification
            attentuationRatio *= 1; //-((10 / 90) * Math.abs(infoBuf[0])) * echoAttenDefault * level;
            System.out.println("[EchoGenerationThread]....infoBuf:: " + infoBuf[0] + ", " + infoBuf[1] + ", " + infoBuf[2] + ", " + infoBuf[3] + ", " + infoBuf[4]);
            long startTime = System.nanoTime();

            long endTime = System.nanoTime();

            long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        /*
        float[] floatBuffer = getIntent().getFloatArrayExtra("PointCloudFloatBuffer");
        echoGenerator(floatBuffer);
        */
            startTime = System.nanoTime();

            echoGeneratorWithInfoBuf(this.infoBuf);
            endTime = System.nanoTime();

            duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
            System.out.println("3 The nanosec duration is ....." + duration);

            //For test playing sound on Thread
            /*
            System.out.println("[EchoGenerationThread run()]...........*...........*............*...........*...........*");
            System.out.println("[EchoGenerationThread constructor()]......1.....*...........*............*...........*...........*");

            MediaPlayer mp = MediaPlayer.create(context, R.raw.bb);
            System.out.println("[EchoGenerationThread constructor()].......2....*...........*............*...........*...........*");

            mp.start();
            System.out.println("[EchoGenerationThread constructor()].......3....*...........*............*...........*...........*");

            mp.release();
            System.out.println("[EchoGenerationThread constructor()]......4.....*...........*............*...........*...........*");

            try {
                Thread.sleep(10000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[EchoGenerationThread constructor()]......5.....*...........*............*...........*...........*");

            try {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            */

        }


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
        angle = 0;
        closestDist = 10000;

//        //Time delay
        float timeToTravel = ((float) closestDist) * 2 / soundSpeed;
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
        System.out.println("[EchoGenerationThread] returned from ITDfromangle_andConcat");
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



    private short[] ITDfromangle_andConcat(double closestDist, double angle, List<Short> echoDelayed,
                                           List<Short> echoDelayedRight, double attenuationRatio,
                                           double interauralAttenuation, int Fs) {


        double attenuateReference = 1;
        if (attenuationRatio > 1) {
            attenuateReference = 1 / attenuationRatio;
            attenuationRatio = 1;
        }
        attenuationRatio = 1;
        interauralAttenuation = 1;
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

        long startTime = System.nanoTime();
        interauralAttenLeft = 1;
        interauralAttenRight = 1;
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


        System.out.println(".....closestDist= " + closestDist + " ; Angle = " + angle + "..........................");
//        //Client.sendShortArray(echoBinaural);

//        echoRight.add((short) angle);
//        echoRight.add((short) closestDist);
//        Client.send(echoLeft, echoRight);
        writeAndPlay(echoBinaural, Fs);

//

//        System.out.println(".....ITD 6................*...............*........attenuationRatio = " + attenuationRatio);
//        System.out.println(".....ITD 7................*...............*........size of echoRight = " + echoRight.size() + " and echoLeft = " + echoLeft.size());
        System.out.println(".....ITD 8................*...............*........interaural attenuations (Left) = " + interauralAttenLeft + " and (Right) = " + interauralAttenRight + ", and interaural = " + interauralAttenuation);
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




}
