package edu.buffalo.swapapp;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    List<byte[]> byteList= new LinkedList<byte[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showAvailableMemory();
    }
    
    private void showAvailableMemory() {
        ActivityManager activityManager =  (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Log.i("memory footprint", "" + memoryInfo.availMem / memoryInfo.totalMem + "%");
        Log.i("TOTAL MEMORY", "" + (MemInfo.getTotalMem() >> 20));
        Log.i("AVAILABLE MEMORY", "" + (MemInfo.getAvailableMem(this) >> 20));
        Log.i("FREE MEMORY", "" + (MemInfo.getFreeMem() >> 20));
        Log.i("THRESHOLD MEMORY", "" + (memoryInfo.threshold >> 20));

        Log.i("max heap", "" + (MemInfo.getMaxHeap() >>20));
        Log.i("current heap", "" + (MemInfo.getCurrentHeap() >>20)); 
        Log.i("used heap", "" + (MemInfo.getUsedHeap() >>20));   
        allocateMemory(5<<20);
        Log.i("max heap", "" + (MemInfo.getMaxHeap() >>20));
        Log.i("current heap", "" + (MemInfo.getCurrentHeap() >>20)); 
        Log.i("used heap", "" + (MemInfo.getUsedHeap() >>20));   
    }
    
    
    private void allocateMemory(int bytes) {
        byteList.add(new byte[bytes]);
    }
}
