package com.roman.savuliak.agile.board.persistence;

/**
 * Created by Roman on 06.02.2018.
 */
public interface ISequenceDao {
    Long getNextSequenceId(String key);
}