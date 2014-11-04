package edu.buffalo.swapapp;

import java.io.File;
import java.util.Scanner;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

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
        

        int pid = android.os.Process.myPid();
        Log.i("memory footprint", "" + (scanProcForField("/proc/"+pid+"/status", "VmSize") >>20));


        Log.i("memory footprint", "" + (MemInfo.getMaxHeap() >>20));
//        Log.i("memory footprint", "" + scanProcForField("/proc/"+pid+"/status", "VmSize"));
        
    }
    
    private static long scanProcForField(String path, String field) {
        File file = new File(path);
        Scanner scanner = null;
        field += ":";

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String token = scanner.next();
                if (token.equals(field))
                    return scanner.nextLong() << 10;  // It's in KB...
                String s = scanner.nextLine();
            }
        } catch (Exception e) {
            // Should we propagate this? Fall through for now.
            Log.e("MemUtil", "Error scanning "+file+" for "+field, e);
        } finally {
            if (scanner != null) scanner.close();
        } return -1;
    }
}
