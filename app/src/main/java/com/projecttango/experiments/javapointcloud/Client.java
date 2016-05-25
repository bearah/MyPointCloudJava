package com.projecttango.experiments.javapointcloud;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public final class Client {
    private static String TAG = "ServerSocketTest";

    public static void send(List<Short> left, List<Short> right) {//for sending shorts

        try {

            System.out.println("*****send ************** 1 ***************************************" );

            String ip = "128.237.186.103";
            System.out.println("*****send ************** 2 ***************************************" );

            int port = 1337;
            Socket sock = new Socket(ip, port);
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            if(left!=null) {
                for (short leftElement : left) {
                    System.out.println("*****send ************** 3 **" + leftElement);
                    dos.writeShort(leftElement);
                }
            }

            if(right!=null) {
                for (short rightElement : right) {
                    System.out.println("*****send ************** 3 **" + rightElement);
                    dos.writeShort(rightElement);
                }
            System.out.println("*****send ************** 4 ** and num sent socket elements: " + (left.size()+right.size()));
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendShortArray(short[] array) {//for sending shorts

        try {

            System.out.println("*****send ************** 1 ***************************************" );

            String ip = "128.237.184.120";
            System.out.println("*****send ************** 2 ***************************************" );

            int port = 13373;
            Socket sock = new Socket(ip, port);
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            if(array!=null) {
                for (short elem : array) {
                    System.out.println("*****send ************** 3 **" + elem);
                    dos.writeShort(elem);
                }
            }

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendFloat(List<Float> floatList) {//for sending floats

        try {

            System.out.println("*****sendFloat ************** 1 ***************************************" );

            String ip = "192.168.2.38";
            System.out.println("*****sendFloat ************** 2 ***************************************" );

            int port = 1337;
            Socket sock = new Socket(ip, port);
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            for (float floatElem : floatList) {
                System.out.println("*****sendFloat ************* 3 **" + floatElem);
                dos.writeFloat(floatElem);
            }
         System.out.println("*****sendFloat ************** 4 ** and num sent socket elements: " + (floatList.size()));

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}