package com.example.myapplication;

public class items {
    private int imgsrc;
    private String text1;
    private String text2;
    public items(int imgsrc,String text1,String text2){
        this.imgsrc=imgsrc;
        this.text1=text1;
        this.text2=text2;
    }


    public int   getimgsrc(){

        return this.imgsrc;
    }

    public String gettxt1(){
        return this.text1;
    }
    public String gettxt2(){
        return this.text2;
    }
}