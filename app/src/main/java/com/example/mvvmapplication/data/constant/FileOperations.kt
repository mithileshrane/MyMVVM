package com.example.mvvmapplication.data.constant

import android.os.Environment
import android.util.Log
import java.io.*

 class FileOperations private constructor() {
    fun write(fname: String, fcontent: String): Boolean? {
        var fcontent = fcontent
        try {

            fcontent = fcontent.replace(",", " ,\n")
            //            String fpath = "/sdcard/"+fname+".txt";
            val fpath = Environment.getExternalStorageDirectory().path + "/" + fname + ".txt"

            val file = File(fpath)

            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile()
            }

            val fw = FileWriter(file.absoluteFile, true)
            val bw = BufferedWriter(fw)
            bw.write(fcontent)
            bw.close()

            Log.e("LOGFILE", "Sucess")
            return true

        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }

    }

    fun read(fname: String): String? {

        var br: BufferedReader? = null
        var response: String? = null

        try {

            val output = StringBuffer()
            val fpath = "/sdcard/$fname.txt"

            br = BufferedReader(FileReader(fpath))
            var line = ""
            line = br.readLine()
            while (line != null) {
                output.append(line + "n")
            }
            response = output.toString()

        } catch (e: IOException) {
            e.printStackTrace()
            return null

        }

        return response

    }

    companion object {
        private var fileOperations: FileOperations? = null

        fun getInstance(): FileOperations {
            if (fileOperations == null) {
                fileOperations = FileOperations()
            }
            return fileOperations!!
        }



    }
}
