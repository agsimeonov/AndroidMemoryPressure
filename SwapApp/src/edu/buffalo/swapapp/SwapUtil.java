package edu.buffalo.swapapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Environment;

public final class SwapUtil {
	public static final String FILE_PREPEND = "edu.buffalo.swap.";
	
	public static FileOutputStream getFileOutputStream(Context context, int id, boolean internal) {
		if (internal) {
			try {
				return context.openFileOutput(FILE_PREPEND + id, Context.MODE_PRIVATE);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			if (isExternalStorageWritable()) {
				File file = new File(context.getExternalFilesDir(null), FILE_PREPEND + id);
				try {
					return new FileOutputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				return null;
			}
		}
	}
	
	public static FileInputStream getFileInputStream(Context context, int id, boolean internal) {
		if (internal) {
			try {
				return context.openFileInput(FILE_PREPEND + id);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			if (isExternalStorageWritable()) {
				File file = new File(context.getExternalFilesDir(null), FILE_PREPEND + id);
				try {
					return new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				return null;
			}
		}
	}
	
	public static boolean isExternalStorageWritable() {
	    if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
	        return true;
	    else
	    	return false;
	}
}
