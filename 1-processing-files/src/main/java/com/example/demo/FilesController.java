package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Controller
@AllArgsConstructor
@RequestMapping("files")
public class FilesController {

    @PostMapping
    @SneakyThrows
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("Upload file !");

        long start = System.currentTimeMillis();

        byte[] bytes = file.getBytes();
        Path path = Paths.get("" + file.getOriginalFilename());
        Files.write(path, bytes);

        TimeUnit.SECONDS.sleep(10);

        long stop = System.currentTimeMillis();

        return "Uploaded. Operation took "+ (stop - start);
    }
}
