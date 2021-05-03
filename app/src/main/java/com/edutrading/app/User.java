package com.edutrading.app;

public class User {
    private static int Cash = 100;
    private static int Asset = 360;
    private static double MSFTNum = 1.0;

    public static void ChangeCash(int num){
        Cash = Cash-num;
        Asset = Asset+num;
    }

    public static void SubCash(int num){
        Cash = Cash+num;
        Asset = Asset-num;
    }

    public static int getCash(){
        return Cash;
    }

    public static int getAsset(){
        return Asset;
    }

    public static void AddMSFT(double change){
        MSFTNum = MSFTNum + change;
    }

    public static void SubMSFT(double change){
        MSFTNum = MSFTNum - change;
    }

    public static double getMSFTNum(){
        return MSFTNum;
    }
}
