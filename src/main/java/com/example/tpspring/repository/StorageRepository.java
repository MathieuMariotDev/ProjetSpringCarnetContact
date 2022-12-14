package com.example.tpspring.repository;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageRepository {

    public void init();

    public void save(MultipartFile file);

    public Path load(String filename);

    Resource loadAsResource(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

}
