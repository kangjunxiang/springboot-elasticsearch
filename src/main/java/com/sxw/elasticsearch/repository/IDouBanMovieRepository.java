package com.sxw.elasticsearch.repository;


import com.sxw.elasticsearch.pojo.dto.DouBanMovieDTO;
import com.sxw.elasticsearch.pojo.entity.Page;
import com.sxw.elasticsearch.pojo.entity.QueryDTO;

public interface IDouBanMovieRepository {

    boolean save(DouBanMovieDTO movie);

    Page<DouBanMovieDTO> query(String queryString, int pageNo, int size);

    Page<DouBanMovieDTO> query(QueryDTO queryDTO, int pageNo, int size);

    DouBanMovieDTO get(String id);
}
