package com.de401.songrde.repository;

import com.de401.songrde.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>{

    public Album findByArtist(String artist);
}
