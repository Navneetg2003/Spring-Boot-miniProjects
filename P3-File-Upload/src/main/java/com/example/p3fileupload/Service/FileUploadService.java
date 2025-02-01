package com.example.p3fileupload.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    public final String UploadDir="F:\\movie";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;
        try{
//            InputStream is= multipartFile.getInputStream();
//            byte data[]=new byte[is.available()];
//            is.read(data);
//
//            FileOutputStream fos= new FileOutputStream(UploadDir+ File.separator +multipartFile.getOriginalFilename());
//            fos.write(data);
//            fos.flush();
//            fos.close();

            Files.copy(multipartFile.getInputStream(), Paths.get(UploadDir+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
